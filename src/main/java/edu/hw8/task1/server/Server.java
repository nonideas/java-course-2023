package edu.hw8.task1.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int PORT = 1000;
    private static final int BUFFER_CAPACITY = 1024;
    private static final ResponseHandler RESPONSE_HANDLER = new ResponseHandler(BUFFER_CAPACITY);
    private static final int THREAD_POOL_SIZE = 5;
    private ExecutorService threadPool;

    public void run() throws IOException {
        threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (Selector selector = Selector.open()) {
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);
            try (ServerSocketChannel serverSocket = configureServerSocketChannel(selector)) {
                while (true) {
                    selector.select();
                    var selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
                    while (keyIterator.hasNext() && !selectionKeys.isEmpty()) {
                        SelectionKey key = keyIterator.next();
                        buffer.clear();
                        handleSelectionKey(selector, key, buffer, serverSocket);
                        keyIterator.remove();
                    }
                }
            } finally {
                selector.keys()
                    .forEach(selectionKey -> {
                        try {
                            selectionKey.channel().close();
                        } catch (Exception ex) {
                            LOGGER.warn(ex);
                        }
                    });
                threadPool.close();
            }
        }
    }

    private void handleSelectionKey(
        Selector selector,
        SelectionKey key,
        ByteBuffer buffer,
        ServerSocketChannel serverSocketChannel
    ) {
        if (key.isAcceptable()) {
            configureSocketChannel(selector, serverSocketChannel);
            LOGGER.info("Connect user");
        }
        if (key.isReadable()) {
            handleReadableKey(key, buffer);
        }
    }

    private void handleReadableKey(SelectionKey key, ByteBuffer buffer) {
        SocketChannel client = (SocketChannel) key.channel();

        int bytesToRead;
        try {
            bytesToRead = client.read(buffer);
        } catch (Exception e) {
            LOGGER.warn("Unable to read data from client");
            bytesToRead = -1;
        }

        if (bytesToRead == -1) {
            try {
                client.close();
            } catch (Exception e) {
                LOGGER.warn("Unable to close client");
                throw new RuntimeException(e);
            }
        } else {
            byte[] requestBytes = Arrays.copyOfRange(buffer.array(), 0, bytesToRead);

            threadPool.execute(() -> {
                try {
                    RESPONSE_HANDLER.getAndSendPhrase(requestBytes, client);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void configureSocketChannel(
        Selector selector,
        ServerSocketChannel serverSocketChannel
    ) {
        try {
            SocketChannel client = serverSocketChannel.accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
        } catch (Exception ex) {
            LOGGER.error("Unable to accept client");
            throw new RuntimeException(ex);
        }
    }

    private ServerSocketChannel configureServerSocketChannel(Selector selector) {
        ServerSocketChannel serverSocket;
        try {
            serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(PORT));
            serverSocket.configureBlocking(false);
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception ex) {
            LOGGER.error("Unable to configure server socket channel");
            throw new RuntimeException(ex);
        }
        return serverSocket;
    }
}

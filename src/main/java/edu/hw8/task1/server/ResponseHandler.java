package edu.hw8.task1.server;

import edu.hw8.task1.server.phraseDB.PhraseDB;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ResponseHandler {
    private static final PhraseDB PHRASE_DB = new PhraseDB();
    private final ByteBuffer byteBuffer;

    public ResponseHandler(int bufferCapacity) {
        byteBuffer = ByteBuffer.allocate(bufferCapacity);
    }

    public void getAndSendPhrase(byte[] bytes, SocketChannel socketChannel) {
        String request = new String(bytes, StandardCharsets.UTF_8).trim();
        String possiblePhrase = PHRASE_DB.getPhrase(request);
        sendResponse(possiblePhrase, socketChannel);
    }

    private void sendResponse(String message, SocketChannel client) {
        byteBuffer.clear()
            .put(message.getBytes())
            .flip();
        try {
            client.write(byteBuffer);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}

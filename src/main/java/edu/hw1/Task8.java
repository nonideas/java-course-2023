package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task8 {
    private final static int[][] MOVES = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    private final static Logger LOGGER = LogManager.getLogger();

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                for (int[] move : MOVES) {
                    int checkRow = i + move[0];
                    int checkCol = j + move[1];
                    if (checkRow >= 0 && checkRow < size && checkCol >= 0 && checkCol < size
                        && board[checkRow][checkCol] == 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

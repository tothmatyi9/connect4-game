package com.connect4game;

public class Board {
    private final char[][] grid;
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = '.';

    public Board() {
        grid = new char[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = EMPTY;
            }
        }
    }

    public boolean dropPiece(int col, char symbol) {
        if (col < 0 || col >= COLS || grid[0][col] != EMPTY) {
            return false;
        }
        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][col] == EMPTY) {
                grid[i][col] = symbol;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char symbol) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (checkDirection(row, col, 1, 0, symbol) || 
                    checkDirection(row, col, 0, 1, symbol) ||
                    checkDirection(row, col, 1, 1, symbol) ||
                    checkDirection(row, col, 1, -1, symbol)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int row, int col, int rowDir, int colDir, char symbol) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int r = row + i * rowDir;
            int c = col + i * colDir;
            if (r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] == symbol) {
                count++;
            } else {
                break;
            }
        }
        return count == 4;
    }

    public void printBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7");
    }
}

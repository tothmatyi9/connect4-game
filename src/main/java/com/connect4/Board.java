package com.connect4;

import java.util.Arrays;

public class Board {
    private final int rows = 6;
    private final int cols = 7;
    private final char[][] board;

    public Board() {
        board = new char[rows][cols];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
    }

    public boolean makeMove(int col, char symbol) {
        if (col < 0 || col >= cols) {
            return false;
        }
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][col] == '.') {
                board[row][col] = symbol;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char symbol) {
        // Implementáljuk a gyõzelmi feltételeket
        return false;
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
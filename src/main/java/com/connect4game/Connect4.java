package com.connect4game;

import java.util.Scanner;

public class Connect4 {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Connect4() {
        board = new Board();
        player1 = new Player("J�t�kos 1", 'X');
        player2 = new Player("J�t�kos 2", 'O');
        currentPlayer = player1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + " l�p�se (" + currentPlayer.getSymbol() + "): ");
            int col = scanner.nextInt() - 1;

            if (board.dropPiece(col, currentPlayer.getSymbol())) {
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.printBoard();
                    System.out.println(currentPlayer.getName() + " nyert!");
                    running = false;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("�rv�nytelen l�p�s! Pr�b�ld �jra.");
            }
        }
        scanner.close();
    }
} 

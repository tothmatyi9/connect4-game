package com.connect4;

import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player[] players;
    private int currentPlayerIndex;

    public Game() {
        board = new Board();
        players = new Player[]{new Player('X'), new Player('O')};
        currentPlayerIndex = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();
            System.out.println("Player " + players[currentPlayerIndex].getSymbol() + ", enter column (0-6): ");
            int col = scanner.nextInt();

            if (board.makeMove(col, players[currentPlayerIndex].getSymbol())) {
                if (board.checkWin(players[currentPlayerIndex].getSymbol())) {
                    System.out.println("Player " + players[currentPlayerIndex].getSymbol() + " wins!");
                    break;
                }
                currentPlayerIndex = 1 - currentPlayerIndex;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        scanner.close();
    }
}
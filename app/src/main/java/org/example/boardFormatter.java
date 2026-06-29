package org.example;

import static org.example.App.game;

public class boardFormatter {
    public static void printGameResult() {
        if (game.isDraw()) {
            System.out.println("Cat's Game!");
        } else {
            System.out.println("Player " + game.getWinner() + " wins!");
        }
    }

    public static void printBoard() {
        System.out.println();

        printRow(1, 2, 3);
        System.out.println("-----+-----+-----");
        printRow(4, 5, 6);
        System.out.println("-----+-----+-----");
        printRow(7, 8, 9);

        System.out.println();
    }

    public static void printRow(int first, int second, int third) {
        System.out.println("  " + getDisplayValue(first)
                + "  |  " + getDisplayValue(second)
                + "  |  " + getDisplayValue(third));
    }

    public static String getDisplayValue(int position) {
        char cell = game.getCell(position);

        if (cell == TicTacToeGame.empty) {
            return String.valueOf(position);
        }

        return String.valueOf(cell);
    }
}

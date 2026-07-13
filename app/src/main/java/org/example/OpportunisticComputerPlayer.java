package org.example;

import java.util.ArrayList;
import java.util.Random;

public class OpportunisticComputerPlayer {
    private final Random random = new Random();

    public int getMove(TicTacToeGame game) {
        if (getMoveCount(game) == 0) {
            int[] corners = {1, 3, 7, 9};
            return getRandomMove(game, corners);
        }

        if (getMoveCount(game) == 1 && game.isValidMove(5)) {
            return 5;
        }

        char computer = game.getCurrentPlayer();
        int winningMove = getWinningMove(game, computer);

        if (winningMove != 0) {
            return winningMove;
        }

        char opponent;

        if (computer == 'X') {
            opponent = 'O';
        } else {
            opponent = 'X';
        }

        int blockingMove = getWinningMove(game, opponent);

        if (blockingMove != 0) {
            return blockingMove;
        }

        int[] spaces = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        return getRandomMove(game, spaces);
    }

    private int getMoveCount(TicTacToeGame game) {
        int moveCount = 0;

        for (int position = 1; position <= 9; position++) {
            if (game.getCell(position) != TicTacToeGame.empty) {
                moveCount++;
            }
        }

        return moveCount;
    }

    private int getWinningMove(TicTacToeGame game, char player) {
        for (int position = 1; position <= 9; position++) {
            if (game.isWinningMove(player, position)) {
                return position;
            }
        }

        return 0;
    }

    private int getRandomMove(TicTacToeGame game, int[] spaces) {
        ArrayList<Integer> availableSpaces = new ArrayList<>();

        for (int space : spaces) {
            if (game.isValidMove(space)) {
                availableSpaces.add(space);
            }
        }

        if (availableSpaces.isEmpty()) {
            return 0;
        }

        int randomIndex = random.nextInt(availableSpaces.size());

        return availableSpaces.get(randomIndex);
    }
}

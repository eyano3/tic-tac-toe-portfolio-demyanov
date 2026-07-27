package org.example;
import java.util.ArrayList;
import java.util.Random;

public class AdjacentComputerPlayer {
    private final Random random = new Random();

    public int getMove(TicTacToeGame game) {
        int previousMove = game.getPreviousMove();

        int right = previousMove + 1;
        if (previousMove != 0 && previousMove % 3 != 0 && game.isValidMove(right)) {
            return right;
        }

        int left = previousMove - 1;
        if (previousMove != 0 && previousMove % 3 != 1 && game.isValidMove(left)) {
            return left;
        }

        int above = previousMove - 3;
        if (previousMove > 3 && game.isValidMove(above)) {
            return above;
        }

        int below = previousMove + 3;
        if (previousMove != 0 && previousMove <= 6 && game.isValidMove(below)) {
            return below;
        }

        return getRandomMove(game);
    }

    private int getRandomMove(TicTacToeGame game) {
        ArrayList<Integer> availableSpaces = new ArrayList<>();

        for (int position = 1; position <= 9; position++) {
            if (game.isValidMove(position)) {
                availableSpaces.add(position);
            }
        }

        if (availableSpaces.isEmpty()) {
            return 0;
        }

        int randomIndex = random.nextInt(availableSpaces.size());
        return availableSpaces.get(randomIndex);
    }
}

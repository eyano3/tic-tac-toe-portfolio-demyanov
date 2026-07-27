package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdjacentComputerPlayerTest {

    @Test
    public void firstMoveIsAValidAvailableSpace() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        int move = computerPlayer.getMove(game);

        assertTrue(game.isValidMove(move));
    }

    @Test
    public void computerMovesRightWhenRightIsAvailable() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        game.makeMove(5);

        int move = computerPlayer.getMove(game);

        assertEquals(6, move);
    }

    @Test
    public void computerMovesLeftWhenRightIsUnavailable() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        game.makeMove(6);
        game.makeMove(1);
        game.makeMove(5);

        int move = computerPlayer.getMove(game);

        assertEquals(4, move);
    }

    @Test
    public void computerMovesAboveWhenRightAndLeftAreUnavailable() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        game.makeMove(6);
        game.makeMove(4);
        game.makeMove(1);
        game.makeMove(9);
        game.makeMove(5);

        int move = computerPlayer.getMove(game);

        assertEquals(2, move);
    }

    @Test
    public void computerMovesBelowWhenOtherAdjacentCellsAreUnavailable() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        game.makeMove(6);
        game.makeMove(4);
        game.makeMove(2);
        game.makeMove(9);
        game.makeMove(5);

        int move = computerPlayer.getMove(game);

        assertEquals(8, move);
    }

    @Test
    public void computerMakesRandomMoveWhenAdjacentCellsAreUnavailable() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        game.makeMove(6);
        game.makeMove(4);
        game.makeMove(2);
        game.makeMove(8);
        game.makeMove(1);
        game.makeMove(9);
        game.makeMove(5);

        int move = computerPlayer.getMove(game);

        assertTrue(move == 3 || move == 7);
        assertTrue(game.isValidMove(move));
    }

    @Test
    public void rightEdgeDoesNotWrapToNextRow() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        game.makeMove(3);

        int move = computerPlayer.getMove(game);

        assertEquals(2, move);
    }

    @Test
    public void leftEdgeDoesNotWrapToPreviousRow() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        game.makeMove(5);
        game.makeMove(4);

        int move = computerPlayer.getMove(game);

        assertEquals(1, move);
    }

    @Test
    public void topRowMovesBelowWhenHorizontalCellsAreUnavailable() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        game.makeMove(3);
        game.makeMove(1);
        game.makeMove(2);

        int move = computerPlayer.getMove(game);

        assertEquals(5, move);
    }

    @Test
    public void computerMoveCanBePlacedOnBoard() {
        TicTacToeGame game = new TicTacToeGame();
        AdjacentComputerPlayer computerPlayer = new AdjacentComputerPlayer();

        game.makeMove(5);

        int move = computerPlayer.getMove(game);
        boolean moveWasMade = game.makeMove(move);

        assertTrue(moveWasMade);
        assertEquals('O', game.getCell(move));
    }
}
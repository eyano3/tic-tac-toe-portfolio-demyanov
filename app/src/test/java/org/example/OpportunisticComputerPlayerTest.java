package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OpportunisticComputerPlayerTest {

    @Test
    public void firstMoveIsACorner() {
        TicTacToeGame game = new TicTacToeGame();
        OpportunisticComputerPlayer computerPlayer = new OpportunisticComputerPlayer();

        int move = computerPlayer.getMove(game);

        assertTrue(move == 1 || move == 3 || move == 7 || move == 9);
    }

    @Test
    public void secondMoveIsCenterWhenCenterIsAvailable() {
        TicTacToeGame game = new TicTacToeGame();
        OpportunisticComputerPlayer computerPlayer = new OpportunisticComputerPlayer();

        game.makeMove(1);

        int move = computerPlayer.getMove(game);

        assertEquals(5, move);
    }

    @Test
    public void computerMakesWinningMove() {
        TicTacToeGame game = new TicTacToeGame();
        OpportunisticComputerPlayer computerPlayer = new OpportunisticComputerPlayer();

        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(2);
        game.makeMove(5);

        int move = computerPlayer.getMove(game);

        assertEquals(3, move);
    }

    @Test
    public void computerBlocksOpponentWinningMove() {
        TicTacToeGame game = new TicTacToeGame();
        OpportunisticComputerPlayer computerPlayer = new OpportunisticComputerPlayer();

        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(9);
        game.makeMove(5);

        int move = computerPlayer.getMove(game);

        assertEquals(6, move);
    }

    @Test
    public void winningMoveIsChosenBeforeBlockingMove() {
        TicTacToeGame game = new TicTacToeGame();
        OpportunisticComputerPlayer computerPlayer = new OpportunisticComputerPlayer();

        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(2);
        game.makeMove(5);

        int move = computerPlayer.getMove(game);

        assertEquals(3, move);
    }

    @Test
    public void randomMoveIsAValidAvailableSpace() {
        TicTacToeGame game = new TicTacToeGame();
        OpportunisticComputerPlayer computerPlayer = new OpportunisticComputerPlayer();

        game.makeMove(1);
        game.makeMove(5);

        int move = computerPlayer.getMove(game);

        assertTrue(game.isValidMove(move));
        assertNotEquals(1, move);
        assertNotEquals(5, move);
    }

    @Test
    public void computerMoveCanBePlacedOnBoard() {
        TicTacToeGame game = new TicTacToeGame();
        OpportunisticComputerPlayer computerPlayer = new OpportunisticComputerPlayer();

        int move = computerPlayer.getMove(game);
        boolean moveWasMade = game.makeMove(move);

        assertTrue(moveWasMade);
        assertEquals('X', game.getCell(move));
    }
}


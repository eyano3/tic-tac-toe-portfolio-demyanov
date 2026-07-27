package org.example;

public class TicTacToeGame {
    public static final char empty = ' ';
    public static final char draw = 'C';

    private final char[] board;
    private char currentPlayer;
    private boolean gameOver;
    private char winner;
    private int previousMove;

    public TicTacToeGame() {
        board = new char[9];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = empty;
        }

        currentPlayer = 'X';
        gameOver = false;
        winner = empty;
        previousMove = 0;
    }

    public boolean makeMove(int position) {
        if (!isValidMove(position)) {
            return false;
        }

        board[position - 1] = currentPlayer;
        previousMove = position;

        if (hasPlayerWon(currentPlayer)) {
            gameOver = true;
            winner = currentPlayer;
        } else if (isBoardFull()) {
            gameOver = true;
            winner = draw;
        } else {
            switchPlayer();
        }

        return true;
    }

    public boolean isValidMove(int position) {
        if (gameOver) {
            return false;
        }

        if (position < 1 || position > 9) {
            return false;
        }

        return board[position - 1] == empty;
    }

    public boolean isWinningMove(char player, int position) {
        if (!isValidMove(position)) {
            return false;
        }

        board[position - 1] = player;
        boolean winningMove = hasPlayerWon(player);
        board[position - 1] = empty;

        return winningMove;
    }

    public char getCell(int position) {
        return board[position - 1];
    }

    public int getPreviousMove() {return previousMove;}

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public char getWinner() {
        return winner;
    }

    public boolean isDraw() {
        return gameOver && winner == draw;
    }

    private void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    private boolean isBoardFull() {
        for (char cell : board) {
            if (cell == empty) {
                return false;
            }
        }

        return true;
    }

    private boolean hasPlayerWon(char player) {
        return hasLine(player, 1, 2, 3)
                || hasLine(player, 4, 5, 6)
                || hasLine(player, 7, 8, 9)
                || hasLine(player, 1, 4, 7)
                || hasLine(player, 2, 5, 8)
                || hasLine(player, 3, 6, 9)
                || hasLine(player, 1, 5, 9)
                || hasLine(player, 3, 5, 7);
    }

    private boolean hasLine(char player, int first, int second, int third) {
        return (board[first - 1] == player && board[second - 1] == player && board[third - 1] == player);
    }
}

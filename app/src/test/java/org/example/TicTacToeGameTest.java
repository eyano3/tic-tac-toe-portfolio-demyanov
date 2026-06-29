package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {

  @Test
  public void newGameStartsWithEmptyBoard() {
    TicTacToeGame game = new TicTacToeGame();

    assertEquals(TicTacToeGame.empty, game.getCell(1));
    assertEquals(TicTacToeGame.empty, game.getCell(2));
    assertEquals(TicTacToeGame.empty, game.getCell(3));
    assertEquals(TicTacToeGame.empty, game.getCell(4));
    assertEquals(TicTacToeGame.empty, game.getCell(5));
    assertEquals(TicTacToeGame.empty, game.getCell(6));
    assertEquals(TicTacToeGame.empty, game.getCell(7));
    assertEquals(TicTacToeGame.empty, game.getCell(8));
    assertEquals(TicTacToeGame.empty, game.getCell(9));
  }

  @Test
  public void newGameStartsWithXAsCurrentPlayer() {
    TicTacToeGame game = new TicTacToeGame();

    assertEquals('X', game.getCurrentPlayer());
  }

  @Test
  public void newGameIsNotOver() {
    TicTacToeGame game = new TicTacToeGame();

    assertFalse(game.isGameOver());
    assertFalse(game.isDraw());
    assertEquals(TicTacToeGame.empty, game.getWinner());
  }

  @Test
  public void validFirstMovePlacesXOnBoard() {
    TicTacToeGame game = new TicTacToeGame();

    boolean moveWasMade = game.makeMove(1);

    assertTrue(moveWasMade);
    assertEquals('X', game.getCell(1));
  }

  @Test
  public void currentPlayerSwitchesAfterValidMove() {
    TicTacToeGame game = new TicTacToeGame();

    game.makeMove(1);

    assertEquals('O', game.getCurrentPlayer());
  }

  @Test
  public void twoValidMovesPlaceXAndO() {
    TicTacToeGame game = new TicTacToeGame();

    game.makeMove(1);
    game.makeMove(2);

    assertEquals('X', game.getCell(1));
    assertEquals('O', game.getCell(2));
    assertEquals('X', game.getCurrentPlayer());
  }

  @Test
  public void moveBelowOneIsInvalid() {
    TicTacToeGame game = new TicTacToeGame();

    boolean moveWasMade = game.makeMove(0);

    assertFalse(moveWasMade);
    assertEquals('X', game.getCurrentPlayer());
    assertFalse(game.isGameOver());
  }

  @Test
  public void moveAboveNineIsInvalid() {
    TicTacToeGame game = new TicTacToeGame();

    boolean moveWasMade = game.makeMove(10);

    assertFalse(moveWasMade);
    assertEquals('X', game.getCurrentPlayer());
    assertFalse(game.isGameOver());
  }

  @Test
  public void moveInTakenCellIsInvalid() {
    TicTacToeGame game = new TicTacToeGame();

    game.makeMove(1);
    boolean moveWasMade = game.makeMove(1);

    assertFalse(moveWasMade);
    assertEquals('X', game.getCell(1));
    assertEquals('O', game.getCurrentPlayer());
  }

  @Test
  public void xCanWinAcrossTopRow() {
    TicTacToeGame game = new TicTacToeGame();

    game.makeMove(1);
    game.makeMove(4);
    game.makeMove(2);
    game.makeMove(5);
    game.makeMove(3);

    assertTrue(game.isGameOver());
    assertEquals('X', game.getWinner());
    assertFalse(game.isDraw());
  }

  @Test
  public void oCanWinDownFirstColumn() {
    TicTacToeGame game = new TicTacToeGame();

    game.makeMove(2);
    game.makeMove(1);
    game.makeMove(5);
    game.makeMove(4);
    game.makeMove(9);
    game.makeMove(7);

    assertTrue(game.isGameOver());
    assertEquals('O', game.getWinner());
    assertFalse(game.isDraw());
  }

  @Test
  public void xCanWinDiagonally() {
    TicTacToeGame game = new TicTacToeGame();

    game.makeMove(1);
    game.makeMove(2);
    game.makeMove(5);
    game.makeMove(3);
    game.makeMove(9);

    assertTrue(game.isGameOver());
    assertEquals('X', game.getWinner());
    assertFalse(game.isDraw());
  }

  @Test
  public void gameCanEndInDraw() {
    TicTacToeGame game = new TicTacToeGame();

    game.makeMove(1);
    game.makeMove(2);
    game.makeMove(3);
    game.makeMove(5);
    game.makeMove(4);
    game.makeMove(6);
    game.makeMove(8);
    game.makeMove(7);
    game.makeMove(9);

    assertTrue(game.isGameOver());
    assertTrue(game.isDraw());
    assertEquals(TicTacToeGame.draw, game.getWinner());
  }

  @Test
  public void movesAreNotAllowedAfterGameIsOver() {
    TicTacToeGame game = new TicTacToeGame();

    game.makeMove(1);
    game.makeMove(4);
    game.makeMove(2);
    game.makeMove(5);
    game.makeMove(3);

    boolean moveWasMade = game.makeMove(6);

    assertFalse(moveWasMade);
    assertEquals(TicTacToeGame.empty, game.getCell(6));
    assertTrue(game.isGameOver());
    assertEquals('X', game.getWinner());
  }

  @Test
  public void resetBoardStartsNewGame() {
    TicTacToeGame game = new TicTacToeGame();

    game.makeMove(1);
    game.makeMove(4);
    game.makeMove(2);
    game.makeMove(5);
    game.makeMove(3);

    game.resetBoard();

    assertEquals(TicTacToeGame.empty, game.getCell(1));
    assertEquals(TicTacToeGame.empty, game.getCell(2));
    assertEquals(TicTacToeGame.empty, game.getCell(3));
    assertEquals(TicTacToeGame.empty, game.getCell(4));
    assertEquals(TicTacToeGame.empty, game.getCell(5));
    assertEquals(TicTacToeGame.empty, game.getCell(6));
    assertEquals(TicTacToeGame.empty, game.getCell(7));
    assertEquals(TicTacToeGame.empty, game.getCell(8));
    assertEquals(TicTacToeGame.empty, game.getCell(9));

    assertEquals('X', game.getCurrentPlayer());
    assertFalse(game.isGameOver());
    assertFalse(game.isDraw());
    assertEquals(TicTacToeGame.empty, game.getWinner());
  }
}

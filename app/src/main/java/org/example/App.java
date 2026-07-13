package org.example;

import java.util.Scanner;

import static org.example.boardFormatter.printBoard;
import static org.example.boardFormatter.printGameResult;

public class App {
  private static final String invalidMoveMessage = "That is not a valid move. Try again: ";

  private static final Scanner scanner = new Scanner(System.in);
  private static final OpportunisticComputerPlayer computerPlayer =
          new OpportunisticComputerPlayer();

  private static int gameType;

  public static final TicTacToeGame game = new TicTacToeGame();

  public static void main(String[] args) {
    System.out.println("Welcome to Tic-Tac-Toe!");

    boolean keepPlaying = true;

    while (keepPlaying) {
      gameType = getGameType();

      if (isComputerTurn()) {
        makeComputerMove();
      }

      printBoard();

      while (!game.isGameOver()) {
        if (isComputerTurn()) {
          makeComputerMove();
          printBoard();

          if (game.isGameOver()) {
            printGameResult();
          }

          continue;
        }

        Integer move = getMoveFromUser();

        if (move == null || !game.makeMove(move)) {
          System.out.println(invalidMoveMessage);
          printBoard();
        } else {
          printBoard();

          if (game.isGameOver()) {
            printGameResult();
          }
        }
      }

      keepPlaying = askToPlayAgain();

      if (keepPlaying) {
        game.resetBoard();
      }
    }

    System.out.println("Thanks for playing!");
  }

  private static int getGameType() {
    while (true) {
      System.out.println();
      System.out.println("What kind of game would you like to play?");
      System.out.println();
      System.out.println("1. Human vs. Human");
      System.out.println("2. Human vs. Computer");
      System.out.println("3. Computer vs. Human");
      System.out.println();
      System.out.print("What is your selection? : ");

      String input = scanner.nextLine();
      input = input.trim();

      if (input.equals("1")) {
        return 1;
      }

      if (input.equals("2")) {
        System.out.println("Great! The computer will go second.");
        return 2;
      }

      if (input.equals("3")) {
        System.out.println("Great! The computer will go first.");
        return 3;
      }

      System.out.println("That is not a valid input.");
    }
  }

  private static boolean isComputerTurn() {
    if (gameType == 2 && game.getCurrentPlayer() == 'O') {
      return true;
    }

    return gameType == 3 && game.getCurrentPlayer() == 'X';
  }

  private static void makeComputerMove() {
    int move = computerPlayer.getMove(game);
    game.makeMove(move);
  }

  private static Integer getMoveFromUser() {
    System.out.print("What is your move? : ");

    String input = scanner.nextLine();
    input = input.trim();

    if (!input.matches("[1-9]")) {
      return null;
    }

    return Integer.parseInt(input);
  }

  private static boolean askToPlayAgain() {
    while (true) {
      System.out.print("Would you like to play again (yes/no)? : ");

      String input = scanner.nextLine();
      input = input.trim().toLowerCase();

      if (input.equals("yes")) {
        return true;
      }

      if (input.equals("no")) {
        return false;
      }

      System.out.println("That is not a valid input.");
    }
  }
}


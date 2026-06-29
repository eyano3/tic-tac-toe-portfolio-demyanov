package org.example;
import java.util.Scanner;
import static org.example.boardFormatter.printBoard;
import static org.example.boardFormatter.printGameResult;

public class App {
  private static final String invalidMoveMessage = "That is not a valid move. Try again: ";

  private static final Scanner scanner = new Scanner(System.in);
  public static final TicTacToeGame game = new TicTacToeGame();

  public static void main(String[] args) {
    System.out.println("Welcome to Tic-Tac-Toe!");

    boolean keepPlaying = true;

    while (keepPlaying) {
      printBoard();

      while (!game.isGameOver()) {
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
package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.ui.ConsoleUI;
import com.github.krzysiekjodlowski.ox.ui.UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Main entry to OX program. Runs the game with automated file input or user console input;
 *
 * @author Krzysztof Jodlowski
 */
final class App {

  /**
   * Creating Game and runs it. First it checks if there is any input file and
   * if there is it passes FileInputStream to Scanner object, if not, System.in.
   *
   * @param args file with custom input (expecting file content as first parameter)
   */
  public static void main(final String[] args) {
    Scanner scanner = setScanner(args);
    // in the future releases (when more UI implementations will appear) another
    // helper method checking UI chosen type will initialize the interface
    UI<String, Integer> ui = new ConsoleUI(scanner, new PrintStream(System.out));
    Game game = new OxConsoleGame(ui);
    game.run();
  }

  private static Scanner setScanner(String[] args) {
    Scanner scanner = null;
    if (args.length > 0) {
      try {
        scanner = new Scanner(
            new FileInputStream(new File(args[0]))
        );
      } catch (FileNotFoundException e) {
        System.out.println("File not found!");
      }
    } else {
      scanner = new Scanner(System.in);
    }
    return scanner;
  }
}


package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.ui.ConsoleUI;
import com.github.krzysiekjodlowski.ox.ui.UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Main entry to OX program. Runs the game with automated file input or user console input;
 *
 * @author Krzysztof Jodlowski
 */
final class App {

  /**
   * Initializes Game and runs it. First it checks if there is any input file and
   * if there is it passes FileInputStream to Scanner object, if not, System.in.
   *
   * @param args file with custom input (expecting file content as first parameter)
   */
  public static void main(final String[] args) throws UnsupportedEncodingException {
    Scanner scanner = initScanner(args);
    // in the future releases (when more UI implementations will appear) another
    // helper method checking UI chosen type will initialize the interface
    UI<String, Integer> ui = new ConsoleUI(scanner, new PrintStream(
        System.out, true, StandardCharsets.UTF_8)
    );
    // in the future releases Game field will appear and method checking game version
    // will work similarly to the one above
    new OxConsoleGame(ui).run();
  }

  private static Scanner initScanner(String[] args) {
    Scanner scanner = new Scanner(System.in);
    if (args.length > 0) {
      try {
        scanner = new Scanner(
            new FileInputStream(new File(args[0])), StandardCharsets.UTF_8
        );
      } catch (FileNotFoundException e) {
        System.out.println("File not found!");
      }
    }
    return scanner;
  }
}


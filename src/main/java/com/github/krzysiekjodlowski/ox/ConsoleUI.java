package com.github.krzysiekjodlowski.ox;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * {@inheritDoc} The console version.
 *
 * @author Krzysztof Jodlowski
 */
class ConsoleUI implements UI<String, Integer> {
  private final Scanner scanner;
  private final PrintStream printStream;

  ConsoleUI(Scanner scanner, PrintStream ps) {
    this.scanner = scanner;
    this.printStream = ps;
  }

  /**
   * {@inheritDoc}
   *
   * @param message String representation
   */
  @Override
  public void say(String message) {
    this.printStream.println(message);
  }

  /**
   * Get Integer from user within the provided NumberRange.
   *
   * @param range configurable range of Integers
   * @return user input Integer from provided range
   */
  @Override
  public Integer getNumberFromUser(NumberRange<Integer> range) {
    boolean correctInput = false;
    Integer input = 0;

    do {
      try {
        String tempInput = this.scanner.nextLine();
        input = Integer.parseInt(tempInput.split(" ")[0]);
      } catch (InputMismatchException e) {
        this.printStream.println("Provided input is not a number!");
        this.scanner.next();
        continue;
      }
      if (!range.numberInRange(input)) {
        this.printStream.println("Provided number is out of range!");
        continue;
      } else {
        correctInput = true;
      }
    } while (!correctInput);
    return input;
  }
}

package com.github.krzysiekjodlowski.ox.ui;

import com.github.krzysiekjodlowski.ox.NumberRange;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * {@inheritDoc} The console version.
 *
 * @author Krzysztof Jodlowski
 */
public class ConsoleUI implements UI<String, Integer> {
  private final Scanner scanner;
  private final PrintStream printStream;

  public ConsoleUI(Scanner scanner, PrintStream ps) {
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
   * {@inheritDoc}
   *
   * @param errorMessage String representation
   */
  @Override
  public void warn(String errorMessage) {
    this.printStream.println(String.format("\033[31m%s\033[0m", errorMessage));

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
    int input = 0;

    do {
      try {
        String tempInput = this.scanner.nextLine();
        input = Integer.parseInt(tempInput.split(" ")[0]);
      } catch (NumberFormatException e) {
        this.warn("Provided input is not a required number!");
        continue;
      }
      correctInput = this.getInputCorrectnessInTermsOfRange(!range.numberInRange(input));
    } while (!correctInput);
    return input;
  }

  private boolean getInputCorrectnessInTermsOfRange(boolean numberInRange) {
    if (numberInRange) {
      this.warn("Provided number is out of range!");
      return false;
    }
    return true;
  }
}

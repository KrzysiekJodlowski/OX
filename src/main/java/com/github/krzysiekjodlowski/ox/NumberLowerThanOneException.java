package com.github.krzysiekjodlowski.ox;

/**
 * When input provided in FieldNumber
 * static fabric methods is lower than 1.
 *
 * @author Krzysztof Jodlowski
 */
public class NumberLowerThanOneException extends Exception {
  public NumberLowerThanOneException() {
    super("Provided number is lower than one!");
  }
}

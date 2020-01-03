package com.github.krzysiekjodlowski.ox.model;

/**
 * Represents each player on Board.
 *
 * @author Krzysztof Jodlowski
 */
public enum Symbol {
  NAUGHT("O"), CROSS("X"), EMPTY(" ");

  private final String value;

  Symbol(final String value) {
    this.value = value;
  }

  /**
   * Useful in board representation.
   *
   * @return String representation of an enum
   */
  @Override
  public String toString() {
    return this.value;
  }
}

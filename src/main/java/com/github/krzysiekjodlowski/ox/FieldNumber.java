package com.github.krzysiekjodlowski.ox;

/**
 * Represents place on a game board chosen by player.
 *
 * @author Krzysztof Jodlowski
 */
class FieldNumber {
  private final int value;
  private static final int MIN_VALUE = 1;

  private FieldNumber(final int value) {
    this.value = value;
  }

  /**
   * Creates FieldNumber from String.
   *
   * @param s should be convertible to integer
   * @return FieldNumber representation
   * @throws NumberFormatException       when can't be converted to int
   * @throws NumberLowerThanOneException when input lower than MIN_VALUE
   */
  static FieldNumber from(String s) throws NumberFormatException, NumberLowerThanOneException {
    int input = Integer.parseInt(s);
    return valueOf(input);
  }

  /**
   * Creates FieldNumber from int.
   *
   * @param i should be bigger than MIN_VALUE
   * @return FieldNumber representation
   * @throws NumberLowerThanOneException when input lower than MIN_VALUE
   */
  static FieldNumber valueOf(int i) throws NumberLowerThanOneException {
    if (i < MIN_VALUE) {
      throw new NumberLowerThanOneException();
    }
    return new FieldNumber(i);
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof FieldNumber)) {
      return false;
    }
    FieldNumber that = (FieldNumber) o;
    return this.value == that.value;
  }

  @Override
  public int hashCode() {
    return this.value;
  }
}

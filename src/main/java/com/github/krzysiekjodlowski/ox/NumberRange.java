package com.github.krzysiekjodlowski.ox;

import java.math.BigDecimal;

/**
 * Keeps Number range provided by client.
 *
 * @author Krzysztof Jodlowski
 */
class NumberRange<Number> {
  private final Number minimalValue;
  private final Number maximumValue;
  private static final int COMPARISON_EQUALITY = 0;

  private NumberRange(Number minimalValue, Number maximumValue) {
    this.minimalValue = minimalValue;
    this.maximumValue = maximumValue;
  }

  /**
   * Static fabric method checking input order
   * and returning new NumberRange with properly
   * set values.
   *
   * @param minimalValue alleged lower bound of range
   * @param maximumValue alleged upper bound of range
   * @return new NumberRange object
   */
  static <Number> NumberRange of(Number minimalValue, Number maximumValue) {
    if (compare(minimalValue, maximumValue)
        > COMPARISON_EQUALITY) {
      return new NumberRange(maximumValue, minimalValue);
    } else {
      return new NumberRange(minimalValue, maximumValue);
    }

  }

  /**
   * Returns true if checked Number is within provided range.
   *
   * @param value concrete Number value to check
   * @return true if value is in range, false otherwise
   */
  boolean numberInRange(Number value) {
    return this.compare(minimalValue, value)
        <= COMPARISON_EQUALITY
        && this.compare(maximumValue, value)
        >= COMPARISON_EQUALITY;
  }

  /**
   * Compare two Numbers. Based on Comparator implementation
   * but not forced by it due to usage in a static fabric method.
   *
   * @param a first number to compare
   * @param b second number to compare
   * @return int representing comparison result
   */
  static <Number> int compare(Number a, Number b) {
    return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
  }
}

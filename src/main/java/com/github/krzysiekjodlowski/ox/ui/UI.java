package com.github.krzysiekjodlowski.ox.ui;

import com.github.krzysiekjodlowski.ox.NumberRange;

/**
 * Interacts directly with user, collects
 * input end outputts messages to user.
 *
 * @author Krzysztof Jodlowski
 */
public interface UI<T1, T2 extends Number> {
  /**
   * Outputs message to user.
   *
   * @param message any appropriate representation
   */
  void say(T1 message);

  /**
   * Outputs error message to user.
   *
   * @param errorMessage any appropriate representation
   */
  void warn(T1 errorMessage);

  /**
   * Returns Number type from user input.
   *
   * @param range custom Number type
   * @return custom Number type
   */
  T2 getNumberFromUser(NumberRange<T2> range);
}

package com.github.krzysiekjodlowski.ox;

/**
 * Describes generic event, and it's associated meta data which get
 * sent in the bus to be dispatched to interested Subscribers.
 *
 * @author Krzysztof Jodlowski
 */
public interface Event<T> {
  /**
   * Returns the stored data associated with the event.
   *
   * @return the stored data
   */
  T getData();
}

package com.github.krzysiekjodlowski.ox;

/**
 * Description of the contract of a generic EventBus implementation.
 *
 * @author Krzysztof Jodlowski
 */
interface EventBus {
  /**
   * Registers a new subscriber to this EventBus instance.
   *
   * @param subscriber any Subscriber implementation
   */
  void register(Subscriber subscriber);

  /**
   * Sends given event in this EventBus implementation
   * to be consumed by interested subscribers.
   *
   * @param event Event implementation
   */
  void dispatch(Event<?> event);
}

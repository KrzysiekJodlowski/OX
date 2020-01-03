package com.github.krzysiekjodlowski.ox;

/**
 * Subscriber contract for EventBus.
 *
 * @author Krzysztof Jodlowski
 */
public interface Subscriber {
  /**
   * Consume the events dispatched by the bus.
   */
  void handle(Event<?> event);
}


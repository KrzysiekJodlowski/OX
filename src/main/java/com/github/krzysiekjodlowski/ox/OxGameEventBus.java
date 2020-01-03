package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.board.BoardValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * ${@inheritDoc}.
 *
 * @author Krzysztof Jodlowski
 */
class OxGameEventBus implements EventBus {

  private final List<Subscriber> subscribers = new ArrayList<>();

  /**
   * ${@inheritDoc}.
   */
  @Override
  public void register(Subscriber subscriber) {
    this.subscribers.add(subscriber);
  }

  /**
   * ${@inheritDoc}.
   */
  @Override
  public void dispatch(Event<?> event) {
    this.subscribers.forEach(subscriber -> subscriber.handle(event));
  }
}

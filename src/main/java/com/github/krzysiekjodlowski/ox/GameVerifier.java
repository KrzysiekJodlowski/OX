package com.github.krzysiekjodlowski.ox;

/**
 * Verifies if game should end.
 * ATTENTION - represents the absolute
 * minimum implementation that will
 * be changed in the future!
 *
 * @author Krzysztof Jodlowski
 */
class GameVerifier implements Subscriber {
  private int turnCounter = 0;

  /**
   * Counting players turns.
   *
   * @param event dispatched by EventBus.
   */
  @Override
  public void handle(Event<?> event) {
    this.turnCounter++;
  }

  boolean saysItsOver() {
    return this.turnCounter == Settings.INSTANCE.boardCapacity();
  }
}

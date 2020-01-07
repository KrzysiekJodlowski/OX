package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.model.Symbol;

/**
 * ${@inheritDoc} Human version.
 *
 * @author Krzysztof Jodlowski
 */
class HumanPlayer extends Player {

  HumanPlayer(Symbol symbol) {
    super(symbol);
  }

  /**
   * Extends the one used in parent class.
   *
   * @return human Player representation
   */
  @Override
  public String toString() {
    return String.format("%s (human)", super.toString());
  }
}

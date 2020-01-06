package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.model.Symbol;

/**
 * Base for any player. Each one descendant
 * will have to implement its own version
 * of making moves and adjust toString.
 *
 * @author Krzysztof Jodlowski
 */
abstract class Player {
  private final Symbol symbol;

  Player(Symbol symbol) {
    this.symbol = symbol;
  }

  Symbol getSymbol() {
    return this.symbol;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Player)) {
      return false;
    }
    Player that = (Player) o;
    return this.symbol == that.symbol;
  }

  @Override
  public int hashCode() {
    return this.symbol.hashCode();
  }

  /**
   * Basic implementation. It is recommended for each
   * child class to adjust this method to provide more
   * specific information about its type.
   *
   * @return String representation of player
   */
  @Override
  public String toString() {
    return String.format("Player %s", this.symbol);
  }
}
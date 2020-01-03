package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.model.Symbol;
import com.github.krzysiekjodlowski.ox.ui.UI;

/**
 * Base for any player. Each one descendant
 * will have to implement its own version
 * of making moves and adjust toString.
 *
 * @author Krzysztof Jodlowski
 */
abstract class Player {
  private final Symbol playersSymbol;

  Player(Symbol symbol) {
    this.playersSymbol = symbol;
  }

  Symbol getPlayersSymbol() {
    return this.playersSymbol;
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
    return this.playersSymbol == that.playersSymbol;
  }

  @Override
  public int hashCode() {
    return this.playersSymbol.hashCode();
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
    return String.format("Player %s", this.playersSymbol);
  }

  /**
   * Core functionality of player, which should
   * be different in each type of a Player.
   *
   * @param ui generic user interface
   * @return Move made by player
   */
  public abstract Move makeMove(UI<String, Integer> ui) throws NumberLowerThanOneException;
}
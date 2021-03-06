package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import com.github.krzysiekjodlowski.ox.model.Symbol;

/**
 * Player move representation as Event.
 *
 * @author Krzysztof Jodlowski
 */
public class Move implements Event<Move> {
  private final FieldNumber fieldNumber;
  private final Symbol playersSymbol;

  public Move(FieldNumber fieldNumber, Symbol playersSymbol) {
    this.fieldNumber = fieldNumber;
    this.playersSymbol = playersSymbol;
  }

  public FieldNumber getFieldNumber() {
    return this.fieldNumber;
  }

  public Symbol getPlayersSymbol() {
    return this.playersSymbol;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Move)) {
      return false;
    }
    Move move = (Move) o;
    return move.fieldNumber.equals(this.fieldNumber)
        && move.playersSymbol == this.playersSymbol;
  }

  @Override
  public int hashCode() {
    int result = this.fieldNumber.hashCode();
    result = 31 * result + this.playersSymbol.hashCode();
    return result;
  }
}

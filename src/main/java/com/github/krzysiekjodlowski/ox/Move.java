package com.github.krzysiekjodlowski.ox;

/**
 * Player move representation as Event.
 *
 * @author Krzysztof Jodlowski
 */
class Move implements Event<Move> {
  private final FieldNumber fieldNumber;
  private final Symbol playersSymbol;

  public Move(FieldNumber fieldNumber, Symbol playersSymbol) {
    this.fieldNumber = fieldNumber;
    this.playersSymbol = playersSymbol;
  }

  FieldNumber getFieldNumber() {
    return this.fieldNumber;
  }

  Symbol getPlayersSymbol() {
    return this.playersSymbol;
  }

  @Override
  public Move getData() {
    return this;
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
}

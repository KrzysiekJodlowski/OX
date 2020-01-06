package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Event;
import com.github.krzysiekjodlowski.ox.Move;
import com.github.krzysiekjodlowski.ox.NumberLowerThanOneException;
import com.github.krzysiekjodlowski.ox.Subscriber;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import com.github.krzysiekjodlowski.ox.model.Symbol;

import java.util.HashMap;
import java.util.Map;


/**
 * Store fields marked by players.
 *
 * @author Krzysztof Jodlowski
 */
public class Board implements Subscriber {
  private final Map<FieldNumber, Symbol> fields = new HashMap<>();
  private final int boardSideLength;
  private final int boardCapacity;

  public Board(final int boardSideLength) {
    this.boardSideLength = boardSideLength;
    this.boardCapacity = this.boardSideLength * this.boardSideLength;
  }

  /**
   * Mark field when player makes move.
   *
   * @param event represents players move
   */
  @Override
  public void handle(Event<?> event) {
    Move playersMove = (Move) event;
    this.fields.put(playersMove.getFieldNumber(), playersMove.getPlayersSymbol());
  }

  /**
   * Used for checking field existence.
   *
   * @param fieldNumber field number
   * @return true if field is already marked, false otherwise
   */
  public boolean containsField(FieldNumber fieldNumber) {
    return this.fields.containsKey(fieldNumber);
  }

  int getBoardSideLength() {
    return this.boardSideLength;
  }

  int getBoardCapacity() {
    return this.boardCapacity;
  }

  int getBoardFulfillment() {
    return this.fields.size();
  }

  Symbol getSymbol(FieldNumber fieldNumber) {
    return this.fields.get(fieldNumber);
  }

  /**
   * Creates nice String representation of a board game.
   *
   * @return String representation
   */
  @Override
  public String toString() {
    int maxFieldLength = Integer.toString(this.boardCapacity).length();
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 1; i <= this.boardCapacity; i++) {
      FieldNumber currentFieldNumber = null;
      try {
        currentFieldNumber = FieldNumber.valueOf(i);
      } catch (NumberLowerThanOneException e) {
        e.printStackTrace();
      }
      stringBuilder.append(
          !this.getMarkedField(currentFieldNumber)
              .equals(Symbol.EMPTY)
              ? String.format(" %" + maxFieldLength + "s",
              this.getMarkedField(currentFieldNumber))
              : String.format(" %" + maxFieldLength + "d", i));
      if (i % this.boardSideLength == 0) {
        stringBuilder.append("\n");
      }
    }
    return stringBuilder.toString();
  }

  private Symbol getMarkedField(final FieldNumber fieldNumber) {
    return this.containsMarkedField(fieldNumber)
        ? this.fields.get(fieldNumber) : Symbol.EMPTY;
  }

  private boolean containsMarkedField(final FieldNumber fieldNumber) {
    return this.fields.containsKey(fieldNumber);
  }
}

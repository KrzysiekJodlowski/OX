package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Move;
import com.github.krzysiekjodlowski.ox.NumberLowerThanOneException;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;

abstract class NextSlantFieldChecker {
  private Board board;

  NextSlantFieldChecker(Board board) {
    this.board = board;
  }

  boolean checkIfThereIsAnotherSymbol(int currentField, int nextField, Move playersMove)
      throws NumberLowerThanOneException {
    return (currentField % this.board.getBoardSideLength() != 0)
        && nextField <= this.board.getBoardCapacity()
        && this.board.containsField(FieldNumber.valueOf(nextField))
        && this.board.getSymbol(
        FieldNumber.valueOf(nextField)).equals(playersMove.getPlayersSymbol()
    );
  }
}

package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Move;
import com.github.krzysiekjodlowski.ox.NumberLowerThanOneException;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;

class HorizontalChecker implements LineChecker {
  private Board board;
  private int winCondition;

  HorizontalChecker(Board board, int winCondition) {
    this.board = board;
    this.winCondition = winCondition;
  }

  @Override
  public boolean checkLine(Move playersMove) {
    int current = playersMove.getFieldNumber().getValue();

    int x = this.winCondition - 1;
    int found = 1;
    boolean checkLeft = (current - 1) % this.board.getBoardSideLength() != 0;
    boolean checkRight = (current % this.board.getBoardSideLength()) != 0;

    for (int i = 1; i <= x; i++) {
      if (!checkLeft && !checkRight) {
        return false;
      }
      try {
        if (checkLeft && checkIfThereIsAnotherSymbol(current - i, current - i, playersMove)) {
          found += 1;
        } else {
          checkLeft = false;
        }
      } catch (NumberLowerThanOneException e) {
        checkLeft = false;
      }
      try {
        if (checkRight && checkIfThereIsAnotherSymbol(current + i - 1, current + i, playersMove)) {
          found += 1;
        } else {
          checkRight = false;
        }
      } catch (NumberLowerThanOneException e) {
        checkRight = false;
      }
    }
    return found >= this.winCondition;
  }

  private boolean checkIfThereIsAnotherSymbol(int potentialCorner, int nextField, Move playersMove)
      throws NumberLowerThanOneException {
    return ((potentialCorner) % this.board.getBoardSideLength() != 0)
        && this.board.containsField(FieldNumber.valueOf(nextField))
        && this.board.getSymbol(
            FieldNumber.valueOf(nextField)).equals(playersMove.getPlayersSymbol()
    );
  }
}

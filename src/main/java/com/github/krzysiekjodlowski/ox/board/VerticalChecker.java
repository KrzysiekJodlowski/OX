package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Move;
import com.github.krzysiekjodlowski.ox.NumberLowerThanOneException;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;

class VerticalChecker implements LineChecker {
  private Board board;
  private int winCondition;

  VerticalChecker(Board board, int winCondition) {
    this.board = board;
    this.winCondition = winCondition;
  }

  @Override
  public boolean checkLine(Move playersMove) {

    int current = playersMove.getFieldNumber().getValue();

    int x = this.winCondition - 1;
    int found = 1;
    boolean checkUp = (current - this.board.getBoardSideLength()) > 0;
    boolean checkDown = (
        current + this.board.getBoardSideLength()) <= this.board.getBoardCapacity();

    for (int i = 1; i <= x; i++) {
      if (!checkUp && !checkDown) {
        return false;
      }
      try {
        if (checkUp && checkIfThereIsAnotherSymbol(
            current - i * this.board.getBoardSideLength(), playersMove)) {
          found += 1;
        } else {
          checkUp = false;
        }
      } catch (NumberLowerThanOneException e) {
        checkUp = false;
      }
      try {
        if (checkDown && checkIfThereIsAnotherSymbol(
            current + i * this.board.getBoardSideLength(), playersMove)) {
          found += 1;
        } else {
          checkDown = false;
        }
      } catch (NumberLowerThanOneException e) {
        checkDown = false;
      }
    }
    return found >= this.winCondition;
  }

  private boolean checkIfThereIsAnotherSymbol(int potentialField, Move playersMove)
      throws NumberLowerThanOneException {
    return potentialField <= this.board.getBoardCapacity()
        && this.board.containsField(FieldNumber.valueOf(potentialField))
        && this.board.getSymbol(
            FieldNumber.valueOf(potentialField)).equals(playersMove.getPlayersSymbol()
    );
  }
}


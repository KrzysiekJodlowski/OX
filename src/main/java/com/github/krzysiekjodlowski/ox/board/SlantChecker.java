package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Move;
import com.github.krzysiekjodlowski.ox.NumberLowerThanOneException;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;

class SlantChecker implements LineChecker {
  private Board board;
  private int winCondition;

  SlantChecker(Board board, int winCondition) {
    this.board = board;
    this.winCondition = winCondition;
  }

  @Override
  public boolean checkLine(Move playersMove) {
    int current = playersMove.getFieldNumber().getValue();

    int x = this.winCondition - 1;
    int found = 1;
    boolean checkBefore = ((current - this.board.getBoardSideLength()) > 0) && ((current - 1) % this.board.getBoardSideLength() != 0);
    boolean checkAfter = ((current % this.board.getBoardSideLength()) != 0) && ((current + this.board.getBoardSideLength() + 1) <= this.board.getBoardCapacity());

    for (int i = 1; i <= x; i++) {
      if (!checkBefore && !checkAfter) {
        return false;
      }
      try {
        if (checkBefore && checkIfThereIsAnother((current - i * this.board.getBoardSideLength()) - i, (current - i * this.board.getBoardSideLength()) - i, playersMove)) {
          found += 1;
        } else {
          checkBefore = false;
        }
      } catch (NumberLowerThanOneException e) {
        checkBefore = false;
      }
      try {
        if (checkAfter && checkIfThereIsAnother(current  + i * this.board.getBoardSideLength() + i - 1, (current + i * this.board.getBoardSideLength()) + i, playersMove)) {
          found += 1;
        } else {
          checkAfter = false;
        }
      } catch (NumberLowerThanOneException e) {
        checkAfter = false;
      }
    }
    return found >= this.winCondition;
  }

  private boolean checkIfThereIsAnother(int currentField, int nextField, Move playersMove) throws NumberLowerThanOneException {
    return (currentField % this.board.getBoardSideLength() != 0)
        && nextField <= this.board.getBoardCapacity()
        && this.board.containsField(new Move(FieldNumber.valueOf(nextField), playersMove.getPlayersSymbol()))
        && this.board.getSymbol(FieldNumber.valueOf(nextField)).equals(playersMove.getPlayersSymbol());
  }
}

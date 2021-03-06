package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Move;
import com.github.krzysiekjodlowski.ox.NumberLowerThanOneException;

class ReverseSlantChecker extends NextSlantFieldChecker implements LineChecker {
  private Board board;
  private int winCondition;

  ReverseSlantChecker(Board board, int winCondition) {
    super(board);
    this.board = board;
    this.winCondition = winCondition;
  }

  @Override
  public boolean checkLine(Move playersMove) {

    int current = playersMove.getFieldNumber().getValue();

    int x = this.winCondition - 1;
    int found = 1;
    boolean checkBefore = ((current - this.board.getBoardSideLength()) > 0)
        && (current % this.board.getBoardSideLength() != 0);
    boolean checkAfter = ((current - 1) % this.board.getBoardSideLength() != 0)
        && ((current + this.board.getBoardSideLength() - 1) <= this.board.getBoardCapacity());

    for (int i = 1; i <= x; i++) {
      if (!checkBefore && !checkAfter) {
        return false;
      }
      try {
        if (checkBefore && checkIfThereIsAnotherSymbol(
            (current - i * this.board.getBoardSideLength()) + i - 1,
            (current - i * this.board.getBoardSideLength()) + i, playersMove)) {
          found += 1;
        } else {
          checkBefore = false;
        }
      } catch (NumberLowerThanOneException e) {
        checkBefore = false;
      }
      try {
        if (checkAfter && checkIfThereIsAnotherSymbol(
            current + i * this.board.getBoardSideLength() - i,
            (current + i * this.board.getBoardSideLength()) - i, playersMove)) {
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
}

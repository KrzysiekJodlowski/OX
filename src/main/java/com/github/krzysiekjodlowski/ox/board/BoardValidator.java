package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Event;
import com.github.krzysiekjodlowski.ox.Move;
import com.github.krzysiekjodlowski.ox.NumberLowerThanOneException;
import com.github.krzysiekjodlowski.ox.Subscriber;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import com.github.krzysiekjodlowski.ox.model.Symbol;

/**
 * Verifies if game should end.
 * ATTENTION - represents the absolute
 * minimum implementation that will
 * be changed in the future!
 *
 * @author Krzysztof Jodlowski
 */
public class BoardValidator implements Subscriber {
  private Board board;
  private int winCondition;
  private boolean isGameOver = false;
  private Symbol winner = Symbol.EMPTY;

  public BoardValidator(Board board, int winCondition) {
    this.board = board;
    this.winCondition = winCondition;
  }

  /**
   * Checks board fullness.
   *
   * @param event dispatched by EventBus.
   */
  @Override
  public void handle(Event<?> event) {
    Move playersMove = (Move) event;
    this.isGameOver = this.checkIfHorizontalToLeft(playersMove);
  }

  private boolean checkIfHorizontalToLeft(Move playersMove) {
    int current = playersMove.getFieldNumber().getValue();

    int x = this.winCondition;
    int found = 0;
    boolean checkLeft = true;
    boolean checkRight = true;

    for (int i = 0; i < x; i++) {
      try {
        if (checkLeft && this.board.containsField(new Move(FieldNumber.valueOf(current - i), playersMove.getPlayersSymbol()))) {
          found += 1;
        } else {
          checkLeft = false;
        }
      } catch (NumberLowerThanOneException e) {
        checkLeft = false;
      }
      try {
        if (checkRight && this.board.containsField(new Move(FieldNumber.valueOf(current + i), playersMove.getPlayersSymbol()))) {
          found += 1;
        } else {
          checkRight = false;
        }
      } catch (NumberLowerThanOneException e) {
        checkRight = false;
      }
      if (!checkLeft && !checkRight) {
        return false;
      }
    }
    System.out.println(playersMove.getFieldNumber());
    System.out.println(found);
    boolean isOver = found >= this.winCondition - 1;
    if (isOver) {
      this.winner = playersMove.getPlayersSymbol();
    }
    return isOver;
  }

  public boolean saysItsOver() {
    return this.isGameOver;
  }

  public Symbol getWinner() {
    return this.winner;
  }
}

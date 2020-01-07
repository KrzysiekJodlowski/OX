package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Event;
import com.github.krzysiekjodlowski.ox.Move;
import com.github.krzysiekjodlowski.ox.Subscriber;
import com.github.krzysiekjodlowski.ox.model.Symbol;

/**
 * Verifies if any player wins after his move.
 *
 * @author Krzysztof Jodlowski
 */
public class BoardValidator implements Subscriber {
  private boolean isGameOver = false;
  private Symbol winner = null;
  private HorizontalChecker horizontalChecker;
  private VerticalChecker verticalChecker;
  private SlantChecker slantChecker;
  private ReverseSlantChecker reverseSlantChecker;
  private Board board;

  /**
   * Initializes all checher classes.
   * @param board game board
   * @param winCondition winning line length
   */
  public BoardValidator(Board board, int winCondition) {
    this.horizontalChecker = new HorizontalChecker(board, winCondition);
    this.verticalChecker = new VerticalChecker(board, winCondition);
    this.slantChecker = new SlantChecker(board, winCondition);
    this.reverseSlantChecker = new ReverseSlantChecker(board, winCondition);
    this.board = board;
  }

  /**
   * Checks all possible win combinations according to players move.
   *
   * @param event dispatched by EventBus.
   */
  @Override
  public void handle(Event<?> event) {
    Move playersMove = (Move) event;
    this.isGameOver = this.checkIfWinForMove(playersMove);
    if (this.isGameOver) {
      this.winner = playersMove.getPlayersSymbol();
    } else {
      this.isGameOver = this.board.getBoardCapacity() == this.board.getBoardFulfillment();
    }
  }

  private boolean checkIfWinForMove(Move playersMove) {
    return this.horizontalChecker.checkLine(playersMove)
        || this.verticalChecker.checkLine(playersMove)
        || this.slantChecker.checkLine(playersMove)
        || this.reverseSlantChecker.checkLine(playersMove);
  }

  public boolean isGameOver() {
    return this.isGameOver;
  }

  public Symbol getWinner() {
    return this.winner;
  }
}

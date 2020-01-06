package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.model.Symbol;

/**
 * Container for two players, used
 * mainly for managing their turns.
 *
 * @author Krzysztof Jodlowski
 */
class Players implements Subscriber {
  private final Player playerOne;
  private final Player playerTwo;
  private Player currentPlayer;

  private Players(Builder builder) {
    this.playerOne = builder.playerOne;
    this.playerTwo = builder.playerTwo;
    this.currentPlayer = builder.startingPlayer;
  }

  Player getCurrentPlayer() {
    return this.currentPlayer;
  }

  /**
   * Changes currentPlayer on each move made by another Player.
   *
   * @param event represents move made by another Player
   */
  @Override
  public void handle(Event<?> event) {
    this.currentPlayer = this.currentPlayer.equals(this.playerOne)
        ? this.playerTwo : this.playerOne;
  }

  /**
   * Used to build Players by setting
   * each of them and the starting one.
   * ATTENTION - functionality of setters
   * will be used by Settings class
   * improved in the future!
   *
   * @author Krzysztof Jodlowski
   */
  static class Builder {
    private Player playerOne = new HumanPlayer(Symbol.NAUGHT);
    private Player playerTwo = new HumanPlayer(Symbol.CROSS);
    private Player startingPlayer = this.playerOne;

    public Builder() {
    }

    public Builder changeStarting() {
      this.startingPlayer = this.startingPlayer.equals(this.playerOne)
          ? this.playerTwo : this.playerOne;
      return this;
    }

    public Players build() {
      return new Players(this);
    }
  }
}

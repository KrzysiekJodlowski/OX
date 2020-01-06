package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.model.Symbol;

/**
 * Container for two players, used
 * mainly for managing their turns.
 *
 * @author Krzysztof Jodlowski
 */
class Players {
  private final Player playerOne;
  private final Player playerTwo;
  private Player currentPlayer;

  private Players(Builder builder) {
    this.playerOne = builder.playerOne;
    this.playerTwo = builder.playerTwo;
    this.currentPlayer = builder.startingPlayer;
  }

  Player getStartingPlayer() {
    return this.currentPlayer;
  }

  /**
   * Changes currentPlayer on each move made by another Player.
   *
   * @return next player
   */
  public Player nextPlayer() {
    this.currentPlayer = this.currentPlayer.equals(this.playerOne)
        ? this.playerTwo : this.playerOne;
    return this.currentPlayer;
  }

  void changeStarting() {
    this.currentPlayer = this.currentPlayer.equals(this.playerOne)
        ? this.playerTwo : this.playerOne;
  }

  /**
   * Used to build Players by setting
   * each of them and the starting one.
   *
   * @author Krzysztof Jodlowski
   */
  static class Builder {
    private Player playerOne = new HumanPlayer(Symbol.NAUGHT);
    private Player playerTwo = new HumanPlayer(Symbol.CROSS);
    private Player startingPlayer = this.playerOne;

    public Builder setFirstPlayer(Player player) {
      this.playerOne = player;
      return this;
    }

    public Builder setSecondPlayer(Player player) {
      this.playerTwo = player;
      return this;
    }

    public Players build() {
      return new Players(this);
    }
  }
}

package com.github.krzysiekjodlowski.ox;

/**
 * Container for two players, managing their turns.
 *
 * @author KrzysiekJodlowski
 */
class Players implements Subscribable {
    private final Player playerOne;
    private final Player playerTwo;
    private Player currentPlayer;

    public Players(Builder builder) {
        this.playerOne = builder.playerOne;
        this.playerTwo = builder.playerTwo;
        this.currentPlayer = builder.startingPlayer;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public void handle(Event<?> event) {
        this.currentPlayer = this.currentPlayer.equals(this.playerOne) ? this.playerTwo : this.playerOne;
    }

    static class Builder {
        private Player playerOne = new HumanPlayer(Symbol.NAUGHT);
        private Player playerTwo = new HumanPlayer(Symbol.CROSS);
        private Player startingPlayer = this.playerOne;

        public Builder() {
        }

        public Builder playerOne(Player player) {
            this.playerOne = player;
            return this;
        }

        public Builder playerTwo(Player player) {
            this.playerTwo = player;
            return this;
        }

        public Builder starting(Player player) {
            this.startingPlayer = player;
            return this;
        }

        public Players build() {
            return new Players(this);
        }
    }
}

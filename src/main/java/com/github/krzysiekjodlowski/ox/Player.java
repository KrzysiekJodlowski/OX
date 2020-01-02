package com.github.krzysiekjodlowski.ox;

/**
 *
 *
 * @author KrzysiekJodlowski
 */
abstract class Player {
    private final Symbol playersSymbol;

    Player(Symbol symbol) {
        this.playersSymbol = symbol;
    }

    Symbol getPlayersSymbol() {
        return this.playersSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        Player that = (Player) o;
        return this.playersSymbol == that.playersSymbol;
    }

    @Override
    public int hashCode() {
        return this.playersSymbol.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Player %s", this.playersSymbol);
    }

    public abstract Move makeMove(UI ui) throws NumberLowerThanOneException;
}
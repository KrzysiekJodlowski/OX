package com.github.krzysiekjodlowski.ox;

/**
 * @author KrzysiekJodlowski
 */
class Board {
    /**
     * Size of the board game.
     */
    private final int boardCapacity;

    /**
     *  Constructor initialization.
     * @param boardSize defines one board game side length
     */
    Board(final int boardSize) {
        this.boardCapacity = boardSize * boardSize;
    }

    /**
     * @return int returns board game size
     */
    public int getBoardCapacity() {
        return this.boardCapacity;
    }
}

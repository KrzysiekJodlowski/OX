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
     * Minimal boardSize.
     */
    private final int minBoardSize = 3;
    /**
     * Maximal boardSize (temporary value for now).
     */
    private final int maxBoardSize = 1000;

    /**
     *  Constructor initialization.
     * @param boardSize defines one board game side length
     * @throws BoardSizeOutOfBoundsException exception
     * which should be handled by client
     */
    Board(final int boardSize) throws BoardSizeOutOfBoundsException {
        this.checkBoardSize(boardSize);
        this.boardCapacity = boardSize * boardSize;
    }

    /**
     * Simple check if boardSize parameter meets the conditions.
     * @param boardSize passed by client when creating a Board
     * @throws BoardSizeOutOfBoundsException exception
     * which should be handled by client
     */
    private void checkBoardSize(final int boardSize)
            throws BoardSizeOutOfBoundsException {
        if (boardSize < this.minBoardSize) {
            throw new BoardSizeOutOfBoundsException(
                    String.format("boardSize should be greater than %d!",
                    this.minBoardSize));
        }
        if (boardSize > this.maxBoardSize) {
            throw new BoardSizeOutOfBoundsException(
                    String.format("boardSize should be smaller than %d!",
                    this.maxBoardSize));
        }
    }

    /**
     * @return int returns board game size
     */
    public int getBoardCapacity() {
        return this.boardCapacity;
    }
}

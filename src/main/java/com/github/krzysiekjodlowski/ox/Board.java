package com.github.krzysiekjodlowski.ox;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents square game board.
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
     * Core field in this class.
     */
    private final Map<FieldNumber, Symbol> moves = new HashMap<>();
    /**
     * Size of one side of the board.
     */
    private final int boardSize;

    /**
     *  Constructor initialization.
     * @param boardSize defines one board game side length
     * @throws BoardSizeOutOfBoundsException exception
     * which should be handled by client
     */
    Board(final int boardSize) throws BoardSizeOutOfBoundsException {
        this.checkBoardSize(boardSize);
        this.boardSize = boardSize;
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
    int getBoardCapacity() {
        return this.boardCapacity;
    }

    /**
     * Add moves to game board.
     * @param fieldNumber represents number choose by player
     * @param symbol represents player symbol
     */
    void addMove(final FieldNumber fieldNumber, final Symbol symbol) {
        this.moves.put(fieldNumber, symbol);
    }

    /**
     * @return all moves made by players
     */
    Map<FieldNumber, Symbol> getMoves() {
        return this.moves;
    }

    /**
     * Check if there is a move in board.
     * @param fieldNumber represents number of a field
     * @return true if there is provided fieldNumber
     */
    boolean containMove(final FieldNumber fieldNumber) {
        return this.moves.containsKey(fieldNumber);
    }

    /**
     * @return size of game board
     */
    int getSize() {
        return this.boardSize;
    }

    /**
     * @param fieldNumber represents number of a field
     * @return player symbol
     */
    public Symbol getMove(final FieldNumber fieldNumber) {
        return this.moves.get(fieldNumber);
    }
}

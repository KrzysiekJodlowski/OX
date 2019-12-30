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
     * Core field in this class.
     */
    private final Map<FieldNumber, Symbol> markedFields = new HashMap<>();
    /**
     * Size of one side of the board.
     */
    private final int boardSideLength;

    /**
     *  Constructor initialization.
     * @param boardSideLength defines one board game side length
     * which should be handled by client
     */
    Board(final int boardSideLength) {
        this.boardSideLength = boardSideLength;
        this.boardCapacity = boardSideLength * boardSideLength;
    }

    /**
     * @return int returns board game size
     */
    int getBoardCapacity() {
        return this.boardCapacity;
    }

    /**
     * Mark fields in game board.
     * @param fieldNumber represents number choose by player
     * @param symbol represents player symbol
     */
    void markField(final FieldNumber fieldNumber, final Symbol symbol) {
        this.markedFields.put(fieldNumber, symbol);
    }

    /**
     * @return all fields marked by players
     */
    Map<FieldNumber, Symbol> getMarkedFields() {
        return this.markedFields;
    }

    /**
     * Check if there is field marked in board.
     * @param fieldNumber represents number of a field
     * @return true if there is provided fieldNumber
     */
    boolean containMarkedField(final FieldNumber fieldNumber) {
        return this.markedFields.containsKey(fieldNumber);
    }

    /**
     * @return size of game board
     */
    int getBoardSideLength() {
        return this.boardSideLength;
    }

    /**
     * @param fieldNumber represents number of a field
     * @return player symbol
     */
    public Symbol getMarkedField(final FieldNumber fieldNumber) {
        return this.markedFields.get(fieldNumber);
    }
}

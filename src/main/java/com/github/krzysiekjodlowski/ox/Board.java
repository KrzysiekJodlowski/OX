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
    private final Map<FieldNumber, Symbol> fields = new HashMap<>();
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
        // Condition which should be checked in user interface
        if (boardSideLength < 3 || boardSideLength > 1000) {
            System.out.println("Board size should be between 3 and 1000! "
                    + "Default size of 3 will be used instead.");
            this.boardSideLength = 3;
        } else {
            this.boardSideLength = boardSideLength;
        }
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
        this.fields.put(fieldNumber, symbol);
    }

    /**
     * @return all fields marked by players
     */
    Map<FieldNumber, Symbol> getFields() {
        return this.fields;
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
        return this.containsMarkedField(fieldNumber)
                ? this.fields.get(fieldNumber) : Symbol.EMPTY;
    }

    /**
     * Check if there is field marked in board.
     * @param fieldNumber represents number of a field
     * @return true if there is provided fieldNumber
     */
    private boolean containsMarkedField(final FieldNumber fieldNumber) {
        return this.fields.containsKey(fieldNumber);
    }
}

package com.github.krzysiekjodlowski.ox;

import java.util.HashMap;
import java.util.Map;


/**
 * Store fields marked by players.
 *
 * @author KrzysiekJodlowski
 */
class Board {
    private final int boardCapacity;
    private final Map<FieldNumber, Symbol> fields = new HashMap<>();
    private final int boardSideLength;

    Board(final int boardSideLength) {
        // Condition which should be checked in user interface
        if (boardSideLength < 3 || boardSideLength > 40) {
            System.out.println("Board capacity should be between 3 and 40! "
                    + "Default capacity of 3 will be used instead.");
            this.boardSideLength = 3;
        } else {
            this.boardSideLength = boardSideLength;
        }
        this.boardCapacity = boardSideLength * boardSideLength;
    }

    /**
     * Mark fields in game board.
     *
     * @param fieldNumber represents number choose by player
     * @param symbol      represents player symbol
     */
    void markField(final FieldNumber fieldNumber, final Symbol symbol) {
        this.fields.put(fieldNumber, symbol);
    }

    /**
     * Creates nice String representation of a board game
     *
     * @return String representation
     */
    @Override
    public String toString() {
        int maxFieldLength = Integer.toString(this.boardCapacity).length();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= this.boardCapacity; i++) {
            FieldNumber currentFieldNumber = null;
            try {
                currentFieldNumber = FieldNumber.valueOf(i);
            } catch (NumberLowerThanOneException e) {
                e.printStackTrace();
            }
            stringBuilder.append(
                    !this.getMarkedField(currentFieldNumber)
                            .equals(Symbol.EMPTY)
                            ? String.format(" %" + maxFieldLength + "s",
                            this.getMarkedField(currentFieldNumber))
                            : String.format(" %" + maxFieldLength + "d", i));
            if (i % this.boardSideLength == 0) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private Symbol getMarkedField(final FieldNumber fieldNumber) {
        return this.containsMarkedField(fieldNumber)
                ? this.fields.get(fieldNumber) : Symbol.EMPTY;
    }

    private boolean containsMarkedField(final FieldNumber fieldNumber) {
        return this.fields.containsKey(fieldNumber);
    }
}

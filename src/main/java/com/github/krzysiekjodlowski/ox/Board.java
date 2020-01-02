package com.github.krzysiekjodlowski.ox;

import java.util.HashMap;
import java.util.Map;


/**
 * Store fields marked by players.
 *
 * @author KrzysiekJodlowski
 */
class Board implements Subscribable {
    private final Map<FieldNumber, Symbol> fields = new HashMap<>();
    private final int boardSideLength;
    private final int boardCapacity;

    Board(final int boardSideLength) {
        this.boardSideLength = boardSideLength;
        this.boardCapacity = this.boardSideLength * this.boardSideLength;
    }

    /**
     *
     *
     * @param
     */
    @Override
    public void handle(Event<?> event) {
        this.markField((Move) event);
    }

    /**
     * Mark fields in game board.
     *
     * @param playersMove
     */
    void markField(Move playersMove) {
        this.fields.put(playersMove.getFieldNumber(), playersMove.getPlayersSymbol());
    }

    boolean containsField(Move playersMove) {
        return this.fields.containsKey(playersMove.getFieldNumber());
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
                // nothing to swallow!
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

package com.github.krzysiekjodlowski.ox;

/**
 * Generates String representation of the game board.
 * @author Krzysztof Jodlowski
 */
class BoardPrinter {
    /**
     * Size of one side of the board.
     */
    private final int boardSideLength;

    /**
     *  Constructor initialization.
     * @param boardSideLength defines one
     * board game side length which should
     * be handled by client
     */
    BoardPrinter(final int boardSideLength) {
        this.boardSideLength = boardSideLength;
    }
    /**
     * @param board Board object
     * @return string representation of the Board
     */
    String getBoardRepresentation(final Board board) {
        int boardCapacity = board.getBoardCapacity();
        int maxFieldLength = Integer.toString(boardCapacity).length();
        StringBuilder stringBuilder = new StringBuilder();
        FieldNumber currentFieldNumber;

        for (int i = 1; i <= boardCapacity; i++) {
            currentFieldNumber = new FieldNumber(i);
            stringBuilder.append(
                    !board.getMarkedField(currentFieldNumber)
                            .equals(Symbol.EMPTY)
                            ? String.format(" %" + maxFieldLength + "s",
                            board.getMarkedField(currentFieldNumber))
                            : String.format(" %" + maxFieldLength + "d", i));
            if (i % this.boardSideLength == 0) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}

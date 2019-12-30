package com.github.krzysiekjodlowski.ox;

/**
 * Generates String representation of the game board.
 * @author Krzysztof Jodlowski
 */
class BoardPrinter {
    /**
     * @param board Board object
     * @return string representation of the Board
     */
    String getBoardRepresentation(final Board board) {
        int boardSideLength = board.getBoardSideLength();
        int boardCapacity = board.getBoardCapacity();
        int maxFieldLength = Integer.toString(boardCapacity).length();
        StringBuilder stringBuilder = new StringBuilder();
        FieldNumber currentFieldNumber;

        for (int i = 1; i <= boardCapacity; i++) {
            currentFieldNumber = new FieldNumber(i);
            stringBuilder.append(
                    board.containMarkedField(currentFieldNumber)
                            ? String.format(" %" + maxFieldLength + "s",
                            board.getMarkedField(currentFieldNumber))
                            : String.format(" %" + maxFieldLength + "s", i));
            if (i % boardSideLength == 0) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}

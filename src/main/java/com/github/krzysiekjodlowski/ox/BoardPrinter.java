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
        int boardSize = board.getSize();
        int boardCapacity = board.getBoardCapacity();
        StringBuilder stringBuilder = new StringBuilder();
        FieldNumber currentFieldNumber;

        for (int i = 1; i <= boardCapacity; i++) {
            currentFieldNumber = new FieldNumber(i);
            stringBuilder.append(
                    board.containMove(currentFieldNumber)
                            ? String.format("%4s",
                            board.getMove(currentFieldNumber))
                            : String.format("%4d", i));
            if (i % boardSize == 0) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}

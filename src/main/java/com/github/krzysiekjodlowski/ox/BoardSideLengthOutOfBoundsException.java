package com.github.krzysiekjodlowski.ox;

/**
 * @author Krzysztof Jodlowski
 */
public class BoardSideLengthOutOfBoundsException extends Exception {
    /**
     * @param message message provided by user
     */
    public BoardSideLengthOutOfBoundsException(final String message) {
        super(message);
    }
}

package com.github.krzysiekjodlowski.ox;

/**
 * @author Krzysztof Jodlowski
 */
public class BoardSizeOutOfBoundsException extends Exception {
    /**
     * @param message message provided by user
     */
    public BoardSizeOutOfBoundsException(final String message) {
        super(message);
    }
}

package com.github.krzysiekjodlowski.ox;

/**
 * Represents each player on Board.
 * @author Krzysztof Jodlowski
 */
enum Symbol {
    NAUGHT("O"), CROSS("X");

    /**
     * Holds String representation of an enum.
     */
    private final String value;

    /**
     * Constructor forced by language.
     * @param value initializes enum value
     */
    Symbol(final String value) {
        this.value = value;
    }

    /**
     * Useful in board representation.
     * @return String representation of an enum
     */
    String getValue() {
        return value;
    }
}

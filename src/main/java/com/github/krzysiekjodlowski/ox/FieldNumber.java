package com.github.krzysiekjodlowski.ox;

/**
 * Represents each player move.
 * @author Krzysztof Jodlowski
 */
class FieldNumber {
    /**
     * Field value.
     */
    private final int number;
    /**
     * @param number provided by client
     */
    FieldNumber(final int number) {
        this.number = number;
    }
}

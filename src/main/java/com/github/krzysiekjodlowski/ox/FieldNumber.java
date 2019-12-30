package com.github.krzysiekjodlowski.ox;

/**
 * Represents each player move.
 * @author Krzysztof Jodlowski
 */
class FieldNumber {
    /**
     * Field value.
     */
    private final int value;
    /**
     * @param value provided by client
     */
    FieldNumber(final int value) {
        this.value = value;
    }
}

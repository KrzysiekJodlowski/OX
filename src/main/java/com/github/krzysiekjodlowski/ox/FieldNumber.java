package com.github.krzysiekjodlowski.ox;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FieldNumber that = (FieldNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

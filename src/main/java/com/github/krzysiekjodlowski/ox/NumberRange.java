package com.github.krzysiekjodlowski.ox;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * Keeps Number range provided by client.
 *
 * @author Krzysztof Jodlowski
 */
class NumberRange<Number> {
    private final Number minimalValue;
    private final Number maximumValue;
    private final NumberComparator numberComparator
            = new NumberComparator();
    private final int comparisonEquality = 0;

    NumberRange(Number minimalValue, Number maximumValue) {
        if (this.numberComparator.compare(minimalValue, maximumValue)
                > this.comparisonEquality) {
            this.minimalValue = maximumValue;
            this.maximumValue = minimalValue;
        } else {
            this.minimalValue = minimalValue;
            this.maximumValue = maximumValue;
        }
    }

    /**
     * Returns true if checked Number is within provided range.
     *
     * @param value concrete Number value to check
     * @return true if value is in range, false otherwise
     */
    boolean numberInRange(Number value) {
        return this.numberComparator.compare(minimalValue, value)
                <= this.comparisonEquality
                && this.numberComparator.compare(maximumValue, value)
                >= this.comparisonEquality;
    }

    private class NumberComparator implements Comparator<Number> {

        public int compare(Number a, Number b) {
            return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
        }

    }
}

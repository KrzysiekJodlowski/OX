package com.github.krzysiekjodlowski.ox;

/**
 * When input provided in FieldNumber
 * static fabric methods is lower than 1.
 *
 * @author Krzysztof Jodlowski
 */
class NumberLowerThanOneException extends Exception {
    NumberLowerThanOneException() {
        super("Provided number is lower than one!");
    }
}

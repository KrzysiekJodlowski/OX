package com.github.krzysiekjodlowski.ox;

/**
 * When input Number provided in
 * ConsoleUI getNumberFromUser method.
 *
 * @author Krzysztof Jodlowski
 */
class NumberOutOfRangeException extends Exception {
    NumberOutOfRangeException(Number number) {
        super(String.format("%s is out of range!", number));
    }
}

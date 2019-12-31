package com.github.krzysiekjodlowski.ox;

class NumberOutOfRangeException extends Exception {
    NumberOutOfRangeException(Number number) {
        super(String.format("%s is out of range!", number));
    }
}

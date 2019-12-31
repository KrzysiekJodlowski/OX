package com.github.krzysiekjodlowski.ox;

interface UI<T1, T2 extends Number> {
    void say(T1 message);

    T2 getNumberFromUser(NumberRange<T2> range) throws NumberOutOfRangeException;
}

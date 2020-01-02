package com.github.krzysiekjodlowski.ox;

/**
 * Interacting directly with user,
 * used for collecting input end
 * outputting messages to user
 *
 * @author Krzysztof Jodlowski
 */
interface UI<T1, T2 extends Number> {
    /**
     * Outputs message to user.
     *
     * @param message any appropriate representation
     */
    void say(T1 message);

    /**
     * Returns Number type from user input.
     *
     * @param range custom Number type
     * @return custom Number type
     */
    T2 getNumberFromUser(NumberRange<T2> range);
}

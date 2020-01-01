package com.github.krzysiekjodlowski.ox;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Interacting directly with user,
 * used for collecting input end
 * outputting messages to user
 *
 * @author Krzysztof Jodlowski
 */
class ConsoleUI implements UI<String, Integer> {
    private final Scanner scanner;
    private final PrintStream printStream;

    ConsoleUI(Scanner scanner, PrintStream ps) {
        this.scanner = scanner;
        this.printStream = ps;
    }

    @Override
    public void say(String message) {
        this.printStream.println(message);
    }

    @Override
    public Integer getNumberFromUser(NumberRange<Integer> range) throws NumberOutOfRangeException {
        Integer input = this.scanner.nextInt();
        if (range.numberInRange(input)) {
            return input;
        }
        throw new NumberOutOfRangeException(input);
    }
}

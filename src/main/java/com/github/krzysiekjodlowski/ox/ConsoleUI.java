package com.github.krzysiekjodlowski.ox;

import java.io.PrintStream;
import java.util.InputMismatchException;
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
    public Integer getNumberFromUser(NumberRange<Integer> range) {
        boolean correctInput = false;
        Integer input = 0;

        do {
            try {
                input = this.scanner.nextInt();
            } catch (InputMismatchException e) {
                this.printStream.println("Provided input is not a number!");
                this.scanner.next();
                continue;
            }
            if (!range.numberInRange(input)) {
                this.printStream.println("Provided number is out of range!");
                continue;
            } else {
                correctInput = true;
            }
        } while (!correctInput);
    return input;
    }
}

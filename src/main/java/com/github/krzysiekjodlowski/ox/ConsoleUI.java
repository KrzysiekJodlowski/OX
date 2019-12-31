package com.github.krzysiekjodlowski.ox;

import java.util.Scanner;

class ConsoleUI implements UI<String, Integer> {
    private final Scanner scanner;

    ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void say(String message) {
        System.out.println(message);
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

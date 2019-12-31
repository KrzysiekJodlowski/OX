package com.github.krzysiekjodlowski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.assertEquals;

public class ConsoleUITest {

    @DataProvider
    public static Object[][] arbitraryNumbersInputWithinTheRange() {
        return new Object[][]{
                {"1", new NumberRange<>(1, 1)}
                , {"1", new NumberRange<>(0, 1)}
                , {"1", new NumberRange<>(1, 2)}
                , {"1", new NumberRange<>(0, 2)}
        };
    }

    @DataProvider
    public static Object[][] arbitraryNumbersInputNotInTheRange() {
        return new Object[][]{
                {"1", new NumberRange<>(-1, 0)}
                , {"1", new NumberRange<>(0, 0)}
                , {"1", new NumberRange<>(2, 2)}
                , {"1", new NumberRange<>(2, 3)}
        };
    }

    @Test(dataProvider = "arbitraryNumbersInputWithinTheRange")
    public void testGettingNumberFromUserWhileNumberInRange(
            String input, NumberRange<Integer> numberRange)
            throws NumberOutOfRangeException {
        //arrange
        Scanner scanner = new Scanner(input);
        UI<String, Integer> consoleUI = new ConsoleUI(scanner);
        Integer expected = Integer.valueOf(input);

        //act
        Integer output = consoleUI.getNumberFromUser(numberRange);

        //assert
        assertEquals(output, expected);
    }

    @Test(dataProvider = "arbitraryNumbersInputNotInTheRange"
            , expectedExceptions = NumberOutOfRangeException.class)
    public void testThrowsNumberOutOfRangeExceptionWhileNumberInRange(
            String input, NumberRange<Integer> numberRange)
            throws NumberOutOfRangeException {
        //arrange
        Scanner scanner = new Scanner(input);
        UI<String, Integer> consoleUI = new ConsoleUI(scanner);

        //act
        consoleUI.getNumberFromUser(numberRange);

        //assert throws
    }
}

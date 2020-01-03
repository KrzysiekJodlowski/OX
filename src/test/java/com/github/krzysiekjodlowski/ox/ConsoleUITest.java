package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.ui.ConsoleUI;
import com.github.krzysiekjodlowski.ox.ui.UI;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

public class ConsoleUITest {

    @DataProvider
    public static Object[][] arbitraryNumbersInputWithinTheRange() {
        return new Object[][]{
                {"1", NumberRange.of(1, 1)}
                , {"1", NumberRange.of(0, 1)}
                , {"1", NumberRange.of(1, 2)}
                , {"1", NumberRange.of(0, 2)}
        };
    }
//
//    @DataProvider
//    public static Object[][] arbitraryNumbersInputNotInTheRange() {
//        return new Object[][]{
//                {"1", NumberRange.of(-1, 0)}
//                , {"1", NumberRange.of(0, 0)}
//                , {"1", NumberRange.of(2, 2)}
//                , {"1", NumberRange.of(2, 3)}
//        };
//    }

    @Test(dataProvider = "arbitraryNumbersInputWithinTheRange")
    public void testGettingNumberFromUserWhileNumberInRange(
            String input, NumberRange<Integer> numberRange) {
        //arrange
        Scanner scanner = new Scanner(input);
        UI<String, Integer> consoleUI = new ConsoleUI(scanner, new PrintStream(System.out));
        Integer expected = Integer.valueOf(input);

        //act
        Integer output = consoleUI.getNumberFromUser(numberRange);

        //assert
        assertEquals(output, expected);
    }
//
//    @Test(dataProvider = "arbitraryNumbersInputNotInTheRange"
//            , expectedExceptions = NumberOutOfRangeException.class)
//    public void testThrowsNumberOutOfRangeExceptionWhileNumberInRange(
//            String input, NumberRange<Integer> numberRange)
//            throws NumberOutOfRangeException {
//        //arrange
//        Scanner scanner = new Scanner(input);
//        UI<String, Integer> consoleUI = new ConsoleUI(scanner, new PrintStream(System.out));
//
//        //act
//        consoleUI.getNumberFromUser(numberRange);
//
//        //assert throws
//    }
}

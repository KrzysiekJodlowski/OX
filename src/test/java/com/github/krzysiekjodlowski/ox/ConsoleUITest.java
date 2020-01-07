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
}

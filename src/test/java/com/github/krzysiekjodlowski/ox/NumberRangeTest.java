package com.github.krzysiekjodlowski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NumberRangeTest {

    @DataProvider
    public static Object[][] rangeBoundsAndNumbersInThatRange() {
        return new Object[][]{
                {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE}
                , {Integer.MIN_VALUE, Integer.MAX_VALUE, -1}
                , {Integer.MIN_VALUE, Integer.MAX_VALUE, 0}
                , {Integer.MIN_VALUE, Integer.MAX_VALUE, 1}
                , {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}
                , {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}
                , {-1, -1, -1}
                , {0, 0, 0}
                , {1, 1, 1}
                , {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
    }

    @DataProvider
    public static Object[][] rangeBoundsAndNumbersOutOfThatRange() {
        return new Object[][]{
                {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE + 1}
                , {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE}
                , {Integer.MIN_VALUE, 0, 1}
                , {Integer.MIN_VALUE, 0, Integer.MAX_VALUE}
                , {0, 0, Integer.MIN_VALUE}
                , {0, 0, -1}
                , {0, 0, 1}
                , {0, 0, Integer.MAX_VALUE}
                , {-1, 1, Integer.MIN_VALUE}
                , {-1, 1, -2}
                , {-1, 1, 2}
                , {-1, 1, Integer.MAX_VALUE}
                , {0, Integer.MAX_VALUE, Integer.MIN_VALUE}
                , {0, Integer.MAX_VALUE, -1}
                , {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE}
                , {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE - 1}
        };
    }

    @Test(dataProvider = "rangeBoundsAndNumbersInThatRange")
    public void testIfTrueWhenNumbersInRange(int lowerBound, int upperBound, int numberToCheck) {
        // arrange
        NumberRange<Integer> numberRange = NumberRange.of(lowerBound, upperBound);

        // act
        boolean result = numberRange.numberInRange(numberToCheck);

        // assert
        assertTrue(result);
    }

    @Test(dataProvider = "rangeBoundsAndNumbersOutOfThatRange")
    public void testIfFalseWhenNumbersOutOfRange(int lowerBound, int upperBound, int numberToCheck) {
        // arrange
        NumberRange<Integer> numberRange = NumberRange.of(lowerBound, upperBound);

        // act
        boolean result = numberRange.numberInRange(numberToCheck);

        // assert
        assertFalse(result);
    }
}

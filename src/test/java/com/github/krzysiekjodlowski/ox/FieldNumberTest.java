package com.github.krzysiekjodlowski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertNotEquals;

public class FieldNumberTest {

    @DataProvider
    public static Object[] boundaryIntegers() {
        return new Object[]{Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};
    }

    @DataProvider
    public static Object[][] boundaryIntegersInUnequalPairs() {
        return new Object[][]{
                {Integer.MIN_VALUE, Integer.MAX_VALUE}
                , {Integer.MAX_VALUE, Integer.MIN_VALUE}
        };
    }

    @Test(dataProvider = "boundaryIntegers")
    public void testEqualityOfEqualFieldNumbers(int number) {
        //arrange
        SoftAssert softAssert = new SoftAssert();
        FieldNumber fieldNumber1;
        FieldNumber fieldNumber2;
        FieldNumber fieldNumber3;

        //act
        fieldNumber1 = new FieldNumber(number);
        fieldNumber2 = new FieldNumber(number);
        fieldNumber3 = new FieldNumber(number);

        //assert
        softAssert.assertEquals(
           fieldNumber1
           , fieldNumber1
           , String.format("%s is not equal to itself", fieldNumber1));
        softAssert.assertEquals(
           fieldNumber1
           , fieldNumber2
           , String.format("%s and %s are not equal", fieldNumber1, fieldNumber2));
        softAssert.assertEquals(
           fieldNumber1
           , fieldNumber2
           , String.format("%s and %s equality is not consistent", fieldNumber1, fieldNumber2));
        softAssert.assertEquals(
           fieldNumber2
           , fieldNumber1
           , String.format("%s and %s equality is not symmetric", fieldNumber2, fieldNumber1));
        softAssert.assertTrue(
           fieldNumber1.equals(fieldNumber3)
                   && fieldNumber2.equals(fieldNumber3)
           , String.format("%s, %s and %s equality is not transitive", fieldNumber1, fieldNumber2, fieldNumber3));
        softAssert.assertNotEquals(
           fieldNumber1
           , null
           , String.format("%s is equal to null", fieldNumber1));
        softAssert.assertAll();
    }

    @Test(dataProvider = "boundaryIntegersInUnequalPairs")
    public void testInequalityOfUnequalFieldNumbers(int numberOne, int numberTwo) {
        //arrange
        FieldNumber fieldNumber1;
        FieldNumber fieldNumber2;

        //act
        fieldNumber1 = new FieldNumber(numberOne);
        fieldNumber2 = new FieldNumber(numberTwo);

        //assert
        assertNotEquals(
                fieldNumber1
                , fieldNumber2
                , String.format("%s and %s are equal", fieldNumber1, fieldNumber2));
    }
}

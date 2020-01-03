package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertNotEquals;

public class FieldNumberTest {

    @DataProvider
    public static Object[] boundaryNumbersInput() {
        return new Object[]{
                "1"
                , String.valueOf(Integer.MAX_VALUE)
        };
    }

    @DataProvider
    public static Object[][] boundaryNumbersInputInUnequalPairs() {
        return new Object[][]{
                {"1", String.valueOf(Integer.MAX_VALUE)}
                , {String.valueOf(Integer.MAX_VALUE), "1"}
        };
    }

    @Test(dataProvider = "boundaryNumbersInput")
    public void testEqualityOfEqualFieldNumbers(String input) throws NumberLowerThanOneException {
        //arrange
        SoftAssert softAssert = new SoftAssert();
        FieldNumber fieldNumber1;
        FieldNumber fieldNumber2;
        FieldNumber fieldNumber3;

        //act
        fieldNumber1 = FieldNumber.from(input);
        fieldNumber2 = FieldNumber.from(input);
        fieldNumber3 = FieldNumber.from(input);

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

    @Test(dataProvider = "boundaryNumbersInputInUnequalPairs")
    public void testInequalityOfUnequalFieldNumbers(String inputOne, String inputTwo) throws NumberLowerThanOneException {
        //arrange
        FieldNumber fieldNumber1;
        FieldNumber fieldNumber2;

        //act
        fieldNumber1 = FieldNumber.from(inputOne);
        fieldNumber2 = FieldNumber.from(inputTwo);

        //assert
        assertNotEquals(
                fieldNumber1
                , fieldNumber2
                , String.format("%s and %s are equal", fieldNumber1, fieldNumber2));
    }
}

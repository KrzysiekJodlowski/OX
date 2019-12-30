package com.github.krzysiekjodlowski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BoardTest {

    @DataProvider
    public static Object[][] examplesOfMovesStoredInBoard() {
        return new Object[][]{
                {3, new FieldNumber(1), Symbol.NAUGHT},
                {3, new FieldNumber(2), Symbol.CROSS},
                {3, new FieldNumber(5), Symbol.NAUGHT},
                {3, new FieldNumber(8), Symbol.CROSS},
                {3, new FieldNumber(9), Symbol.NAUGHT},
        };
    }

    @DataProvider
    private Object[][] sizesFrom3UpTo10() {
        return new Integer[][]{
                {3, 9}, {4, 16}, {5, 25}, {6, 36}, {7, 49}, {8, 64}, {9, 81}, {10, 100}
        };
    }

    @DataProvider
    private Object[] sizesFromMinus2To2() {
        return new Integer[]{
                -2, -1, 0, 1, 2
        };
    }

    @DataProvider
    private Object[] sizesGreaterThan1000() {
        return new Integer[]{
                1001, 10000, 1000000
        };
    }

    @Test(dataProvider = "sizesFrom3UpTo10")
    public void testBoardCapacityWhenBoardSizeFrom3UpTo10(int boardSize, int boardCapacity) throws BoardSizeOutOfBoundsException {
        // arrange
        Board board = new Board(boardSize);

        // act
        int capacity = board.getBoardCapacity();

        // assert
        assertEquals(capacity, boardCapacity);
    }

    @Test(dataProvider = "sizesFromMinus2To2", expectedExceptions = BoardSizeOutOfBoundsException.class)
    public void testBoardConstructorThrowsBoardSizeOutOfBoundsExceptionWhenSizeSmallerThan3(int boardSize) throws BoardSizeOutOfBoundsException {
        //arrange
        Board board;

        //act
        board = new Board(boardSize);

        //assertThrows
    }

    @Test(dataProvider = "sizesGreaterThan1000", expectedExceptions = BoardSizeOutOfBoundsException.class)
    public void testBoardConstructorThrowsBoardSizeOutOfBoundsExceptionWhenSizeGreaterThan1000(int boardSize) throws BoardSizeOutOfBoundsException {
        //arrange
        Board board;

        //act
        board = new Board(boardSize);

        //assertThrows
    }
    
    @Test(dataProvider = "examplesOfMovesStoredInBoard")
    public void testAddingMovesToBoard(int boardSize, FieldNumber fieldNumber, Symbol symbol) throws BoardSizeOutOfBoundsException {
        //arrange
        Board board = new Board(boardSize);
    
        //act
        board.addMove(fieldNumber, symbol);
    
        //assert
        assertTrue(board.containMove(fieldNumber));
    }               
}

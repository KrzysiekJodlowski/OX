package com.github.krzysiekjodlowski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class BoardTest {

    @DataProvider
    private Object[][] sizesFrom3UpTo10() {
        return new Integer[][]{
                  {3, 9}, {4, 16}, {5, 25}, {6, 36}, {7, 49}, {8, 64}, {9, 81}, {10, 100}
        };
    }

    @Test(dataProvider = "sizesFrom3UpTo10")
    public void testBoardCapacityWhenBoardSizeFrom3UpTo10(int boardSize, int boardCapacity) {
        // arrange
        Board board = new Board(boardSize);

        // act
        int capacity = board.getBoardCapacity();

        // assert
        assertEquals(capacity, boardCapacity);
    }
}

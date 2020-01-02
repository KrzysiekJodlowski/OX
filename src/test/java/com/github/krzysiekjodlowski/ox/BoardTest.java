package com.github.krzysiekjodlowski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoardTest {
    BoardTestDataProviders boardTestDataProviders = new BoardTestDataProviders();

    @DataProvider
    private Object[][] sizesFrom3UpTo10WithRepresentations() {
        return this.boardTestDataProviders.sizesFrom3UpTo10WithRepresentations();
    }

    @DataProvider
    private Object[][] examplesOfMovesStoredInBoardWithRepresentations() throws NumberLowerThanOneException {
        return this.boardTestDataProviders.examplesOfMovesStoredInBoardWithRepresentations();
    }

    @Test(dataProvider = "sizesFrom3UpTo10WithRepresentations")
    public void testBoardToStringMethodWhenSize3To10(int boardSideLength, String representation) {
        //arrange
        Board board = new Board(boardSideLength);

        //act
        String generated = board.toString();

        //assert
        assertEquals(generated, representation);
    }

    @Test(dataProvider = "examplesOfMovesStoredInBoardWithRepresentations")
    public void testAddingMovesToBoard(FieldNumber fieldNumber, Symbol symbol, String boardRepresentation) {
        //arrange
        Board board = new Board(3);

        //act
        board.handle(new Move(fieldNumber, symbol));

        //assert
        assertEquals(board.toString(), boardRepresentation);
    }
}

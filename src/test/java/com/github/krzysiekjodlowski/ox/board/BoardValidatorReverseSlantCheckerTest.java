package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Move;
import com.github.krzysiekjodlowski.ox.NumberLowerThanOneException;
import com.github.krzysiekjodlowski.ox.board.Board;
import com.github.krzysiekjodlowski.ox.board.BoardValidator;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import com.github.krzysiekjodlowski.ox.model.Symbol;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * ATTENTION - This class need some mocking!
 */
public class BoardValidatorReverseSlantCheckerTest {

  @DataProvider
  public Object[][] markReverseSlantLineWith3_5_7() {
    return new Object[][] {
        { 3, 5, 7 }
        , { 3, 7, 5 }
        , { 5, 3, 7 }
        , { 5, 7, 3 }
        , { 7, 3, 5 }
        , { 7, 5, 3 }
    };
  }

  @DataProvider
  public Object[][] markReverseSlantLineWith4_7_10_13() {
    return new Object[][] {
        {4, 7, 10, 13}
        , {7, 4, 10, 13}
        , {10, 4, 7, 13}
        , {4, 10, 7, 13}
        , {7, 10, 4, 13}
        , {10, 7, 4, 13}
        , {13, 7, 4, 10}
        , {7, 13, 4, 10}
        , {4, 13, 7, 10}
        , {13, 4, 7, 10}
        , {7, 4, 13, 10}
        , {4, 7, 13, 10}
        , {4, 10, 13, 7}
        , {10, 4, 13, 7}
        , {13, 4, 10, 7}
        , {4, 13, 10, 7}
        , {10, 13, 4, 7}
        , {13, 10, 4, 7}
        , {13, 10, 7, 4}
        , {10, 13, 7, 4}
        , {7, 13, 10, 4}
        , {13, 7, 10, 4}
        , {10, 7, 13, 4}
        , {7, 10, 13, 4}
    };
  }

  @DataProvider
  public Object[][] markAllPossibleReverseSlantLinesWithLength3On5x5Board() {
    return new Object[][] {
        { 3, 7, 11 }
        , { 3, 11, 7 }
        , { 7, 3, 11 }
        , { 7, 11, 3 }
        , { 11, 3, 7 }
        , { 11, 7, 3 }

        , { 4, 8, 12 }
        , { 4, 12, 8 }
        , { 8, 4, 12 }
        , { 8, 12, 4 }
        , { 12, 4, 8 }
        , { 12, 8, 4 }

        , { 5, 9, 13 }
        , { 5, 13, 9 }
        , { 9, 5, 13 }
        , { 9, 13, 5 }
        , { 13, 5, 9 }
        , { 13, 9, 5 }

        , { 8, 12, 16 }
        , { 8, 16, 12 }
        , { 12, 8, 16 }
        , { 12, 16, 8 }
        , { 16, 8, 12 }
        , { 16, 12, 8 }

        , { 9, 13, 17 }
        , { 9, 17, 13 }
        , { 13, 9, 17 }
        , { 13, 17, 9 }
        , { 17, 9, 13 }
        , { 17, 13, 9 }

        , { 10, 14, 18 }
        , { 10, 18, 14 }
        , { 14, 10, 18 }
        , { 14, 18, 10 }
        , { 18, 10, 14 }
        , { 18, 14, 10 }

        , { 13, 17, 21 }
        , { 13, 21, 17 }
        , { 17, 13, 21 }
        , { 17, 21, 13 }
        , { 21, 13, 17 }
        , { 21, 17, 13 }

        , { 14, 18, 22 }
        , { 14, 22, 18 }
        , { 18, 14, 22 }
        , { 18, 22, 14 }
        , { 22, 14, 18 }
        , { 22, 18, 14 }

        , { 15, 19, 23 }
        , { 15, 23, 19 }
        , { 19, 15, 23 }
        , { 19, 23, 15 }
        , { 23, 15, 19 }
        , { 23, 19, 15 }
    };
  }

  @Test(dataProvider = "markReverseSlantLineWith3_5_7")
  public void testReverseSlantGameWinWhenCondition3On3x3Board(int[] chosenFields) throws NumberLowerThanOneException {
    //arrange
    Board board = new Board(3);
    BoardValidator boardValidator = new BoardValidator(board, 3);
    board.handle(new Move(FieldNumber.valueOf(chosenFields[0]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[0]), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(chosenFields[1]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[1]), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(chosenFields[2]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[2]), Symbol.CROSS));

    //act
    boolean isGameOver = boardValidator.isGameOver();

    //assert
    assertTrue(isGameOver);
  }

  @Test(dataProvider = "markReverseSlantLineWith4_7_10_13")
  public void testReverseSlantGameWinWhenCondition4On4x4Board(int[] chosenFields) throws NumberLowerThanOneException {
    //arrange
    Board board = new Board(4);
    BoardValidator boardValidator = new BoardValidator(board, 4);
    board.handle(new Move(FieldNumber.valueOf(chosenFields[0]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[0]), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(chosenFields[1]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[1]), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(chosenFields[2]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[2]), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(chosenFields[3]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[3]), Symbol.CROSS));


    //act
    boolean isGameOver = boardValidator.isGameOver();

    //assert
    assertTrue(isGameOver);
  }

  @Test(dataProvider = "markAllPossibleReverseSlantLinesWithLength3On5x5Board")
  public void testReverseSlantGameWinWhenConditionIs3On5x5Board(int[] chosenFields) throws NumberLowerThanOneException {
    //arrange
    Board board = new Board(5);
    BoardValidator boardValidator = new BoardValidator(board, 3);
    board.handle(new Move(FieldNumber.valueOf(chosenFields[0]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[0]), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(chosenFields[1]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[1]), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(chosenFields[2]), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(chosenFields[2]), Symbol.CROSS));

    //act
    boolean isGameOver = boardValidator.isGameOver();

    //assert
    assertTrue(isGameOver);
  }
}

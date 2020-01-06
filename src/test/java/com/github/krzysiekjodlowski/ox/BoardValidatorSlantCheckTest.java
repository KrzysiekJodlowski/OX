package com.github.krzysiekjodlowski.ox;

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
public class BoardValidatorSlantCheckTest {

  @DataProvider
  public Object[][] markSlantLineWith1_5_9() {
      return new Object[][] {
          { 1, 5, 9 }
          , { 1, 9, 5 }
          , { 5, 1, 9 }
          , { 5, 9, 1 }
          , { 9, 1, 5 }
          , { 9, 5, 1 }
      };
  }

    @DataProvider
    public Object[][] markSlantLineWith1_6_11_16() {
        return new Object[][] {
            {1, 6, 11, 16}
            , {6, 1, 11, 16}
            , {11, 1, 6, 16}
            , {1, 11, 6, 16}
            , {6, 11, 1, 16}
            , {11, 6, 1, 16}
            , {16, 6, 1, 11}
            , {6, 16, 1, 11}
            , {1, 16, 6, 11}
            , {16, 1, 6, 11}
            , {6, 1, 16, 11}
            , {1, 6, 16, 11}
            , {1, 11, 16, 6}
            , {11, 1, 16, 6}
            , {16, 1, 11, 6}
            , {1, 16, 11, 6}
            , {11, 16, 1, 6}
            , {16, 11, 1, 6}
            , {16, 11, 6, 1}
            , {11, 16, 6, 1}
            , {6, 16, 11, 1}
            , {16, 6, 11, 1}
            , {11, 6, 16, 1}
            , {6, 11, 16, 1}
        };
    }

    @DataProvider
    public Object[][] markAllPossibleSlantLinesWithLength3On5x5Board() {
        return new Object[][] {
            { 1, 7, 13 }
            , { 1, 13, 7 }
            , { 7, 1, 13 }
            , { 7, 13, 1 }
            , { 13, 1, 7 }
            , { 13, 7, 1 }

            , { 2, 8, 14 }
            , { 2, 14, 8 }
            , { 8, 2, 14 }
            , { 8, 14, 2 }
            , { 14, 2, 8 }
            , { 14, 8, 2 }

            , { 3, 9, 15 }
            , { 3, 15, 9 }
            , { 9, 3, 15 }
            , { 9, 15, 3 }
            , { 15, 3, 9 }
            , { 15, 9, 3 }

            , { 6, 12, 18 }
            , { 6, 18, 12 }
            , { 12, 6, 18 }
            , { 12, 18, 6 }
            , { 18, 6, 12 }
            , { 18, 12, 6 }

            , { 7, 13, 19 }
            , { 7, 19, 13 }
            , { 13, 7, 19 }
            , { 13, 19, 7 }
            , { 19, 7, 13 }
            , { 19, 13, 7 }

            , { 8, 14, 20 }
            , { 8, 20, 14 }
            , { 14, 8, 20 }
            , { 14, 20, 8 }
            , { 20, 8, 14 }
            , { 20, 14, 8 }

            , { 11, 17, 23 }
            , { 11, 23, 17 }
            , { 17, 11, 23 }
            , { 17, 23, 11 }
            , { 23, 11, 17 }
            , { 23, 17, 11 }

            , { 12, 18, 24 }
            , { 12, 24, 18 }
            , { 18, 12, 24 }
            , { 18, 24, 12 }
            , { 24, 12, 18 }
            , { 24, 18, 12 }

            , { 13, 19, 25 }
            , { 13, 25, 19 }
            , { 19, 13, 25 }
            , { 19, 25, 13 }
            , { 25, 13, 19 }
            , { 25, 19, 13 }
        };
    }

  @Test(dataProvider = "markSlantLineWith1_5_9")
  public void testSlantGameWinWhenCondition3On3x3Board(int[] chosenFields) throws NumberLowerThanOneException {
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
    boolean isGameOver = boardValidator.saysItsOver();

    //assert
    assertTrue(isGameOver);
  }

  @Test(dataProvider = "markSlantLineWith1_6_11_16")
  public void testSlantGameWinWhenCondition4On4x4Board(int[] chosenFields) throws NumberLowerThanOneException {
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
    boolean isGameOver = boardValidator.saysItsOver();

    //assert
    assertTrue(isGameOver);
  }

  @Test(dataProvider = "markAllPossibleSlantLinesWithLength3On5x5Board")
  public void testSlantGameWinWhenConditionIs3On5x5Board(int[] chosenFields) throws NumberLowerThanOneException {
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
    boolean isGameOver = boardValidator.saysItsOver();

    //assert
    assertTrue(isGameOver);
  }
}

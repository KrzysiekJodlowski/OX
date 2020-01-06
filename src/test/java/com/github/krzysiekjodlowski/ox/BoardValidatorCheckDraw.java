package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.board.Board;
import com.github.krzysiekjodlowski.ox.board.BoardValidator;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import com.github.krzysiekjodlowski.ox.model.Symbol;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * ATTENTION - This class need some mocking!
 */
public class BoardValidatorCheckDraw {

  @DataProvider
  public Object[][] movesLeadingToADraw() throws NumberLowerThanOneException {
    return new Object[][] {
        { new Move(FieldNumber.valueOf(3), Symbol.NAUGHT)
            , new Move(FieldNumber.valueOf(1), Symbol.CROSS)
            , new Move(FieldNumber.valueOf(4), Symbol.NAUGHT)
            , new Move(FieldNumber.valueOf(2), Symbol.CROSS)
            , new Move(FieldNumber.valueOf(5), Symbol.NAUGHT)
            , new Move(FieldNumber.valueOf(6), Symbol.CROSS)
            , new Move(FieldNumber.valueOf(9), Symbol.NAUGHT)
            , new Move(FieldNumber.valueOf(7), Symbol.CROSS)
            , new Move(FieldNumber.valueOf(3), Symbol.NAUGHT)
            , new Move(FieldNumber.valueOf(8), Symbol.CROSS)
        }
    };
  }

  @Test(dataProvider = "movesLeadingToADraw")
  public void testDraw(Move[] moves) throws NumberLowerThanOneException {
      // arrange
    Board board = new Board(3);
    BoardValidator boardValidator = new BoardValidator(board, 3);

    //act
    for (Move move : moves) {
      board.handle(move);
      boardValidator.handle(move);
    }
    boolean isGameOver = boardValidator.saysItsOver();

    //assert
    assertTrue(isGameOver);
  }
}

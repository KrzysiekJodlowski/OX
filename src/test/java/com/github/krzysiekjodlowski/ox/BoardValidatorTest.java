package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.board.Board;
import com.github.krzysiekjodlowski.ox.board.BoardValidator;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import com.github.krzysiekjodlowski.ox.model.Symbol;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BoardValidatorTest {
  
  @Test
  public void testHorizontalGameWinWhenConditionIs3On3x3Board() throws NumberLowerThanOneException {
    //arrange
    Board board = new Board(3);
    BoardValidator boardValidator = new BoardValidator(board, 3);
    board.handle(new Move(FieldNumber.valueOf(1), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(1), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(2), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(2), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(3), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(3), Symbol.CROSS));

    //act
    boolean isGameOver = boardValidator.saysItsOver();
  
    //assert
    assertTrue(isGameOver);
  }

  @Test
  public void testHorizontalGameWinWhenConditionIs3On10x10Board() throws NumberLowerThanOneException {
    //arrange
    Board board = new Board(10);
    BoardValidator boardValidator = new BoardValidator(board, 3);
    board.handle(new Move(FieldNumber.valueOf(14), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(14), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(15), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(15), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(16), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(16), Symbol.CROSS));

    //act
    boolean isGameOver = boardValidator.saysItsOver();

    //assert
    assertTrue(isGameOver);
  }

  @Test
  public void testHorizontalGameWinWhenConditionIs5On10x10Board() throws NumberLowerThanOneException {
    //arrange
    Board board = new Board(10);
    BoardValidator boardValidator = new BoardValidator(board, 5);
    board.handle(new Move(FieldNumber.valueOf(15), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(16), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(17), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(15), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(16), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(17), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(18), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(18), Symbol.CROSS));
    board.handle(new Move(FieldNumber.valueOf(14), Symbol.CROSS));
    boardValidator.handle(new Move(FieldNumber.valueOf(14), Symbol.CROSS));

    //act
    boolean isGameOver = boardValidator.saysItsOver();

    //assert
    assertTrue(isGameOver);
  }
}

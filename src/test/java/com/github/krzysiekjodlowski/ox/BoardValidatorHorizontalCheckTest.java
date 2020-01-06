package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.board.Board;
import com.github.krzysiekjodlowski.ox.board.BoardValidator;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import com.github.krzysiekjodlowski.ox.model.Symbol;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.testng.Assert.assertTrue;

/**
 * ATTENTION - This class need some mocking!
 */
public class BoardValidatorHorizontalCheckTest {

    @DataProvider
    public Object[][] markAllThreeFirstFields() {
        return new Object[][]{
                {1, 2, 3}
                , {1, 3, 2}
                , {2, 3, 1}
                , {2, 1, 3}
                , {3, 1, 2}
                , {3, 2, 1}
        };
    }

    @DataProvider
    public Object[][] markAllRowsIn3x3Board() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(markAllThreeFirstFields()));
        result.addAll(Arrays.asList(
                new Object[][]{
                        {4, 5, 6}
                        , {4, 6, 5}
                        , {5, 6, 4}
                        , {5, 4, 6}
                        , {6, 4, 5}
                        , {6, 5, 4}
                        , {7, 8, 9}
                        , {7, 9, 8}
                        , {8, 9, 7}
                        , {8, 7, 9}
                        , {9, 7, 8}
                        , {9, 8, 7}
                }
        ));
        return result.toArray(new Object[result.size()][]);
    }

    @DataProvider
    public Object[][] markRowOfThreeFieldsBeginningFromSecond() {
        return new Object[][]{
                {1, 2, 3}
                , {1, 3, 2}
                , {2, 3, 1}
                , {2, 1, 3}
                , {3, 1, 2}
                , {3, 2, 1}
        };
    }

    @DataProvider
    public Object[][] markRowOfThreeFieldsOnFirst4x4Row() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(markAllThreeFirstFields()));
        result.addAll(Arrays.asList(markRowOfThreeFieldsBeginningFromSecond()));
        return result.toArray(new Object[result.size()][]);
    }

    @DataProvider
    public Object[][] winningHorizontallyWith4On4x4() {
        return new Object[][]{
                {1, 2, 3, 4}
                , {2, 1, 3, 4}
                , {3, 1, 2, 4}
                , {1, 3, 2, 4}
                , {2, 3, 1, 4}
                , {3, 2, 1, 4}
                , {4, 2, 1, 3}
                , {2, 4, 1, 3}
                , {1, 4, 2, 3}
                , {4, 1, 2, 3}
                , {2, 1, 4, 3}
                , {1, 2, 4, 3}
                , {1, 3, 4, 2}
                , {3, 1, 4, 2}
                , {4, 1, 3, 2}
                , {1, 4, 3, 2}
                , {3, 4, 1, 2}
                , {4, 3, 1, 2}
                , {4, 3, 2, 1}
                , {3, 4, 2, 1}
                , {2, 4, 3, 1}
                , {4, 2, 3, 1}
                , {3, 2, 4, 1}
                , {2, 3, 4, 1}
        };
    }

    @DataProvider
    public Object[][] markRowOfFirstMiddleAndLast40FieldsOf40x40Board() {
        return new Object[][] {
                IntStream.rangeClosed(1, 40).boxed().toArray()
                , IntStream.rangeClosed(801, 840).boxed().toArray()
                , IntStream.rangeClosed(1561, 1600).boxed().toArray()
        };
    }

    @Test(dataProvider = "markAllRowsIn3x3Board")
    public void testHorizontalGameWinWhenConditionIs3On3x3Board(int[] chosenFields) throws NumberLowerThanOneException {
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

    @Test(dataProvider = "markRowOfThreeFieldsOnFirst4x4Row")
    public void testHorizontalGameWinWhenConditionIs3On4x4Board(int[] chosenFields) throws NumberLowerThanOneException {
        //arrange
        Board board = new Board(4);
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

    @Test(dataProvider = "winningHorizontallyWith4On4x4")
    public void testHorizontalGameWinWhenConditionIs4On4x4Board(int[] chosenFields) throws NumberLowerThanOneException {
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

    @Test(dataProvider = "markRowOfThreeFieldsBeginningFromSecond")
    public void testHorizontalGameWinWhenConditionIs3nTheMiddleOf5x5BoardRow(int[] chosenFields) throws NumberLowerThanOneException {
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

    @Test(dataProvider = "markRowOfFirstMiddleAndLast40FieldsOf40x40Board")
    public void testHorizontalGameWinWhenConditionIs40On40x40Board(int[] chosenFields) {
        //arrange
        Board board = new Board(40);
        BoardValidator boardValidator = new BoardValidator(board, 40);

        Arrays.stream(chosenFields).forEach(x ->
                {
                    try {
                        board.handle(new Move(FieldNumber.valueOf(x), Symbol.CROSS));
                        boardValidator.handle(new Move(FieldNumber.valueOf(x), Symbol.CROSS));
                    } catch (NumberLowerThanOneException e) {
                        e.printStackTrace();
                    }
                }
        );

        //act
        boolean isGameOver = boardValidator.saysItsOver();

        //assert
        assertTrue(isGameOver);
    }
}

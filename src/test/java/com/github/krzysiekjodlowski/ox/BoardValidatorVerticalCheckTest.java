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
import java.util.stream.IntStream;

import static org.testng.Assert.assertTrue;

/**
 * ATTENTION - This class need some mocking!
 */
public class BoardValidatorVerticalCheckTest {

    @DataProvider
    public Object[][] markThreeFirstFieldsFromFirstColumnOn3x3Board() {
        return new Object[][]{
                {1, 4, 7}
                , {1, 7, 4}
                , {4, 7, 1}
                , {4, 1, 7}
                , {7, 1, 4}
                , {7, 4, 1}
        };
    }

    @DataProvider
    public Object[][] markAllColumnsIn3x3Board() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(markThreeFirstFieldsFromFirstColumnOn3x3Board()));
        result.addAll(Arrays.asList(
                new Object[][]{
                        {2, 5, 8}
                        , {2, 8, 5}
                        , {5, 8, 2}
                        , {5, 2, 8}
                        , {8, 2, 5}
                        , {8, 5, 2}
                        , {3, 6, 9}
                        , {3, 9, 6}
                        , {6, 9, 3}
                        , {6, 3, 9}
                        , {9, 3, 6}
                        , {9, 6, 3}
                }
        ));
        return result.toArray(new Object[result.size()][]);
    }

    @DataProvider
    public Object[][] markThreeFieldsFromFirstColumnBeginningFromSecondOn5x5Board() {
        return new Object[][]{
                {6, 11, 16}
                , {6, 16, 11}
                , {11, 6, 16}
                , {11, 16, 6}
                , {16, 6, 11}
                , {16, 11, 6}
        };
    }

    @DataProvider
    public Object[][] markRowOfThreeFieldsOnFirst4x4Column() {
        return new Object[][]{
            {1, 5, 9}
            , {1, 9, 5}
            , {5, 1, 9}
            , {5, 9, 1}
            , {9, 1, 5}
            , {9, 5, 1}

            , {5, 9, 13}
            , {5, 13, 9}
            , {9, 5, 13}
            , {9, 13, 5}
            , {13, 5, 9}
            , {13, 9, 5}
        };
    }

    @DataProvider
    public Object[][] winningVerticallyWith4On4x4() {
        return new Object[][]{
                {1, 5, 9, 13}
                , {5, 1, 9, 13}
                , {9, 1, 5, 13}
                , {1, 9, 5, 13}
                , {5, 9, 1, 13}
                , {9, 5, 1, 13}
                , {13, 5, 1, 9}
                , {5, 13, 1, 9}
                , {1, 13, 5, 9}
                , {13, 1, 5, 9}
                , {5, 1, 13, 9}
                , {1, 5, 13, 9}
                , {1, 9, 13, 5}
                , {9, 1, 13, 5}
                , {13, 1, 9, 5}
                , {1, 13, 9, 5}
                , {9, 13, 1, 5}
                , {13, 9, 1, 5}
                , {13, 9, 5, 1}
                , {9, 13, 5, 1}
                , {5, 13, 9, 1}
                , {13, 5, 9, 1}
                , {9, 5, 13, 1}
                , {5, 9, 13, 1}
        };
    }

    @DataProvider
    public Object[][] markColumnOfFirstMiddleAndLast40FieldsOf40x40Board() {
        return new Object[][] {
                IntStream.iterate(1, i -> i <= 1600, i -> i + 40).boxed().toArray()
                , IntStream.iterate(20, i -> i <= 1600, i -> i + 40).boxed().toArray()
                , IntStream.iterate(40, i -> i <= 1600, i -> i + 40).boxed().toArray()
        };
    }

    @Test(dataProvider = "markAllColumnsIn3x3Board")
    public void testVerticalGameWinWhenConditionIs3On3x3Board(int[] chosenFields) throws NumberLowerThanOneException {
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

    @Test(dataProvider = "markRowOfThreeFieldsOnFirst4x4Column")
    public void testVerticalGameWinWhenConditionIs3On4x4Board(int[] chosenFields) throws NumberLowerThanOneException {
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

    @Test(dataProvider = "winningVerticallyWith4On4x4")
    public void testVerticalGameWinWhenConditionIs4On4x4Board(int[] chosenFields) throws NumberLowerThanOneException {
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

    @Test(dataProvider = "markThreeFieldsFromFirstColumnBeginningFromSecondOn5x5Board")
    public void testVerticalGameWinWhenConditionIs3nTheMiddleOf5x5BoardRow(int[] chosenFields) throws NumberLowerThanOneException {
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

    @Test(dataProvider = "markColumnOfFirstMiddleAndLast40FieldsOf40x40Board")
    public void testVerticalGameWinWhenConditionIs40On40x40Board(int[] chosenFields) {
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

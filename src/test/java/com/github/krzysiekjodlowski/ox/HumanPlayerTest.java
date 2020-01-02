package com.github.krzysiekjodlowski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class HumanPlayerTest {

  @DataProvider
  public static Object[] userInputDataProvider() {
    return new Object[]{
        Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE
    };
  }

  @DataProvider
  public static Object[][] playerSymbolAndStringRepresentation() {
    return new Object[][]{
        { Symbol.NAUGHT, "Player O (human)"}
        , { Symbol.CROSS, "Player X (human)"}
    };
  }

  @Test(dataProvider = "userInputDataProvider")
  public void testMakingMoves(int userInput) throws NumberLowerThanOneException {
    //arrange
    ConsoleUI ui = mock(ConsoleUI.class);
    when(ui.getNumberFromUser(any())).thenReturn(1);
    Player player = new HumanPlayer(Symbol.NAUGHT);

    //act
    Move move = player.makeMove(ui);

    //assert
    assertEquals(move, new Move(FieldNumber.valueOf(1), player.getPlayersSymbol()));
  }
  
  @Test(dataProvider = "playerSymbolAndStringRepresentation")
  public void testToString(Symbol symbol, String representation) {
    //arrange
    Player player = new HumanPlayer(symbol);
  
    //act
    String playerRepresentation = player.toString();
  
    //assert
    assertEquals(player.toString(), representation);
  
  }               


}

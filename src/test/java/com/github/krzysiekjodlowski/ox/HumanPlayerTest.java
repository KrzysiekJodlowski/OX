package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.model.Symbol;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HumanPlayerTest {

  @DataProvider
  public static Object[][] playerSymbolAndStringRepresentation() {
    return new Object[][]{
        {Symbol.NAUGHT, "Player O (human)"}
        , {Symbol.CROSS, "Player X (human)"}
    };
  }

  @Test(dataProvider = "playerSymbolAndStringRepresentation")
  public void testToString(Symbol symbol, String representation) {
    //arrange
    Player player = new HumanPlayer(symbol);

    //act
    String playerRepresentation = player.toString();

    //assert
    assertEquals(playerRepresentation, representation);
  }
}

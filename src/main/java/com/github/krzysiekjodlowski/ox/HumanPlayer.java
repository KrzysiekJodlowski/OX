package com.github.krzysiekjodlowski.ox;

/**
 * ${@inheritDoc} Human version.
 *
 * @author Krzysztof Jodlowski
 */
class HumanPlayer extends Player {

  HumanPlayer(Symbol symbol) {
    super(symbol);
  }

  /**
   * Extends the one used in parent class.
   *
   * @return human Player representation
   */
  @Override
  public String toString() {
    return String.format("%s (human)", super.toString());
  }

  /**
   * Collects human player input.
   *
   * @param ui generic user interface
   * @return move made by player
   * @throws NumberLowerThanOneException when want to mark field lower than 1
   */
  @Override
  public Move makeMove(UI<String, Integer> ui) throws NumberLowerThanOneException {
    NumberRange<Integer> boardBoundaryFields = NumberRange.of(
        Settings.FIRST_FIELD_NUMBER,
        Settings.INSTANCE.boardCapacity()
    );
    FieldNumber chosenField = FieldNumber.valueOf(ui.getNumberFromUser(boardBoundaryFields));
    return new Move(chosenField, this.getPlayersSymbol());
  }
}

package com.github.krzysiekjodlowski.ox;

/**
 * @author KrzysiekJodlwski
 */
class HumanPlayer extends Player {

    HumanPlayer(Symbol symbol) {
        super(symbol);
    }

    @Override
    public String toString() {
        return String.format("%s (human)", super.toString());
    }

    @Override
    public Move makeMove(UI ui) throws NumberFormatException, NumberLowerThanOneException {
        FieldNumber chosenField = FieldNumber.valueOf((Integer) ui.getNumberFromUser(
                NumberRange.of(
                        Settings.FIRST_FIELD_NUMBER,
                        Settings.INSTANCE.boardCapacity()
                ))
        );
        return new Move(chosenField, this.getPlayersSymbol());
    }
}

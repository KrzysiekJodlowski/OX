package com.github.krzysiekjodlowski.ox;

/**
 *
 *
 * @author
 */
class Move implements Event {
    private final FieldNumber fieldNumber;
    private final Symbol playersSymbol;

    public Move(FieldNumber fieldNumber, Symbol playersSymbol) {
        this.fieldNumber = fieldNumber;
        this.playersSymbol = playersSymbol;
    }

    FieldNumber getFieldNumber() {
        return this.fieldNumber;
    }

    Symbol getPlayersSymbol() {
        return this.playersSymbol;
    }

    @Override
    public Object getData() {
        return this;
    }
}

package com.github.krzysiekjodlowski.ox;

class GameVerifier implements Subscribable {
    private int turnCounter = 0;

    @Override
    public void handle(Event<?> event) {
        this.turnCounter++;
    }

    boolean saysItsOver() {
        return this.turnCounter == Settings.INSTANCE.boardCapacity();
    }
}

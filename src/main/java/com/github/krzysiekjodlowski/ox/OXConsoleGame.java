package com.github.krzysiekjodlowski.ox;

import java.util.Set;

/**
 * Main loop for OX game. For now it runs only
 * one round without win condition check
 *
 * @author KrzysiekJodlowski
 */
class OXConsoleGame implements Game {
    private final UI<String, Integer> ui;
    private final EventBus oxGameEventBus = new OXGameEventBus();
    private final Players players = new Players.Builder().build();
    private final GameVerifier gameVerifier = new GameVerifier();

    OXConsoleGame(UI<String, Integer> ui) {
        this.ui = ui;
        this.oxGameEventBus.register(this.players);
        this.oxGameEventBus.register(this.gameVerifier);
    }

    @Override
    public void run() {
        Player currentPlayer;
        this.ui.say("*** Welcome to OX game! ***");
        Board board = this.setBoardSideLength();
        this.ui.say("For now there are only two human players, and the 'O' player begins.");
        do {
            currentPlayer = this.players.getCurrentPlayer();
            this.ui.say(currentPlayer.toString());
            this.ui.say(board.toString());
            this.ui.say("Choose one field by entering its number:");
            Move playersMove = null;
            try {
                playersMove = currentPlayer.makeMove(this.ui);
            } catch (NumberFormatException | NumberLowerThanOneException e) {
                this.ui.say(e.getMessage());
            }
            if (board.containsField(playersMove)) {
                this.ui.say("This one is marked! Choose another one.");
                continue;
            }
            this.oxGameEventBus.dispatch(playersMove);
        } while (!this.gameVerifier.saysItsOver());
        this.ui.say(board.toString());
        this.ui.say("Demo 'game' is over!");
    }

    private Board setBoardSideLength() {
        this.ui.say(String.format("What size of a game board side do you choose? (numbers from %d to %d)",
                Settings.MIN_GAME_BOARD_SIDE_LENGTH, Settings.MAX_GAME_BOARD_SIDE_LENGTH));
        Settings.gameBoardSideLength = this.ui.getNumberFromUser(
                NumberRange.of(Settings.MIN_GAME_BOARD_SIDE_LENGTH, Settings.MAX_GAME_BOARD_SIDE_LENGTH));

        final Board board = new Board(Settings.gameBoardSideLength);
        this.oxGameEventBus.register(board);
        return board;
    }
}
package com.github.krzysiekjodlowski.ox;

/**
 * Main loop for OX game.
 * ATTENTION - For now it runs only one
 * "round" and without win condition check!
 *
 * @author Krzysztof Jodlowski
 */
class OxConsoleGame implements Game {
  private final UI<String, Integer> ui;
  private final EventBus oxGameEventBus = new OxGameEventBus();
  private final Players players = new Players.Builder().build();
  private final GameVerifier gameVerifier = new GameVerifier();

  OxConsoleGame(UI<String, Integer> ui) {
    this.ui = ui;
    this.oxGameEventBus.register(this.players);
    this.oxGameEventBus.register(this.gameVerifier);
  }

  /**
   * ATTENTION - Below implementation is temporary!
   * Analogical one will appear in future Round class.
   */
  @Override
  public void run() {
    Player currentPlayer;
    this.welcomePlayers();
    Board board = this.setBoardSideLength();
    this.oxGameEventBus.register(board);

    do {
      currentPlayer = this.players.getCurrentPlayer();
      this.showPlayerBoardAndActionMessage(currentPlayer, board);
      Move playersMove = null;
      try {
        playersMove = currentPlayer.makeMove(this.ui);

      } catch (NumberFormatException | NumberLowerThanOneException e) {
        this.ui.say(e.getMessage());
      }
      if (playersMove != null && board.containsField(playersMove)) {
        this.ui.say("This one is marked! Choose another one.");
        continue;
      }
      this.oxGameEventBus.dispatch(playersMove);
    } while (!this.gameVerifier.saysItsOver());
    this.showBoardAndSayItsOver(board);
  }

  private void welcomePlayers() {
    this.ui.say("*** Welcome to OX game! ***");
    this.ui.say("For now there are only two human players, and the 'O' player begins.");
  }

  private void showPlayerBoardAndActionMessage(Player currentPlayer, Board board) {
    this.ui.say(currentPlayer.toString());
    this.ui.say(board.toString());
    this.ui.say("Choose one field by entering its number:");
  }

  private void showBoardAndSayItsOver(Board board) {
    this.ui.say(board.toString());
    this.ui.say("Demo 'game' is over!");
  }

  private Board setBoardSideLength() {
    this.ui.say(String.format("What size of a game board side do you choose? "
            + "(numbers from %d to %d)",
        Settings.MIN_GAME_BOARD_SIDE_LENGTH, Settings.MAX_GAME_BOARD_SIDE_LENGTH));
    Settings.gameBoardSideLength = this.ui.getNumberFromUser(
        NumberRange.of(Settings.MIN_GAME_BOARD_SIDE_LENGTH, Settings.MAX_GAME_BOARD_SIDE_LENGTH));
    return new Board(Settings.gameBoardSideLength);
  }
}
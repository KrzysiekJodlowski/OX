package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.board.Board;
import com.github.krzysiekjodlowski.ox.ui.UI;
import com.github.krzysiekjodlowski.ox.board.BoardValidator;

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

  OxConsoleGame(UI<String, Integer> ui) {
    this.ui = ui;
    this.oxGameEventBus.register(this.players);
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
    BoardValidator boardValidator = new BoardValidator(board, this.setWinCondition());
    this.oxGameEventBus.register(board);
    this.oxGameEventBus.register(boardValidator);

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
//      this.ui.clear();
    } while (!boardValidator.saysItsOver());
    this.showBoardAndSayItsOver(board, boardValidator);
  }

  private void welcomePlayers() {
    this.ui.say("*** Welcome to OX game! ***");
    this.ui.say("For now there are only two human players, and the 'O' player begins.");
  }

  private void showPlayerBoardAndActionMessage(Player currentPlayer, Board board) {
    this.ui.say(currentPlayer.toString());
    this.ui.say(board.toString());
    this.ui.say("Choose one field by entering its number (whole number; or press ctrl+C to exit game):");
  }

  private void showBoardAndSayItsOver(Board board, BoardValidator boardValidator) {
    this.ui.say(board.toString());
    this.ui.say("Demo 'game' is over!");
    this.ui.say(String.format("The winner is %s!", boardValidator.getWinner()));
  }

  private Board setBoardSideLength() {
    this.ui.say(String.format("What size of a game board side do you choose? "
            + "(whole numbers from %d to %d)",
        Settings.MIN_GAME_BOARD_SIDE_LENGTH, Settings.MAX_GAME_BOARD_SIDE_LENGTH));
    Settings.gameBoardSideLength = this.ui.getNumberFromUser(
        NumberRange.of(Settings.MIN_GAME_BOARD_SIDE_LENGTH, Settings.MAX_GAME_BOARD_SIDE_LENGTH));
    return new Board(Settings.gameBoardSideLength);
  }

  private Integer setWinCondition() {
    if (!(Settings.gameBoardSideLength == Settings.MIN_GAME_BOARD_SIDE_LENGTH)) {
      this.ui.say(String.format("Select the length of the winning line "
              + "(numbers from %d to %d)",
          Settings.MIN_GAME_BOARD_SIDE_LENGTH, Settings.gameBoardSideLength));
      return this.ui.getNumberFromUser(
          NumberRange.of(Settings.MIN_GAME_BOARD_SIDE_LENGTH, Settings.gameBoardSideLength));
    } else {
      return Settings.MIN_GAME_BOARD_SIDE_LENGTH;
    }
  }
}
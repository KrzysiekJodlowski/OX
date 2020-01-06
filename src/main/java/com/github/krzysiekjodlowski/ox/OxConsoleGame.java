package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.board.Board;
import com.github.krzysiekjodlowski.ox.board.BoardValidator;
import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import com.github.krzysiekjodlowski.ox.ui.UI;

/**
 * Main loop for OX game.
 *
 * @author Krzysztof Jodlowski
 */
class OxConsoleGame implements Game {
  private final UI<String, Integer> ui;
  private final EventBus oxGameEventBus = new OxGameEventBus();
  private Players players = new Players.Builder().build();

  OxConsoleGame(UI<String, Integer> ui) {
    this.ui = ui;
  }

  /**
   * ATTENTION - Below implementation is temporary!
   * Analogical one will appear in future Round class.
   * Also all hardcoded Strings will be read from file by Settings.
   */
  @Override
  public void run() {
    this.welcomePlayers();
    Integer boardSideLength = this.getBoardSideLengthFromUser();
    Board board = new Board(boardSideLength);
    BoardValidator boardValidator = new BoardValidator(
        board, this.getWinConditionFromUser(boardSideLength)
    );
    this.setStartingPlayer();
    this.oxGameEventBus.register(board);
    this.oxGameEventBus.register(boardValidator);
    Player currentPlayer = this.players.getStartingPlayer();

    do {
      this.showNextMove(currentPlayer, board);
      Move playersMove = null;
      try {
        playersMove = new Move(this.getFieldFromUser(board.getCapacity()),
          currentPlayer.getSymbol()
        );
      } catch (NumberFormatException | NumberLowerThanOneException e) {
        this.ui.say(e.getMessage());
      }
      if (playersMove != null && board.containsField(playersMove.getFieldNumber())) {
        this.ui.warn("This one is marked! Choose another one.");
        continue;
      }
      this.oxGameEventBus.dispatch(playersMove);
      currentPlayer = this.players.nextPlayer();
    } while (!boardValidator.isGameOver());
    this.endGameRun(board, boardValidator);
  }

  private void welcomePlayers() {
    this.ui.say("*** Welcome to OX game! ***");
    this.ui.say("You can quit the game anytime by pressing ctrl+C.");
  }

  private Integer getBoardSideLengthFromUser() {
    this.ui.say(String.format("Please select board's side length "
            + "(whole numbers from %d to %d)",
        Settings.INSTANCE.MIN_GAME_BOARD_SIDE_LENGTH, Settings.INSTANCE.MAX_GAME_BOARD_SIDE_LENGTH));
    return this.ui.getNumberFromUser(
        NumberRange.of(Settings.INSTANCE.MIN_GAME_BOARD_SIDE_LENGTH, Settings.INSTANCE.MAX_GAME_BOARD_SIDE_LENGTH));
  }

  private Integer getWinConditionFromUser(int boardSideLength) {
    if (!(boardSideLength == Settings.INSTANCE.MIN_GAME_BOARD_SIDE_LENGTH)) {
      this.ui.say(String.format("Select the length of the winning line "
              + "(numbers from %d to %d)",
          Settings.INSTANCE.MIN_GAME_BOARD_SIDE_LENGTH, boardSideLength));
      return this.ui.getNumberFromUser(
          NumberRange.of(Settings.INSTANCE.MIN_GAME_BOARD_SIDE_LENGTH, boardSideLength));
    } else {
      return Settings.INSTANCE.MIN_GAME_BOARD_SIDE_LENGTH;
    }
  }

  private void setStartingPlayer() {
    this.ui.say("Which player should start? (enter 1 if player 'O' and 2 if player'X')");
    int playerNumber = this.ui.getNumberFromUser(NumberRange.of(1, 2));
    if (playerNumber == 2) {
      this.players.changeStarting();
    }
  }

  private void showNextMove(Player currentPlayer, Board board) {
    this.ui.say(currentPlayer.toString());
    this.ui.say(board.toString());
    this.ui.say("Please enter field number (whole number):");
  }

  private FieldNumber getFieldFromUser(int boardCapacity) throws NumberLowerThanOneException {
    NumberRange<Integer> boardBoundaryFields = NumberRange.of(
        Settings.INSTANCE.FIRST_FIELD_NUMBER,
        boardCapacity
    );
    return FieldNumber.valueOf(ui.getNumberFromUser(boardBoundaryFields));
  }

  private void endGameRun(Board board, BoardValidator boardValidator) {
    this.ui.say(board.toString());
    this.ui.say("Demo game is over!");
    if (boardValidator.getWinner() == null) {
      this.ui.say("It's a draw!");
    } else {
      this.ui.say(String.format("The winner is %s!", boardValidator.getWinner()));
    }
  }
}
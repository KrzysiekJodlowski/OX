package com.github.krzysiekjodlowski.ox;

/**
 * Keep settings for whole game. As a singleton
 * it is reachable from everywhere in the game.
 * ATTENTION - This very truncated implementation
 * is temporary and will change in the future.
 *
 * @author Krzysztof Jodlowski
 */
public enum Settings {
  INSTANCE;

  static final int MIN_GAME_BOARD_SIDE_LENGTH = 3;
  static final int MAX_GAME_BOARD_SIDE_LENGTH = 40;
  static final int FIRST_FIELD_NUMBER = 1;
  static int gameBoardSideLength = 3;
  /**
   * Counts number of fields in game board.
   *
   * @return number of fields
   */
  public int boardCapacity() {
    return gameBoardSideLength * gameBoardSideLength;
  }
}

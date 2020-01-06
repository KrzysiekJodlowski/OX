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

  final int MIN_GAME_BOARD_SIDE_LENGTH = 3;
  final int MAX_GAME_BOARD_SIDE_LENGTH = 40;
  final int FIRST_FIELD_NUMBER = 1;
}

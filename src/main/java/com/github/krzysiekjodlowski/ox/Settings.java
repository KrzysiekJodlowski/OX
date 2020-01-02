package com.github.krzysiekjodlowski.ox;

enum Settings {
    INSTANCE;

    static final int MIN_GAME_BOARD_SIDE_LENGTH = 3;
    static final int MAX_GAME_BOARD_SIDE_LENGTH = 40;
    static final int FIRST_FIELD_NUMBER = 1;
    static int gameBoardSideLength = 3;

    int boardCapacity() {
        return gameBoardSideLength * gameBoardSideLength;
    }
}

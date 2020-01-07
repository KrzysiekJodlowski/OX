package com.github.krzysiekjodlowski.ox.board;

import com.github.krzysiekjodlowski.ox.Move;

interface LineChecker {
  boolean checkLine(Move playersMove);
}

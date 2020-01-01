package com.github.krzysiekjodlowski.ox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * At this moment App purpose is to
 * serve as board generator.
 * Implementation of this
 * class will change and should
 * not be concerned when reviewing.
 *
 * @author KrzysiekJodlowski
 */
final class App {

    /**
     * Checks if there is any custom input and then creates
     * game board representation for each case from that file.
     *
     * @param args file with custom input (expecting file content as first parameter)
     */
    public static void main(final String[] args) throws NumberLowerThanOneException {
        Board board;
        int boardSize = 3;

        if (args.length > 0) {
            try {
                Scanner scanner = new Scanner(
                        new FileInputStream(new File(args[0]))
                );
                while (scanner.hasNextInt()) {
                    boardSize = scanner.nextInt();
                    board = new Board(boardSize);
                    System.out.println(board);
                };
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        } else {
            board = new Board(boardSize);
            System.out.println(board);
        }
    }
}

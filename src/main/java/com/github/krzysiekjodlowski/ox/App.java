package com.github.krzysiekjodlowski.ox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * At this moment App checks if there
 * is any custom input and then creates
 * game board representation for each case
 * from that file. Implementation of this
 * class will change and should not be
 * concerned when reviewing.
 * @author KrzysiekJodlowski
 */
final class App {

    /**
     * Private according to checkstyle.
     */
    private App() {

    }

    /**
     * @param args file with custom input (expecting file content as first parameter)
     */
    public static void main(final String[] args) {
        Board board;
        int boardSize = 3;
        BoardPrinter boardPrinter = new BoardPrinter(boardSize);

        if (args.length > 0) {
            Scanner scanner = null;
            try {
                scanner = new Scanner(
                        new FileInputStream(new File(args[0]))
                );
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            while (scanner != null &&scanner.hasNextInt()) {
                boardSize = scanner.nextInt();
                board = new Board(boardSize);
                boardPrinter = new BoardPrinter(boardSize);
                System.out.println(
                        boardPrinter.getBoardRepresentation(board)
                );
            }
        } else {
            board = new Board(boardSize);
            System.out.println(
                    boardPrinter.getBoardRepresentation(board)
            );
        }
    }
}

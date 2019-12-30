package com.github.krzysiekjodlowski.ox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author KrzysiekJodlowski
 */
final class App {

    /**
     * Private according to checkstyle.
     */
    private App() {

    }

    /**
     * In this iteration App checks if there
     * is any custom input and then creates
     * game board representation for each case
     * from that file.
     * @param args file with custom input
     * @throws FileNotFoundException when there is no such file
     * @throws BoardSizeOutOfBoundsException when board size
     * parameter is too big
     */
    public static void main(final String[] args)
            throws FileNotFoundException, BoardSizeOutOfBoundsException {
        Board board;
        int boardSize = 3;
        BoardPrinter boardPrinter = new BoardPrinter();

        if (args.length == 1) {
            Scanner scanner = new Scanner(
                    new FileInputStream(new File(args[0]))
            );
            while (scanner.hasNextLine()) {
                boardSize = scanner.nextInt();
                board = new Board(boardSize);
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

/* (C)2023 */
package io.github.andrewfitzy.day_18;

import java.util.List;

public final class Task02 {

    private static final char LIT = '#';
    private static final char UNLIT = '.';
    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve(int iterations) {
        char[][] board = new char[fileContent.size()][fileContent.get(0).length()];
        for (int row = 0; row < fileContent.size(); row++) {
            for (int column = 0; column < fileContent.get(row).length(); column++) {
                board[row][column] = fileContent.get(row).charAt(column);
            }
        }

        // Now need to go through and build up a new board based on this board
        for (int iteration = 0; iteration < iterations; iteration++) {
            board = processBoard(board);
        }

        int count = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == LIT) {
                    count++;
                }
            }
        }
        return count;
    }

    private char[][] processBoard(char[][] board) {
        char[][] tmpBoard = new char[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (isCorner(row, column, board)) {
                    tmpBoard[row][column] = LIT;
                    continue;
                }
                int litNeighbourCount = getLitNeighbourCount(row, column, board);
                if (LIT == board[row][column]) {
                    if (litNeighbourCount == 2 || litNeighbourCount == 3) {
                        tmpBoard[row][column] = LIT;
                        continue;
                    }
                    tmpBoard[row][column] = UNLIT;
                    continue;
                }
                if ('.' == board[row][column]) {
                    if (litNeighbourCount == 3) {
                        tmpBoard[row][column] = LIT;
                        continue;
                    }
                    tmpBoard[row][column] = UNLIT;
                }
            }
        }
        board = tmpBoard;
        return board;
    }

    private boolean isCorner(int row, int column, char[][] board) {
        if (row == 0 && column == 0) {
            return true;
        }
        if (row == 0 && column == board[row].length - 1) {
            return true;
        }
        if (row == board.length - 1 && column == 0) {
            return true;
        }
        if (row == board.length - 1 && column == board[row].length - 1) {
            return true;
        }
        return false;
    }

    private int getLitNeighbourCount(int rowPointer, int columnPointer, char[][] board) {
        int litNeighbourCount = 0;
        for (int row = -1; row < 2; row++) {
            for (int column = -1; column < 2; column++) {
                int inspectingRow = rowPointer + row;
                int inspectingColumn = columnPointer + column;
                if (row == 0 && column == 0) {
                    continue;
                }
                if (inspectingRow < 0) {
                    continue;
                }
                if (inspectingColumn < 0) {
                    continue;
                }
                if (inspectingRow == board.length) {
                    continue;
                }
                if (inspectingColumn == board[inspectingRow].length) {
                    continue;
                }
                if (board[inspectingRow][inspectingColumn] == LIT) {
                    litNeighbourCount++;
                }
            }
        }
        return litNeighbourCount;
    }
}

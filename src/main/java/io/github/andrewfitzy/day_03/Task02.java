/* (C)2022 */
package io.github.andrewfitzy.day_03;

import java.util.HashSet;
import java.util.Set;

public class Task02 {

    private final String input;

    public Task02(final String input) {
        this.input = input;
    }

    public int solve() {
        Set<String> visitedSet = new HashSet<String>();
        char[] chars = input.toCharArray();
        int santaRow = 0;
        int santaCol = 0;

        int roboRow = 0;
        int roboCol = 0;

        // Start position is always added
        visitedSet.add(String.format("%s,%s", 0, 0));
        boolean isSanta = true;
        for (char position : chars) {
            if (isSanta) {
                if ('>' == position) {
                    santaCol++;
                }
                if ('<' == position) {
                    santaCol--;
                }
                if ('^' == position) {
                    santaRow--;
                }
                if ('v' == position) {
                    santaRow++;
                }
                visitedSet.add(String.format("%s,%s", santaCol, santaRow));
            } else {
                if ('>' == position) {
                    roboCol++;
                }
                if ('<' == position) {
                    roboCol--;
                }
                if ('^' == position) {
                    roboRow--;
                }
                if ('v' == position) {
                    roboRow++;
                }
                visitedSet.add(String.format("%s,%s", roboCol, roboRow));
            }
            isSanta = !isSanta;
        }
        return visitedSet.size();
    }
}

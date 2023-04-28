/* (C)2022 */
package io.github.andrewfitzy.day_03;

import java.util.HashSet;
import java.util.Set;

public class Task01 {

    private final String input;

    public Task01(final String input) {
        this.input = input;
    }

    public int solve() {
        Set<String> visitedSet = new HashSet<String>();
        char[] chars = input.toCharArray();
        int row = 0;
        int col = 0;

        // Start position is always added
        visitedSet.add(String.format("%s,%s", col, row));
        for (char position : chars) {
            if ('>' == position) {
                col++;
            }
            if ('<' == position) {
                col--;
            }
            if ('^' == position) {
                row--;
            }
            if ('v' == position) {
                row++;
            }
            visitedSet.add(String.format("%s,%s", col, row));
        }
        return visitedSet.size();
    }
}

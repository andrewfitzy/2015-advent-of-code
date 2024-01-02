/* (C)2022 */
package io.github.andrewfitzy.day_03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        Set<String> visitedSet = new HashSet<String>();
        char[] chars = fileContent.get(0).toCharArray();
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

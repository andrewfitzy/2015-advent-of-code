/* (C)2022 */
package io.github.andrewfitzy.day_03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        Set<String> visitedSet = new HashSet<String>();
        char[] chars = fileContent.get(0).toCharArray();
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

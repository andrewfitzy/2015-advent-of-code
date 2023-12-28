/* (C)2022 */
package io.github.andrewfitzy.day_01;

import java.util.List;

public class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent;
    }

    public int solve() {
        char[] chars = fileContent.get(0).toCharArray();
        int pointer = 0;
        for (char position : chars) {
            if ('(' == position) {
                pointer = pointer + 1;
            }
            if (')' == position) {
                pointer = pointer - 1;
            }
        }
        return pointer;
    }
}

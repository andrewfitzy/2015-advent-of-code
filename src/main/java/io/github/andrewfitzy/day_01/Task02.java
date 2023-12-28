/* (C)2022 */
package io.github.andrewfitzy.day_01;

import java.util.List;

public class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent;
    }

    public int solve() {
        char[] chars = fileContent.get(0).toCharArray();
        int pointer = 0;
        int location = 0;
        for (int i = 0; i < chars.length; i++) {
            char position = chars[i];
            if ('(' == position) {
                pointer = pointer + 1;
            }
            if (')' == position) {
                pointer = pointer - 1;
            }
            if (pointer < 0) {
                location = i + 1;
                break;
            }
        }
        return location;
    }
}

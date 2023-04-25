/* (C)2022 */
package io.github.andrewfitzy.day_01;

public class Task02 {

    private final String input;

    public Task02(final String input) {
        this.input = input;
    }

    public int solve() {
        char[] chars = input.toCharArray();
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

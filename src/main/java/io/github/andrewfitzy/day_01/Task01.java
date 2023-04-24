/* (C)2022 */
package io.github.andrewfitzy.day_01;

public class Task01 {

    private final String input;

    public Task01(final String input) {
        this.input = input;
    }

    public int solve() {
        char[] chars = input.toCharArray();
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

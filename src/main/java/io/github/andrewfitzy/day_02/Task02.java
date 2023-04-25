/* (C)2022 */
package io.github.andrewfitzy.day_02;

public class Task02 {

    private final String input;

    public Task02(final String input) {
        this.input = input;
    }

    public int solve() {
        String[] lwh = input.split("x", -1);

        int length = Integer.parseInt(lwh[0]);
        int width = Integer.parseInt(lwh[1]);
        int height = Integer.parseInt(lwh[2]);

        int smallestFace = getSmallestFace(length, width, height);

        int totalRibbon = (length * width * height) + smallestFace;
        return totalRibbon;
    }

    private int getSmallestFace(int length, int width, int height) {
        int x = 0;
        int y = 0;

        if (length >= width && length >= height) {
            x = width;
            y = height;
        } else if (width >= length && width >= height) {
            x = length;
            y = height;
        } else {
            x = length;
            y = width;
        }

        return (2 * x) + (2 * y);
    }
}

/* (C)2022 */
package io.github.andrewfitzy.day_02;

public class Task01 {

    private final String input;

    public Task01(final String input) {
        this.input = input;
    }

    public int solve() {
        String[] lwh = input.split("x", -1);

        int length = Integer.parseInt(lwh[0]);
        int width = Integer.parseInt(lwh[1]);
        int height = Integer.parseInt(lwh[2]);
        int lw = length * width;
        int wh = width * height;
        int lh = length * height;

        int smallestSide = getSmallestSide(lw, wh, lh);

        int totalPaper = (2 * lw) + (2 * wh) + (2 * lh) + smallestSide;
        return totalPaper;
    }

    private int getSmallestSide(int lw, int wh, int lh) {
        int smallestSide = lw;
        if (wh < smallestSide) {
            smallestSide = wh;
        }
        if (lh < smallestSide) {
            smallestSide = lh;
        }
        return smallestSide;
    }
}

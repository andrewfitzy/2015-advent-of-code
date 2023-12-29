/* (C)2022 */
package io.github.andrewfitzy.day_02;

import java.util.List;

public class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        int totalPaper = 0;
        for (String content : fileContent) {
            String[] lwh = content.split("x", -1);

            int length = Integer.parseInt(lwh[0]);
            int width = Integer.parseInt(lwh[1]);
            int height = Integer.parseInt(lwh[2]);
            int lw = length * width;
            int wh = width * height;
            int lh = length * height;

            int smallestSide = getSmallestSide(lw, wh, lh);

            totalPaper = totalPaper + (2 * lw) + (2 * wh) + (2 * lh) + smallestSide;
        }
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

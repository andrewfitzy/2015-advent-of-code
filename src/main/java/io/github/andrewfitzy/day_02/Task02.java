/* (C)2022 */
package io.github.andrewfitzy.day_02;

import java.util.List;

public class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent;
    }

    public int solve() {
        int totalRibbon = 0;
        for(String content : fileContent) {
            String[] lwh = content.split("x", -1);

            int length = Integer.parseInt(lwh[0]);
            int width = Integer.parseInt(lwh[1]);
            int height = Integer.parseInt(lwh[2]);

            int smallestFace = getSmallestFace(length, width, height);

            totalRibbon = totalRibbon + (length * width * height) + smallestFace;
        }
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

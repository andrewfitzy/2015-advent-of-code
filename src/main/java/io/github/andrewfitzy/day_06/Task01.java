/* (C)2023 */
package io.github.andrewfitzy.day_06;

import java.util.List;

public class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        int[][] map = new int[1000][1000];

        for (String input : fileContent) {
            String[] parts = input.split(" ");

            String startPoint = parts[parts.length - 3];
            String endPoint = parts[parts.length - 1];
            int startC = Integer.parseInt(startPoint.split(",")[0]);
            int startR = Integer.parseInt(startPoint.split(",")[1]);
            int endC = Integer.parseInt(endPoint.split(",")[0]);
            int endR = Integer.parseInt(endPoint.split(",")[1]);
            for (int i = startR; i <= endR; i++) {
                for (int j = startC; j <= endC; j++) {
                    if (input.startsWith("turn on")) {
                        map[i][j] = 1;
                    }
                    if (input.startsWith("turn off")) {
                        map[i][j] = 0;
                    }
                    if (input.startsWith("toggle")) {
                        map[i][j] = (map[i][j] == 1) ? 0 : 1;
                    }
                }
            }
        }

        int lit = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                lit = lit + map[i][j];
            }
        }
        return lit;
    }
}

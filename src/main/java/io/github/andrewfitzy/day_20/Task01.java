/* (C)2023 */
package io.github.andrewfitzy.day_20;

import java.util.*;

public final class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        // divide by 10 to reduce iterations
        int desiredPresents = Integer.parseInt(fileContent.get(0)) / 10;
        // divide by 2 to get max iterations, there will be no increments past this once past half way
        int maxIterations = desiredPresents / 2;
        int[] houses = new int[maxIterations + 1];
        for (int elf = 1; elf <= maxIterations; elf++) {
            for (int house = elf; house <= maxIterations; house = house + elf) {
                houses[house] = houses[house] + elf;
            }
        }
        int house = 0;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] >= desiredPresents) {
                house = i;
                break;
            }
        }
        return house;
    }
}

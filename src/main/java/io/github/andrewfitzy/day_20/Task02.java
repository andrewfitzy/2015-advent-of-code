/* (C)2023 */
package io.github.andrewfitzy.day_20;

import java.util.List;

public final class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {

        int desiredPresents = Integer.parseInt(fileContent.get(0));

        // divide by 10 to reduce iterations
        int maxIterations = desiredPresents / 10;

        // divide by 2 to get max iterations, there will be no increments past this once past half way
        maxIterations = maxIterations / 2;

        int[] houses = new int[maxIterations + 1];
        for (int elf = 1; elf <= maxIterations; elf++) {
            int deliveries = 0;
            for (int house = elf; house <= maxIterations; house = house + elf) {
                deliveries++;
                houses[house] = houses[house] + (elf * 11);
                if (deliveries == 50) {
                    break;
                }
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

/* (C)2023 */
package io.github.andrewfitzy.day_17;

import java.util.ArrayList;
import java.util.List;

public class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve(int litres) {
        List<Integer> containers =
                fileContent.stream().map(entry -> Integer.parseInt(entry)).toList();
        List<List<Integer>> combinations = buildCombinations(containers);

        int minimumContainers = fileContent.size();
        int minimumContainersCount = 0;
        for (List<Integer> combination : combinations) {
            int combinationTotal = 0;
            for (Integer container : combination) {
                combinationTotal = combinationTotal + container;
            }
            if (combinationTotal != litres) {
                continue;
            }
            if (combination.size() < minimumContainers) {
                minimumContainers = combination.size();
                minimumContainersCount = 1;
                continue;
            }
            if (combination.size() == minimumContainers) {
                minimumContainersCount = minimumContainersCount + 1;
            }
        }
        return minimumContainersCount;
    }

    private List<List<Integer>> buildCombinations(List<Integer> containers) {
        List<List<Integer>> combinations = new ArrayList<>();
        powerSetInternal(containers, combinations, new ArrayList<>(), 0);
        return combinations;
    }

    private void powerSetInternal(
            List<Integer> set, List<List<Integer>> combinations, List<Integer> currentCombination, int index) {
        if (index == set.size()) {
            combinations.add(new ArrayList<>(currentCombination));
        } else {
            currentCombination.add(set.get(index));
            powerSetInternal(set, combinations, currentCombination, index + 1);
            currentCombination.remove(currentCombination.size() - 1);
            powerSetInternal(set, combinations, currentCombination, index + 1);
        }
    }
}

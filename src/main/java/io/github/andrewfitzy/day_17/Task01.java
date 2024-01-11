/* (C)2023 */
package io.github.andrewfitzy.day_17;

import java.util.ArrayList;
import java.util.List;

public final class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve(int litres) {

        List<Integer> containers =
                fileContent.stream().map(entry -> Integer.parseInt(entry)).toList();
        List<List<Integer>> combinations = buildCombinations(containers);
        int possibleCombinations = 0;
        for (List<Integer> combination : combinations) {
            int combinationTotal = 0;
            for (Integer container : combination) {
                combinationTotal = combinationTotal + container;
            }
            if (combinationTotal == litres) {
                possibleCombinations = possibleCombinations + 1;
            }
        }
        return possibleCombinations;
    }

    private List<List<Integer>> buildCombinations(List<Integer> containers) {
        List<List<Integer>> combinations = new ArrayList<>();
        buildCombinationsRecursively(containers, combinations, new ArrayList<>(), 0);
        return combinations;
    }

    private void buildCombinationsRecursively(
            List<Integer> set, List<List<Integer>> combinations, List<Integer> currentCombination, int index) {
        if (index == set.size()) {
            combinations.add(new ArrayList<>(currentCombination));
        } else {
            currentCombination.add(set.get(index));
            buildCombinationsRecursively(set, combinations, currentCombination, index + 1);
            currentCombination.remove(currentCombination.size() - 1);
            buildCombinationsRecursively(set, combinations, currentCombination, index + 1);
        }
    }
}

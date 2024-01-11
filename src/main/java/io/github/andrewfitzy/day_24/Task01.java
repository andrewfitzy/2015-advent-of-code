/* (C)2023 */
package io.github.andrewfitzy.day_24;

import java.util.ArrayList;
import java.util.List;

public final class Task01 {

    public static final int NUMBER_OF_COMPARTMENTS = 3;
    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public long solve() {
        int totalWeight = 0;
        List<Integer> weights = new ArrayList<>();
        for (String input : fileContent) {
            int weight = Integer.parseInt(input);
            totalWeight = totalWeight + weight;
            weights.add(weight);
        }

        int targetWeightForEachCompartment = totalWeight / NUMBER_OF_COMPARTMENTS;
        List<List<Integer>> matchingCombinations = buildMatchingCombinations(targetWeightForEachCompartment, weights);

        int smallestNumber = Integer.MAX_VALUE;
        for (List<Integer> combination : matchingCombinations) {
            if (combination.size() <= smallestNumber) {
                smallestNumber = combination.size();
            }
        }

        long lowestQeForGroup = Long.MAX_VALUE;
        for (List<Integer> combination : matchingCombinations) {
            if (combination.size() == smallestNumber) {
                long qe = 1L;
                for (Integer item : combination) {
                    qe = qe * item;
                }

                if (qe < lowestQeForGroup) {
                    lowestQeForGroup = qe;
                }
            }
        }

        return lowestQeForGroup;
    }

    private List<List<Integer>> buildMatchingCombinations(int targetWeightForEachCompartment, List<Integer> weights) {
        List<List<Integer>> combinations = new ArrayList<>();
        buildCombinationsRecursively(targetWeightForEachCompartment, weights, combinations, new ArrayList<>(), 0);
        return combinations;
    }

    private void buildCombinationsRecursively(
            int targetWeightForEachCompartment,
            List<Integer> set,
            List<List<Integer>> combinations,
            List<Integer> currentCombination,
            int index) {
        if (index == set.size()) {
            int sum = currentCombination.stream().reduce(0, (num1, num2) -> num1 + num2);
            if (targetWeightForEachCompartment == sum) {
                combinations.add(new ArrayList<>(currentCombination));
            }
        } else {
            currentCombination.add(set.get(index));
            buildCombinationsRecursively(
                    targetWeightForEachCompartment, set, combinations, currentCombination, index + 1);
            currentCombination.remove(currentCombination.size() - 1);
            buildCombinationsRecursively(
                    targetWeightForEachCompartment, set, combinations, currentCombination, index + 1);
        }
    }
}

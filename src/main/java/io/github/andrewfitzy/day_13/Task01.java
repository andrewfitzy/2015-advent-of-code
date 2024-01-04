/* (C)2023 */
package io.github.andrewfitzy.day_13;

import java.util.*;

public final class Task01 {
    private record Pair(String left, String right) {}

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        Map<Pair, Integer> seatingMap = new HashMap<>();
        Set<String> uniquePeople = new HashSet<>();
        for (String input : fileContent) {
            String[] parts = input.split(" ");
            String left = parts[0];
            String right = parts[10].replace(".", "");
            int happiness = Integer.parseInt(parts[3]);
            if ("lose".equals(parts[2])) {
                happiness = Math.negateExact(happiness);
            }

            uniquePeople.add(left);
            uniquePeople.add(right);
            Pair lrPair = new Pair(left, right);
            seatingMap.put(lrPair, happiness);
        }

        List<String> peopleList = new LinkedList<>(uniquePeople);
        List<List<String>> peoplePermutations = buildCombinations(peopleList);

        int happiestPlan = 0;
        for (List<String> permutation : peoplePermutations) {
            int happiness = getPermutationHappiness(permutation, seatingMap);
            if (happiness > happiestPlan) {
                happiestPlan = happiness;
            }
        }

        return happiestPlan;
    }

    private int getPermutationHappiness(List<String> permutation, Map<Pair, Integer> seatingMap) {
        int happiness = 0;
        for (int i = 1; i < permutation.size(); i++) {
            Pair tmpPair = new Pair(permutation.get(i - 1), permutation.get(i));
            int tmpHappiness = seatingMap.get(tmpPair);
            happiness = happiness + tmpHappiness;

            Pair tmpPair2 = new Pair(permutation.get(i), permutation.get(i - 1));
            int tmpHappiness2 = seatingMap.get(tmpPair2);
            happiness = happiness + tmpHappiness2;
        }
        Pair tmpPair = new Pair(permutation.get(0), permutation.get(permutation.size() - 1));
        int tmpHappiness = seatingMap.get(tmpPair);
        happiness = happiness + tmpHappiness;

        Pair tmpPair2 = new Pair(permutation.get(permutation.size() - 1), permutation.get(0));
        int tmpHappiness2 = seatingMap.get(tmpPair2);
        happiness = happiness + tmpHappiness2;
        return happiness;
    }

    private List<List<String>> buildCombinations(List<String> people) {
        List<List<String>> combinations = new ArrayList<>();
        buildCombinationsRecursively(people, combinations, 0);
        return combinations;
    }

    private void buildCombinationsRecursively(List<String> people, List<List<String>> combinations, int index) {
        if (index == people.size() - 1) {
            combinations.add(new ArrayList<>(people));
        }
        for (int i = index; i < people.size(); i++) {
            swap(people, i, index);
            buildCombinationsRecursively(people, combinations, index + 1);
            swap(people, i, index);
        }
    }

    private void swap(List<String> elements, int a, int b) {
        String tmp = elements.get(a);
        elements.set(a, elements.get(b));
        elements.set(b, tmp);
    }
}

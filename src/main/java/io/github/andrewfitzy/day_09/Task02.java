/* (C)2023 */
package io.github.andrewfitzy.day_09;

import java.util.*;

public class Task02 {
    private record Pair(String left, String right) {}

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        Map<Pair, Integer> legMap = new HashMap<>();
        Set<String> uniqueLocations = new HashSet<>();
        for (String input : fileContent) {
            String[] parts = input.split(" ");
            String left = parts[0];
            String right = parts[2];
            int distance = Integer.parseInt(parts[4]);

            uniqueLocations.add(left);
            uniqueLocations.add(right);
            Pair lrPair = new Pair(left, right);
            Pair rlPair = new Pair(right, left);
            legMap.put(lrPair, distance);
            legMap.put(rlPair, distance);
        }

        List<String> locationsList = new LinkedList<>(uniqueLocations);
        List<List<String>> locationPermutations = buildCombinations(locationsList);

        int longestPath = 0;
        for (List<String> permutation : locationPermutations) {
            int distance = getPermutationDistance(permutation, legMap);
            if (distance > longestPath) {
                longestPath = distance;
            }
        }

        return longestPath;
    }

    private int getPermutationDistance(List<String> permutation, Map<Pair, Integer> legMap) {
        int distance = 0;
        for (int i = 1; i < permutation.size(); i++) {
            Pair tmpPair = new Pair(permutation.get(i - 1), permutation.get(i));
            int tmpDistance = legMap.get(tmpPair);
            distance = distance + tmpDistance;
        }
        return distance;
    }

    private List<List<String>> buildCombinations(List<String> locations) {
        List<List<String>> combinations = new ArrayList<>();
        buildCombinationsRecursively(locations, combinations, 0);
        return combinations;
    }

    private void buildCombinationsRecursively(List<String> locations, List<List<String>> combinations, int index) {
        if (index == locations.size() - 1) {
            combinations.add(new ArrayList<>(locations));
        }
        for (int i = index; i < locations.size(); i++) {
            swap(locations, i, index);
            buildCombinationsRecursively(locations, combinations, index + 1);
            swap(locations, i, index);
        }
    }

    private void swap(List<String> elements, int a, int b) {
        String tmp = elements.get(a);
        elements.set(a, elements.get(b));
        elements.set(b, tmp);
    }
}

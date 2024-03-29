/* (C)2023 */
package io.github.andrewfitzy.day_16;

import java.util.*;

public final class Task02 {

    private final List<String> fileContent;

    private final Map<String, Integer> criteria;

    public Task02(List<String> criteria, final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
        this.criteria = new HashMap<>();
        for (String criterion : criteria) {
            String[] parts = criterion.split(" ");
            this.criteria.put(parts[0].replace(":", ""), Integer.parseInt(parts[1]));
        }
    }

    public int solve() {

        List<Map<String, Integer>> sueList = new ArrayList<>();
        for (int i = 0; i < fileContent.size(); i++) {
            String input = fileContent.get(i);
            Map sue = getSue(input);
            sueList.add(sue);
        }

        List<Map<String, Integer>> candidateSues = getCandidateSues(sueList);
        int sue = candidateSues.get(0).get("Sue");
        return sue;
    }

    private List<Map<String, Integer>> getCandidateSues(List<Map<String, Integer>> sueList) {
        List<Map<String, Integer>> candidateSues = new ArrayList<>();
        for (Map<String, Integer> sue : sueList) {
            boolean allCriteriaMatch = true;
            for (Map.Entry<String, Integer> criterion : criteria.entrySet()) {
                Integer attrbuteValue = sue.get(criterion.getKey());
                if (!Objects.isNull(attrbuteValue) && !attributeValueWithinRange(attrbuteValue, criterion)) {
                    allCriteriaMatch = false;
                    break;
                }
            }
            if (allCriteriaMatch) {
                candidateSues.add(sue);
            }
        }
        return candidateSues;
    }

    private static boolean attributeValueWithinRange(Integer attrbuteValue, Map.Entry<String, Integer> criterion) {
        if ("cats".equals(criterion.getKey()) || "trees".equals(criterion.getKey())) {
            return attrbuteValue > criterion.getValue();
        }
        if ("pomeranians".equals(criterion.getKey()) || "goldfish".equals(criterion.getKey())) {
            return attrbuteValue < criterion.getValue();
        }
        return attrbuteValue.equals(criterion.getValue());
    }

    private Map<String, Integer> getSue(String input) {
        Map<String, Integer> sue = new HashMap<>();
        String[] parts = input.split(" ");
        sue.put(parts[0], Integer.parseInt(parts[1].replace(":", "")));
        sue.put(parts[2].replace(":", ""), Integer.parseInt(parts[3].replace(",", "")));
        sue.put(parts[4].replace(":", ""), Integer.parseInt(parts[5].replace(",", "")));
        sue.put(parts[6].replace(":", ""), Integer.parseInt(parts[7].replace(",", "")));
        return sue;
    }
}

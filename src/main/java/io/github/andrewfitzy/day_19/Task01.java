/* (C)2023 */
package io.github.andrewfitzy.day_19;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        Set<String> seen = new HashSet<>();
        String molecule = fileContent.get(fileContent.size() - 1);
        Map<String, List<String>> replacementMap = new HashMap<>();
        for (int i = 0; i < fileContent.size() - 2; i++) {
            String[] parts = fileContent.get(i).split(" ");
            List<String> replacementList = replacementMap.getOrDefault(parts[0], new ArrayList<>());
            replacementList.add(parts[2]);
            replacementMap.put(parts[0], replacementList);
        }
        for (Map.Entry<String, List<String>> entry : replacementMap.entrySet()) {
            Pattern NUMBER_PATTERN = Pattern.compile("(" + entry.getKey() + ")");

            Matcher matcher = NUMBER_PATTERN.matcher(molecule);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                for (String replacement : entry.getValue()) {
                    StringBuilder builder = new StringBuilder();
                    String left = molecule.substring(0, start);
                    String right = molecule.substring(end);
                    builder.append(left);
                    builder.append(replacement);
                    builder.append(right);
                    seen.add(builder.toString());
                }
            }
        }
        return seen.size();
    }
}

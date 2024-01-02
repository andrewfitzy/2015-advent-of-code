/* (C)2023 */
package io.github.andrewfitzy.day_10;

import java.util.List;

public final class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        String input = fileContent.get(0);
        for (int i = 0; i < 40; i++) {
            input = processInput(input);
        }
        return input.length();
    }

    String processInput(String input) {
        String[] parts = input.split("");
        String group = parts[0];
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            if (part.equals(group)) {
                count++;
                continue;
            }
            builder.append(count).append(group);
            group = part;
            count = 1;
        }
        builder.append(count).append(group);
        return builder.toString();
    }
}

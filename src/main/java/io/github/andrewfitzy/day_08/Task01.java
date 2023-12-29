/* (C)2023 */
package io.github.andrewfitzy.day_08;

import java.util.List;

public class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        int totalStringLength = 0;
        int totalMemoryUsage = 0;
        for (String input : fileContent) {
            totalStringLength = totalStringLength + input.length();
            totalMemoryUsage = totalMemoryUsage + getMemoryUsage(input);
        }
        return totalStringLength - totalMemoryUsage;
    }

    private int getMemoryUsage(String input) {
        String tmpString = input.substring(1, input.length() - 1);
        tmpString = tmpString.replace("\\\\", "_");
        tmpString = tmpString.replace("\\\"", "_");
        tmpString = tmpString.replaceAll("(\\\\x[a-z0-9]{2})", "_");
        return tmpString.length();
    }
}

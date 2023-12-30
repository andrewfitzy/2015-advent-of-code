/* (C)2023 */
package io.github.andrewfitzy.day_12;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task01 {
    public final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        String input = fileContent.get(0);
        Matcher matcher = NUMBER_PATTERN.matcher(input);
        int total = 0;
        while (matcher.find()) {
            total = total + Integer.parseInt(matcher.group());
        }
        return total;
    }
}

/* (C)2023 */
package io.github.andrewfitzy.day_08;

import java.util.List;

public class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        int totalStringLength = 0;
        int totalEscapedStringSize = 0;
        for (String input : fileContent) {
            totalStringLength = totalStringLength + input.length();
            totalEscapedStringSize = totalEscapedStringSize + getEscapedStringSize(input);
        }
        return totalEscapedStringSize - totalStringLength;
    }

    private int getEscapedStringSize(String input) {
        String tmpReplace = input.replace("\\", "\\\\").replace("\"", "\\\"");
        return tmpReplace.length() + 2; // surround with ""
    }
}

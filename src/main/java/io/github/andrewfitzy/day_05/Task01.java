/* (C)2022 */
package io.github.andrewfitzy.day_05;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task01 {
    final Logger logger = LoggerFactory.getLogger(Task01.class);
    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent;
    }

    public int solve() {
        int validInput = 0;
        for (String input : fileContent) {
            if (!hasValidVowels(input)) {
                logger.info("Vowels check fails: {}", input);
                continue;
            }
            if (!containsDoubleLetter(input)) {
                logger.info("Double letter check fails: {}", input);
                continue;
            }
            if (containsDisallowedString(input)) {
                logger.info("Disallowed String check fails: {}", input);
                continue;
            }
            validInput++;
        }
        return validInput;
    }

    private boolean hasValidVowels(String input) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int vowelCount = 0;
        for (char letter : input.toCharArray()) {
            if (vowels.contains(letter)) {
                vowelCount++;
            }
        }
        return vowelCount >= 3;
    }

    private boolean containsDoubleLetter(String input) {
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) == input.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsDisallowedString(String input) {
        Pattern pattern = Pattern.compile("(ab|cd|pq|xy)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}

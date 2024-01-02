/* (C)2022 */
package io.github.andrewfitzy.day_05;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Task02 {
    final Logger logger = LoggerFactory.getLogger(Task02.class);
    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        int validInput = 0;
        for (String input : fileContent) {

            if (!containsSeparatedDouble(input)) {
                logger.info("Separated double letter check fails: {}", input);
                continue;
            }
            if (containsOverlaps(input)) {
                logger.info("Overlapping letter check fails: {}", input);
                continue;
            }
            if (!containsValidDoubleDouble(input)) {
                logger.info("Double double check fails: {}", input);
                continue;
            }
            validInput++;
        }
        return validInput;
    }

    private boolean containsSeparatedDouble(String input) {
        for (int i = 2; i < input.length(); i++) {
            if (input.charAt(i - 1) != input.charAt(i) && input.charAt(i - 2) == input.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsValidDoubleDouble(String input) {
        Map<String, Integer> pairMap = new HashMap<>();
        for (int i = 1; i < input.length(); i++) {
            String pair = "" + input.charAt(i - 1) + input.charAt(i);
            int existingCount = pairMap.getOrDefault(pair, 0);
            existingCount++;
            pairMap.put(pair, existingCount);
        }

        for (Map.Entry<String, Integer> entry : pairMap.entrySet()) {
            if (entry.getValue() >= 2) {
                return true;
            }
        }
        return false;
    }

    private boolean containsOverlaps(String input) {
        char letter = '0';
        int highestConsecutiveCount = 0;
        int consecutiveCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == letter) {
                consecutiveCount++;
            } else {
                letter = input.charAt(i);
                consecutiveCount = 1;
            }
            if (consecutiveCount > highestConsecutiveCount) {
                highestConsecutiveCount = consecutiveCount;
            }
        }
        return highestConsecutiveCount > 2 && highestConsecutiveCount % 2 != 0;
    }
}

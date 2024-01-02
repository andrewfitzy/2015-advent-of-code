/* (C)2023 */
package io.github.andrewfitzy.day_07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve(String wireId) {
        Map<String, Integer> tracking = new HashMap<>();
        for (String input : fileContent) {
            String[] parts = input.split(" ");
            String key = parts[parts.length - 1];
            Integer value = null;
            if (parts.length == 3) {
                try {
                    value = Integer.valueOf(parts[0]);
                } catch (NumberFormatException numberFormatException) {
                    // silently ignore the error
                }
            }
            tracking.put(key, value);
        }

        boolean trackingChanged = true;
        while (trackingChanged) {
            trackingChanged = false;
            for (String input : fileContent) {
                String[] parts = input.split(" ");
                String key = parts[parts.length - 1];

                if (tracking.get(key) == null) {
                    if (input.contains("AND")) {
                        if (tracking.get(parts[0]) != null && tracking.get(parts[2]) != null) {
                            Integer left = tracking.get(parts[0]);
                            Integer right = tracking.get(parts[2]);
                            Integer value = left & right;
                            tracking.put(key, value);
                            trackingChanged = true;
                            continue;
                        }
                        if ((parts[0].matches("\\d") && tracking.get(parts[2]) != null)
                                || (parts[2].matches("\\d") && tracking.get(parts[0]) != null)) {
                            Integer left =
                                    (parts[0].matches("\\d")) ? Integer.valueOf(parts[0]) : tracking.get(parts[0]);
                            Integer right =
                                    (parts[2].matches("\\d")) ? Integer.valueOf(parts[2]) : tracking.get(parts[2]);
                            Integer value = left & right;
                            tracking.put(key, value);
                            trackingChanged = true;
                            continue;
                        }
                    }
                    if (input.contains("OR")) {
                        if (tracking.get(parts[0]) != null && tracking.get(parts[2]) != null) {
                            Integer left = tracking.get(parts[0]);
                            Integer right = tracking.get(parts[2]);
                            Integer value = left | right;
                            tracking.put(key, value);
                            trackingChanged = true;
                            continue;
                        }
                        if ((parts[0].matches("\\d") && tracking.get(parts[2]) != null)
                                || (parts[2].matches("\\d") && tracking.get(parts[0]) != null)) {
                            Integer left =
                                    (parts[0].matches("\\d")) ? Integer.valueOf(parts[0]) : tracking.get(parts[0]);
                            Integer right =
                                    (parts[2].matches("\\d")) ? Integer.valueOf(parts[2]) : tracking.get(parts[2]);
                            Integer value = left | right;
                            tracking.put(key, value);
                            trackingChanged = true;
                            continue;
                        }
                    }
                    if (input.contains("NOT")) {
                        if (tracking.get(parts[1]) != null) {
                            Integer value = 65535 - tracking.get(parts[1]);
                            tracking.put(key, value);
                            trackingChanged = true;
                            continue;
                        }
                    }
                    if (input.contains("LSHIFT")) {
                        if (tracking.get(parts[0]) != null) {
                            Integer value = tracking.get(parts[0]) << Integer.parseInt(parts[2]);
                            tracking.put(key, value);
                            trackingChanged = true;
                            continue;
                        }
                    }
                    if (input.contains("RSHIFT")) {
                        if (tracking.get(parts[0]) != null) {
                            Integer value = tracking.get(parts[0]) >> Integer.parseInt(parts[2]);
                            tracking.put(key, value);
                            trackingChanged = true;
                            continue;
                        }
                    }
                    if (parts.length == 3) {
                        try {
                            Integer.valueOf(parts[0]);
                        } catch (NumberFormatException numberFormatException) {
                            if (tracking.get(parts[0]) != null) {
                                tracking.put(key, tracking.get(parts[0]));
                                trackingChanged = true;
                            }
                        }
                    }
                }
            }
        }
        return tracking.get(wireId);
    }
}

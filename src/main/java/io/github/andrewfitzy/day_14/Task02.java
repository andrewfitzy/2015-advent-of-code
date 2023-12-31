/* (C)2023 */
package io.github.andrewfitzy.day_14;

import java.util.*;

public class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve(int raceDuration) {
        Map<String, Integer> pointsMap = new HashMap<>();
        for (int i = 1; i < raceDuration; i++) {
            Set<String> leadingDeer = new HashSet<>();
            int leadingDistance = 0;
            for (String input : fileContent) {

                String[] parts = input.split(" ");
                String reindeer = parts[0];
                int speed = Integer.parseInt(parts[3]);
                int flightDuration = Integer.parseInt(parts[6]);
                int restDuration = Integer.parseInt(parts[13]);
                int distance = getDistanceAfterDuration(i, speed, flightDuration, restDuration);

                if (distance == leadingDistance) {
                    leadingDeer.add(reindeer);
                }
                if (distance > leadingDistance) {
                    leadingDistance = distance;
                    leadingDeer.clear();
                    leadingDeer.add(reindeer);
                }
            }
            for (String deer : leadingDeer) {
                int score = pointsMap.getOrDefault(deer, 0);
                score = score + 1;
                pointsMap.put(deer, score);
            }
        }
        int winningDistance = 0;
        for (Map.Entry<String, Integer> deerScore : pointsMap.entrySet()) {
            if (deerScore.getValue() > winningDistance) {
                winningDistance = deerScore.getValue();
            }
        }
        return winningDistance;
    }

    int getDistanceAfterDuration(int duration, int speed, int flightDuration, int restDuration) {
        int totalDuration = flightDuration + restDuration;
        int periods = duration / totalDuration;
        int distanceOverPeriods = periods * speed * flightDuration;

        int remainder = duration % totalDuration;
        int distanceOverRemainder = (remainder < flightDuration) ? speed * remainder : speed * flightDuration;
        return distanceOverPeriods + distanceOverRemainder;
    }
}

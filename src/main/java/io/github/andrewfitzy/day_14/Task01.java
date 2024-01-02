/* (C)2023 */
package io.github.andrewfitzy.day_14;

import java.util.List;

public final class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        int winningDistance = 0;
        for (String input : fileContent) {
            String[] parts = input.split(" ");
            String reindeer = parts[0];
            int speed = Integer.parseInt(parts[3]);
            int flightDuration = Integer.parseInt(parts[6]);
            int restDuration = Integer.parseInt(parts[13]);
            int distance = getDistanceAfterDuration(2503, speed, flightDuration, restDuration);
            if (distance > winningDistance) {
                winningDistance = distance;
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

/* (C)2023 */
package io.github.andrewfitzy.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    // After one second, Dancer has gone 16 km.
    // After ten seconds, Dancer has gone 160 km.
    // On the eleventh second, Comet begins resting (staying at 140 km), and Dancer continues on for a total distance of
    // 176 km.
    // On the 12th second, both reindeer are resting.
    // They continue to rest until the 138th second, when Comet flies for another ten seconds.
    // On the 174th second, Dancer flies for another 11 seconds.

    @Test
    void demoTestMethod_01() {
        Task01 task01 =
                new Task01(Arrays.asList("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."));

        int result = task01.getDistanceAfterDuration(1, 14, 10, 127);

        assertEquals(14, result);
    }

    @Test
    void demoTestMethod_02() {
        Task01 task01 =
                new Task01(Arrays.asList("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."));

        int result = task01.getDistanceAfterDuration(10, 14, 10, 127);

        assertEquals(140, result);
    }

    @Test
    void demoTestMethod_03() {
        Task01 task01 =
                new Task01(Arrays.asList("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."));

        int result = task01.getDistanceAfterDuration(11, 14, 10, 127);

        assertEquals(140, result);
    }

    @Test
    void demoTestMethod_04() {
        Task01 task01 =
                new Task01(Arrays.asList("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."));

        int result = task01.getDistanceAfterDuration(137, 14, 10, 127);

        assertEquals(140, result);
    }

    @Test
    void demoTestMethod_05() {
        Task01 task01 =
                new Task01(Arrays.asList("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."));

        int result = task01.getDistanceAfterDuration(138, 14, 10, 127);

        assertEquals(154, result);
    }

    @Test
    void demoTestMethod_06() {
        Task01 task01 =
                new Task01(Arrays.asList("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."));

        int result = task01.getDistanceAfterDuration(138, 14, 10, 127);

        assertEquals(154, result);
    }

    @Test
    void demoTestMethod_07() {
        Task01 task01 =
                new Task01(Arrays.asList("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."));

        int result = task01.getDistanceAfterDuration(1000, 14, 10, 127);

        assertEquals(1120, result);
    }

    @Test
    void demoTestMethod_08() {
        Task01 task01 =
                new Task01(Arrays.asList("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds."));

        int result = task01.getDistanceAfterDuration(1000, 16, 11, 162);

        assertEquals(1056, result);
    }

    @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_14/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(2655, result);
    }
}

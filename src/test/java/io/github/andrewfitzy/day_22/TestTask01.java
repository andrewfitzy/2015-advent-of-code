/* (C)2024 */
package io.github.andrewfitzy.day_22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList("Hit Points: 13", "Damage: 8"));

        int result = task01.solve(10, 250);

        assertEquals(226, result);
    }

    @Test
    void demoTestMethod_02() {
        Task01 task01 = new Task01(Arrays.asList("Hit Points: 14", "Damage: 8"));

        int result = task01.solve(10, 250);

        assertEquals(641, result);
    }

    // @Test // after enabling, this may take a few attempts to pass as it's using randoms
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_22/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve(50, 500);

        assertEquals(1269, result);
    }
}

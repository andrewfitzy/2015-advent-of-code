/* (C)2023 */
package io.github.andrewfitzy.day_17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList("20", "15", "10", "5", "5"));

        int result = task01.solve(25);

        assertEquals(4, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_17/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve(150);

        assertEquals(1638, result);
    }
}

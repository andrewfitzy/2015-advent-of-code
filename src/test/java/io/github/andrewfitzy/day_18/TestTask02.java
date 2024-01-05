/* (C)2023 */
package io.github.andrewfitzy.day_18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList("##.#.#", "...##.", "#....#", "..#...", "#.#..#", "####.#"));

        int result = task02.solve(5);

        assertEquals(17, result);
    }

    @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_18/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        int result = task02.solve(100);

        assertEquals(781, result);
    }
}

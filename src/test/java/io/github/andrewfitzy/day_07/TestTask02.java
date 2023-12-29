/* (C)2023 */
package io.github.andrewfitzy.day_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList(
                "123 -> x",
                "456 -> y",
                "x AND y -> d",
                "x OR y -> e",
                "x LSHIFT 2 -> f",
                "y RSHIFT 2 -> g",
                "NOT x -> h",
                "NOT y -> i",
                "1 AND d -> j"));

        int result = task01.solve("h");

        assertEquals(65412, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_07/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        int result = task02.solve("a");

        assertEquals(40149, result);
    }
}

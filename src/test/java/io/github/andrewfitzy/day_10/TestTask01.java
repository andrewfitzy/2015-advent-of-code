/* (C)2023 */
package io.github.andrewfitzy.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList(""));

        String result = task01.processInput("1");

        assertEquals("11", result);
    }

    @Test
    void demoTestMethod_02() {
        Task01 task01 = new Task01(Arrays.asList(""));

        String result = task01.processInput("11");

        assertEquals("21", result);
    }

    @Test
    void demoTestMethod_03() {
        Task01 task01 = new Task01(Arrays.asList(""));

        String result = task01.processInput("21");

        assertEquals("1211", result);
    }

    @Test
    void demoTestMethod_04() {
        Task01 task01 = new Task01(Arrays.asList(""));

        String result = task01.processInput("1211");

        assertEquals("111221", result);
    }

    @Test
    void demoTestMethod_05() {
        Task01 task01 = new Task01(Arrays.asList(""));

        String result = task01.processInput("111221");

        assertEquals("312211", result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_10/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(329356, result);
    }
}

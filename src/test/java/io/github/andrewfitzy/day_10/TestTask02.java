/* (C)2023 */
package io.github.andrewfitzy.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList(""));

        String result = task02.processInput("1");

        assertEquals("11", result);
    }

    @Test
    void demoTestMethod_02() {
        Task02 task02 = new Task02(Arrays.asList(""));

        String result = task02.processInput("11");

        assertEquals("21", result);
    }

    @Test
    void demoTestMethod_03() {
        Task02 task02 = new Task02(Arrays.asList(""));

        String result = task02.processInput("21");

        assertEquals("1211", result);
    }

    @Test
    void demoTestMethod_04() {
        Task02 task02 = new Task02(Arrays.asList(""));

        String result = task02.processInput("1211");

        assertEquals("111221", result);
    }

    @Test
    void demoTestMethod_05() {
        Task02 task02 = new Task02(Arrays.asList(""));

        String result = task02.processInput("111221");

        assertEquals("312211", result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_10/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        int result = task02.solve();

        assertEquals(4666278, result);
    }
}

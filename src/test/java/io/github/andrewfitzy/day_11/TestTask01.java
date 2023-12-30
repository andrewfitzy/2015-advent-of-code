/* (C)2023 */
package io.github.andrewfitzy.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList("abcdefgh"));

        String result = task01.solve();

        assertEquals("abcdffaa", result);
    }

    @Test
    void demoTestMethod_02() {
        Task01 task01 = new Task01(Arrays.asList("ghijklmn"));

        String result = task01.solve();

        assertEquals("ghjaabcc", result);
    }

    @Test
    void demoTestMethod_03() {
        Task01 task01 = new Task01(Arrays.asList("aabcdyyz"));

        String result = task01.solve();

        assertEquals("aabcdyzz", result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_11/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        String result = task01.solve();

        assertEquals("vzbxxyzz", result);
    }
}

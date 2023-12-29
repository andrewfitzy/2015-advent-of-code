/* (C)2022 */
package io.github.andrewfitzy.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList("ugknbfddgicrmopn"));

        int result = task01.solve();

        assertEquals(1, result);
    }

    @Test
    void demoTestMethod_02() {
        Task01 task01 = new Task01(Arrays.asList("aaa"));

        int result = task01.solve();

        assertEquals(1, result);
    }

    @Test
    void demoTestMethod_03() {
        Task01 task01 = new Task01(Arrays.asList("jchzalrnumimnmhp"));

        int result = task01.solve();

        assertEquals(0, result);
    }

    @Test
    void demoTestMethod_04() {
        Task01 task01 = new Task01(Arrays.asList("haegwjzuvuyypxyu"));

        int result = task01.solve();

        assertEquals(0, result);
    }

    @Test
    void demoTestMethod_05() {
        Task01 task01 = new Task01(Arrays.asList("dvszwmarrgswjxmb"));

        int result = task01.solve();

        assertEquals(0, result);
    }

    //@Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_05/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(236, result);
    }
}

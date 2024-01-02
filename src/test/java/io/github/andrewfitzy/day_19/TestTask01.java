/* (C)2023 */
package io.github.andrewfitzy.day_19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList("H => HO", "H => OH", "O => HH", "", "HOH"));

        int result = task01.solve();

        assertEquals(4, result);
    }

    @Test
    void demoTestMethod_02() {
        Task01 task01 = new Task01(Arrays.asList("H => HO", "H => OH", "O => HH", "", "HOHOHO"));

        int result = task01.solve();

        assertEquals(7, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_19/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(509, result);
    }
}

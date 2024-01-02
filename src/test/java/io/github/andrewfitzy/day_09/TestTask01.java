/* (C)2023 */
package io.github.andrewfitzy.day_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(
                Arrays.asList("London to Dublin = 464", "London to Belfast = 518", "Dublin to Belfast = 141"));

        int result = task01.solve();

        assertEquals(605, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_09/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(141, result);
    }
}

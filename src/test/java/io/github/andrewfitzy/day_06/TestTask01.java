/* (C)2023 */
package io.github.andrewfitzy.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {

        Task01 task01 = new Task01(Arrays.asList(
                "turn on 0,0 through 999,999", "toggle 0,0 through 999,0", "turn off 499,499 through 500,500"));

        int result = task01.solve();

        assertEquals(998996, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_06/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(543903, result);
    }
}

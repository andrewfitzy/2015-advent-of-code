/* (C)2023 */
package io.github.andrewfitzy.day_15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList(
                "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8",
                "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3"));

        int result = task01.solve();

        assertEquals(62842880, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_15/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(18965440, result);
    }
}

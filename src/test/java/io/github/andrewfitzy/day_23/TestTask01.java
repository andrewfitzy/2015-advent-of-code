/* (C)2023 */
package io.github.andrewfitzy.day_23;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList("inc a", "jio a, +2", "tpl a", "inc a"));

        Map<String, Integer> result = task01.solve();

        assertEquals(1, result.size());
        assertEquals(2, result.get("a"));
        assertNull(result.get("b"));
    }

    //     @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_23/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        Map<String, Integer> result = task01.solve();

        assertEquals(2, result.size());
        assertEquals(1, result.get("a"));
        assertEquals(255, result.get("b"));
    }
}

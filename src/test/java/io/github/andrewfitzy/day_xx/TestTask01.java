/* (C)2022 */
package io.github.andrewfitzy.day_xx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList(""));

        int result = task01.solve();

        assertEquals(0, result);
    }

    @Test
    void demoTestMethod_02() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_xx/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(0, result);
    }
}

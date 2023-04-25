/* (C)2022 */
package io.github.andrewfitzy.day_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        io.github.andrewfitzy.day_02.Task01 task01 = new io.github.andrewfitzy.day_02.Task01("2x3x4");

        int result = task01.solve();

        assertEquals(58, result);
    }

    @Test
    void demoTestMethod_02() {
        io.github.andrewfitzy.day_02.Task01 task01 = new io.github.andrewfitzy.day_02.Task01("1x1x10");

        int result = task01.solve();

        assertEquals(43, result);
    }

    @Test
    void demoTestMethod_03() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_02/task01_input.txt");

        int total = 0;
        for (String dimensions : fileContent) {
            io.github.andrewfitzy.day_02.Task01 task01 = new Task01(dimensions);
            int result = task01.solve();
            total = total + result;
        }

        assertEquals(1586300, total);
    }
}

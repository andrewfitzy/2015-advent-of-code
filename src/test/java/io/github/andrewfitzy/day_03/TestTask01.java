/* (C)2022 */
package io.github.andrewfitzy.day_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(">");

        int result = task01.solve();

        assertEquals(2, result);
    }

    @Test
    void demoTestMethod_02() {
        Task01 task01 = new Task01("^>v<");

        int result = task01.solve();

        assertEquals(4, result);
    }

    @Test
    void demoTestMethod_03() {
        Task01 task01 = new Task01("^v^v^v^v^v");

        int result = task01.solve();

        assertEquals(2, result);
    }

    @Test
    void demoTestMethod_04() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_03/task01_input.txt");

        int total = 0;
        for (String dimensions : fileContent) {
            Task01 task01 = new Task01(dimensions);
            int result = task01.solve();
            total = total + result;
        }

        assertEquals(2081, total);
    }
}

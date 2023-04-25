/* (C)2022 */
package io.github.andrewfitzy.day_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02("2x3x4");

        int result = task02.solve();

        assertEquals(34, result);
    }

    @Test
    void demoTestMethod_02() {
        Task02 task02 = new Task02("1x1x10");

        int result = task02.solve();

        assertEquals(14, result);
    }

    @Test
    void demoTestMethod_03() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_02/task01_input.txt");

        int total = 0;
        for (String dimensions : fileContent) {
            Task02 task02 = new Task02(dimensions);
            int result = task02.solve();
            total = total + result;
        }

        assertEquals(3737498, total);
    }
}

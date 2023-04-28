/* (C)2022 */
package io.github.andrewfitzy.day_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02("^v");

        int result = task02.solve();

        assertEquals(3, result);
    }

    @Test
    void demoTestMethod_02() {
        Task02 task02 = new Task02("^>v<");

        int result = task02.solve();

        assertEquals(3, result);
    }

    @Test
    void demoTestMethod_03() {
        Task02 task02 = new Task02("^v^v^v^v^v");

        int result = task02.solve();

        assertEquals(11, result);
    }

    @Test
    void demoTestMethod_04() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_03/task01_input.txt");

        int total = 0;
        for (String dimensions : fileContent) {
            Task02 task02 = new Task02(dimensions);
            int result = task02.solve();
            total = total + result;
        }

        assertEquals(2341, total);
    }
}

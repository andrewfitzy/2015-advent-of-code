/* (C)2022 */
package io.github.andrewfitzy.day_xx;

import io.github.andrewfitzy.TaskInputReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList(""));

        int result = task02.solve();

        assertEquals(0, result);
    }

    @Test
    void demoTestMethod_02() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_xx/task01_input.txt");

            Task02 task02 = new Task02(fileContent);
            int result = task02.solve();


        assertEquals(0, result);
    }
}

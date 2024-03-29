/* (C)2022 */
package io.github.andrewfitzy.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList(")"));

        int result = task02.solve();

        assertEquals(1, result);
    }

    @Test
    void demoTestMethod_02() {
        Task02 task02 = new Task02(Arrays.asList("()())"));

        int result = task02.solve();

        assertEquals(5, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_01/task01_input.txt");
        Task02 task02 = new Task02(fileContent);

        int result = task02.solve();

        assertEquals(1797, result);
    }
}

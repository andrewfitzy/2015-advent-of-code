/* (C)2023 */
package io.github.andrewfitzy.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList("turn on 0,0 through 0,0"));

        int result = task02.solve();

        assertEquals(1, result);
    }

    @Test
    void demoTestMethod_02() {
        Task02 task02 = new Task02(Arrays.asList("toggle 0,0 through 999,999"));

        int result = task02.solve();

        assertEquals(2000000, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_06/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        int result = task02.solve();

        assertEquals(14687245, result);
    }
}

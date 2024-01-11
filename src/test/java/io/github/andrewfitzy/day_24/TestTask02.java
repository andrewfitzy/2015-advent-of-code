/* (C)2023 */
package io.github.andrewfitzy.day_24;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList("1", "2", "3", "4", "5", "7", "8", "9", "10", "11"));

        long result = task02.solve();

        assertEquals(44L, result);
    }

    //    @Test // this will take about 1 minute to run
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_24/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        long result = task02.solve();

        assertEquals(74850409L, result);
    }
}

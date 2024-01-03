/* (C)2023 */
package io.github.andrewfitzy.day_19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList("e => H", "e => O", "H => HO", "H => OH", "O => HH", "", "HOH"));

        int result = task02.solve();

        assertEquals(3, result);
    }

    @Test
    void demoTestMethod_02() {
        Task02 task02 = new Task02(Arrays.asList("e => H", "e => O", "H => HO", "H => OH", "O => HH", "", "HOHOHO"));

        int result = task02.solve();

        assertEquals(6, result);
    }

    @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_19/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        int result = task02.solve();

        assertEquals(195, result);
    }
}

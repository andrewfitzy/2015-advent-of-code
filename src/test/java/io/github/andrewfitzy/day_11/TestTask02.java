/* (C)2023 */
package io.github.andrewfitzy.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList("abcdefgh"));

        String result = task02.solve();

        assertEquals("abcdffbb", result);
    }

    @Test
    void demoTestMethod_02() {
        Task02 task02 = new Task02(Arrays.asList("ghijklmn"));

        String result = task02.solve();

        assertEquals("ghjbbcdd", result);
    }

    @Test
    void demoTestMethod_03() {
        Task02 task02 = new Task02(Arrays.asList("aabcdyyz"));

        String result = task02.solve();

        assertEquals("aabcdzbb", result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_11/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        String result = task02.solve();

        assertEquals("vzcaabcc", result);
    }
}

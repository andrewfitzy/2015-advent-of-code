/* (C)2023 */
package io.github.andrewfitzy.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {
    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList("[1,2,3]"));

        int result = task02.solve();

        assertEquals(6, result);
    }

    @Test
    void demoTestMethod_02() {
        Task02 task02 = new Task02(Arrays.asList("[1,{\"c\":\"red\",\"b\":2},3]"));

        int result = task02.solve();

        assertEquals(4, result);
    }

    @Test
    void demoTestMethod_03() {
        Task02 task02 = new Task02(Arrays.asList("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"));

        int result = task02.solve();

        assertEquals(0, result);
    }

    @Test
    void demoTestMethod_04() {
        Task02 task02 = new Task02(Arrays.asList("[1,\"red\",5]"));

        int result = task02.solve();

        assertEquals(6, result);
    }

    @Test
    void demoTestMethod_05() {
        Task02 task02 = new Task02(Arrays.asList("[1,{\"c\":\"blue\",\"a\":{\"ac\":\"red\",\"ab\":2},\"b\":2},3]"));

        int result = task02.solve();

        assertEquals(6, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_12/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        int result = task02.solve();

        assertEquals(87842, result);
    }
}

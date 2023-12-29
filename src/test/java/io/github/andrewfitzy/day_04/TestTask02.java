/* (C)2022 */
package io.github.andrewfitzy.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() throws NoSuchAlgorithmException {
        Task02 task02 = new Task02(Arrays.asList("abcdef"));

        int result = task02.solve();

        assertEquals(6742839, result);
    }

    @Test
    void demoTestMethod_02() throws NoSuchAlgorithmException {
        Task02 task02 = new Task02(Arrays.asList("pqrstuv"));

        int result = task02.solve();

        assertEquals(5714438, result);
    }

    // @Test
    void testSolveWithRealData() throws NoSuchAlgorithmException {
        List<String> fileContent = TaskInputReader.getFileContent("./day_04/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        int result = task02.solve();

        assertEquals(3938038, result);
    }
}

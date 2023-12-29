/* (C)2022 */
package io.github.andrewfitzy.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() throws NoSuchAlgorithmException {
        Task01 task01 = new Task01(Arrays.asList("abcdef"));

        int result = task01.solve();

        assertEquals(609043, result);
    }

    @Test
    void demoTestMethod_02() throws NoSuchAlgorithmException {
        Task01 task01 = new Task01(Arrays.asList("pqrstuv"));

        int result = task01.solve();

        assertEquals(1048970, result);
    }

    //@Test
    void testSolveWithRealData() throws NoSuchAlgorithmException {
        List<String> fileContent = TaskInputReader.getFileContent("./day_04/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(117946, result);
    }
}

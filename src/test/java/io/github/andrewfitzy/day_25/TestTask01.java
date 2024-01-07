/* (C)2023 */
package io.github.andrewfitzy.day_25;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01(Arrays.asList(
                "To continue, please consult the code grid in the manual.  Enter the code at row 1, column 1."));

        BigInteger result = task01.solve();

        assertEquals(BigInteger.valueOf(20151125), result);
    }

    @Test
    void demoTestMethod_02() {
        Task01 task01 = new Task01(Arrays.asList(
                "To continue, please consult the code grid in the manual.  Enter the code at row 3 column 2."));

        BigInteger result = task01.solve();

        assertEquals(BigInteger.valueOf(8057251), result);
    }

    @Test
    void demoTestMethod_03() {
        Task01 task01 = new Task01(Arrays.asList(
                "To continue, please consult the code grid in the manual.  Enter the code at row 5 column 5."));

        BigInteger result = task01.solve();

        assertEquals(BigInteger.valueOf(9250759), result);
    }

    @Test
    void demoTestMethod_04() {
        Task01 task01 = new Task01(Arrays.asList(
                "To continue, please consult the code grid in the manual.  Enter the code at row 5 column 6."));

        BigInteger result = task01.solve();

        assertEquals(BigInteger.valueOf(31663883), result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_25/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        BigInteger result = task01.solve();

        assertEquals(BigInteger.valueOf(19980801), result);
    }
}

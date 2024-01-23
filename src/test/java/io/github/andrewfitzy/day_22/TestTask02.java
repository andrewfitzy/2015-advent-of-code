/* (C)2023 */
package io.github.andrewfitzy.day_22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void demoTestMethod_01() {
        Task02 task02 = new Task02(Arrays.asList("Hit Points: 13", "Damage: 8"));

        int result = task02.solve(10, 250);

        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    void demoTestMethod_02() {
        Task02 task02 = new Task02(Arrays.asList("Hit Points: 14", "Damage: 8"));

        int result = task02.solve(10, 250);

        assertEquals(Integer.MAX_VALUE, result);
    }

    // @Test // after enabling, this may take a few attempts to pass as it's using randoms
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_22/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        int result = task02.solve(50, 500);

        assertEquals(1309, result);
    }
}

/* (C)2022 */
package io.github.andrewfitzy.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        Task01 task01 = new Task01("(())");

        int result = task01.solve();

        assertEquals(0, result);
    }

    @Test
    void demoTestMethod_02() {
        Task01 task01 = new Task01("()()");

        int result = task01.solve();

        assertEquals(0, result);
    }

    @Test
    void demoTestMethod_03() {
        Task01 task01 = new Task01("(((");

        int result = task01.solve();

        assertEquals(3, result);
    }

    @Test
    void demoTestMethod_04() {
        Task01 task01 = new Task01("(()(()(");

        int result = task01.solve();

        assertEquals(3, result);
    }

    @Test
    void demoTestMethod_05() {
        Task01 task01 = new Task01("))(((((");

        int result = task01.solve();

        assertEquals(3, result);
    }

    @Test
    void demoTestMethod_06() {
        Task01 task01 = new Task01("())");

        int result = task01.solve();

        assertEquals(-1, result);
    }

    @Test
    void demoTestMethod_07() {
        Task01 task01 = new Task01("))(");

        int result = task01.solve();

        assertEquals(-1, result);
    }

    @Test
    void demoTestMethod_08() {
        Task01 task01 = new Task01(")))");

        int result = task01.solve();

        assertEquals(-3, result);
    }

    @Test
    void demoTestMethod_09() {
        Task01 task01 = new Task01(")())())");

        int result = task01.solve();

        assertEquals(-3, result);
    }

    @Test
    void demoTestMethod_10() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_01/task01_input.txt");
        Task01 task01 = new Task01(fileContent.get(0));

        int result = task01.solve();

        assertEquals(280, result);
    }
}

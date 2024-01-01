/* (C)2023 */
package io.github.andrewfitzy.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void demoTestMethod_01() {
        List<String> criteria = Arrays.asList(
                "children: 3",
                "cats: 7",
                "samoyeds: 2",
                "pomeranians: 3",
                "akitas: 0",
                "vizslas: 0",
                "goldfish: 5",
                "trees: 3",
                "cars: 2",
                "perfumes: 1");

        List<String> fileContent = Arrays.asList(
                "Sue 1: goldfish: 5, cars: 0, samoyeds: 2",
                "Sue 2: perfumes: 1, trees: 3, goldfish: 5",
                "Sue 3: pomeranians: 2, akitas: 1, trees: 5",
                "Sue 4: goldfish: 10, akitas: 2, perfumes: 9",
                "Sue 5: cars: 5, perfumes: 6, akitas: 9");

        Task01 task01 = new Task01(criteria, fileContent);

        int result = task01.solve();

        assertEquals(2, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_16/task01_input.txt");

        List<String> criteria = Arrays.asList(
                "children: 3",
                "cats: 7",
                "samoyeds: 2",
                "pomeranians: 3",
                "akitas: 0",
                "vizslas: 0",
                "goldfish: 5",
                "trees: 3",
                "cars: 2",
                "perfumes: 1");

        Task01 task01 = new Task01(criteria, fileContent);
        int result = task01.solve();

        assertEquals(40, result);
    }
}

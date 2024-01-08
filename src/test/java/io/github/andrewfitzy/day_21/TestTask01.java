/* (C)2023 */
package io.github.andrewfitzy.day_21;

import static io.github.andrewfitzy.day_21.Task01.PLAYER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask01 {

    @Test
    void testGetChampion() {

        Task01 task01 = new Task01(Arrays.asList(""));

        Task01.Player player = new Task01.Player(8, 5, 5);
        Task01.Player boss = new Task01.Player(12, 7, 2);

        String result = task01.getChampion(player, boss);

        assertEquals(PLAYER, result);
    }

    @Test
    void demoTestMethod_01() {

        Task01 task01 = new Task01(Arrays.asList("Hit Points: 12", "Damage: 7", "Armor: 2"));

        int result = task01.solve();

        assertEquals(8, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_21/task01_input.txt");

        Task01 task01 = new Task01(fileContent);
        int result = task01.solve();

        assertEquals(121, result);
    }
}

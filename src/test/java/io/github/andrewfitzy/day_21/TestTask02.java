/* (C)2023 */
package io.github.andrewfitzy.day_21;

import static io.github.andrewfitzy.day_21.Task02.PLAYER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.andrewfitzy.TaskInputReader;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestTask02 {

    @Test
    void testGetChampion() {

        Task02 task02 = new Task02(Arrays.asList(""));

        Task02.Player player = new Task02.Player(8, 5, 5);
        Task02.Player boss = new Task02.Player(12, 7, 2);

        String result = task02.getChampion(player, boss);

        assertEquals(PLAYER, result);
    }

    @Test
    void demoTestMethod_01() {

        Task02 task02 = new Task02(Arrays.asList("Hit Points: 100", "Damage: 100", "Armor: 100"));

        int result = task02.solve();

        assertEquals(356, result);
    }

    // @Test
    void testSolveWithRealData() {
        List<String> fileContent = TaskInputReader.getFileContent("./day_21/task01_input.txt");

        Task02 task02 = new Task02(fileContent);
        int result = task02.solve();

        assertEquals(201, result);
    }
}

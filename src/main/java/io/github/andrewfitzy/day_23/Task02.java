/* (C)2023 */
package io.github.andrewfitzy.day_23;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public Map<String, Integer> solve() {
        Map<String, Integer> registers = new HashMap();
        registers.put("a", 1);
        int index = 0;
        while (index != fileContent.size()) {
            String[] parts = fileContent.get(index).split(" ");
            if (parts[0].equals("hlf")) {
                int tmpRegister = registers.getOrDefault(parts[1], 0);
                tmpRegister = tmpRegister / 2;
                registers.put(parts[1], tmpRegister);
                index++;
            }
            if (parts[0].equals("inc")) {
                int tmpRegister = registers.getOrDefault(parts[1], 0);
                tmpRegister = tmpRegister + 1;
                registers.put(parts[1], tmpRegister);
                index++;
            }
            if (parts[0].equals("tpl")) {
                int tmpRegister = registers.getOrDefault(parts[1], 0);
                tmpRegister = tmpRegister * 3;
                registers.put(parts[1], tmpRegister);
                index++;
            }
            if (parts[0].equals("jmp")) {
                int step = Integer.parseInt(parts[1]);
                index = index + step;
            }
            if (parts[0].equals("jio")) {
                int tmpRegister = registers.getOrDefault(parts[1].replace(",", ""), 0);
                if (tmpRegister == 1) {
                    int step = Integer.parseInt(parts[2]);
                    index = index + step;
                } else {
                    index = index + 1;
                }
            }
            if (parts[0].equals("jie")) {
                int tmpRegister = registers.getOrDefault(parts[1].replace(",", ""), 0);
                if (tmpRegister % 2 == 0) {
                    int step = Integer.parseInt(parts[2]);
                    index = index + step;
                } else {
                    index = index + 1;
                }
            }
        }
        return registers;
    }
}

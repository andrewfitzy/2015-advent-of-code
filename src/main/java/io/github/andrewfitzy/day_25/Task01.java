/* (C)2023 */
package io.github.andrewfitzy.day_25;

import java.math.BigInteger;
import java.util.List;

public final class Task01 {

    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public BigInteger solve() {
        String sanitizedInput =
                fileContent.get(0).replace(".", "").replaceAll(",", "").replaceAll("[ ]+", " ");
        String[] parts = sanitizedInput.split(" ");

        int targetRow = Integer.parseInt(parts[15]);
        int targetCol = Integer.parseInt(parts[17]);

        int maxLevels = (targetRow > targetCol) ? targetRow * 2 : targetCol * 2;
        BigInteger currentValue = BigInteger.valueOf(20151125);
        boolean found = false;
        for (int level = 0; level < maxLevels; level++) {
            int col = 0;
            for (int tmpRow = level; tmpRow >= 0; tmpRow--, col++) {
                if (tmpRow == targetRow - 1 && col == targetCol - 1) {
                    found = true;
                    break;
                }
                BigInteger tmpNum = currentValue.multiply(BigInteger.valueOf(252533));
                currentValue = tmpNum.mod(BigInteger.valueOf(33554393));
            }
            if (found) {
                break;
            }
        }
        return currentValue;
    }
}

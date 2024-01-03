/* (C)2023 */
package io.github.andrewfitzy.day_19;

import java.util.*;

public final class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        int stepCount = 0;
        String molecule = fileContent.get(fileContent.size() - 1);
        Map<String, String> replacementMap = new HashMap<>();
        List<String> es = new ArrayList<>();
        for (int i = 0; i < fileContent.size() - 2; i++) {
            String[] parts = fileContent.get(i).split(" ");
            if ("e".equals(parts[0])) {
                es.add(parts[2]);
                continue;
            }
            replacementMap.put(parts[2], parts[0]);
        }

        boolean equalsE = false;
        while (!equalsE) {
            for (Map.Entry<String, String> entry : replacementMap.entrySet()) {
                String replacement = entry.getKey();
                StringBuilder criterion = new StringBuilder();
                criterion.append("(").append(replacement).append(")");
                String tmpMolecule = molecule.replaceFirst(criterion.toString(), entry.getValue());
                if (!molecule.equals(tmpMolecule)) {
                    molecule = tmpMolecule;
                    stepCount++;
                }
            }

            if (es.contains(molecule)) {
                equalsE = true;
                stepCount++;
            }
        }
        return stepCount;
    }
}

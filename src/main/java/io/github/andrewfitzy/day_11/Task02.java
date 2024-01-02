/* (C)2023 */
package io.github.andrewfitzy.day_11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public static final int ASCII_LOWER_Z = 122;
    public static final int ASCII_LOWER_A = 97;
    public final Pattern INVALID_CHARACTERS = Pattern.compile("[iol]");

    public String solve() {
        String password = fileContent.get(0);
        password = getNextValidPassword(password);
        password = getNextValidPassword(password);
        return password;
    }

    private String getNextValidPassword(String password) {
        boolean validPassword = false;
        while (!validPassword) {
            password = getNextPassword(password);

            validPassword = true;
            if (passwordContainsInvalidCharacters(password)) {
                validPassword = false;
                continue;
            }
            if (!passwordContainsThreeConsecutiveLetters(password)) {
                validPassword = false;
                continue;
            }
            if (!passwordContainsEnoughPairsOfLetters(password)) {
                validPassword = false;
            }
        }
        return password;
    }

    private String getNextPassword(String password) {
        // need to count like numbers from the left
        StringBuilder passwordBuilder = new StringBuilder(password);
        char[] parts = password.toCharArray();
        int charValue = parts[parts.length - 1];
        charValue++;

        if (charValue > ASCII_LOWER_Z) {
            charValue = ASCII_LOWER_A;
            passwordBuilder.setCharAt(parts.length - 1, (char) charValue);
            for (int i = parts.length - 2; i >= 0; i--) {
                char tmpChar = parts[i];
                if (tmpChar > ASCII_LOWER_Z) {
                    tmpChar = ASCII_LOWER_A;
                    passwordBuilder.setCharAt(i, tmpChar);
                    continue;
                }
                tmpChar++;
                passwordBuilder.setCharAt(i, tmpChar);
                break;
            }
        } else {
            passwordBuilder.setCharAt(parts.length - 1, (char) charValue);
        }
        return passwordBuilder.toString();
    }

    private boolean passwordContainsEnoughPairsOfLetters(String password) {
        Map<String, Integer> pairsMap = new HashMap<>();
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i - 1) == password.charAt(i)) {
                StringBuilder builder = new StringBuilder();
                builder.append(password.charAt(i - 1)).append(password.charAt(i));
                int count = pairsMap.getOrDefault(builder.toString(), 0);
                count++;
                pairsMap.put(builder.toString(), count);
            }
        }
        return pairsMap.size() >= 2;
    }

    private boolean passwordContainsInvalidCharacters(String password) {
        Matcher matcher = INVALID_CHARACTERS.matcher(password);
        return matcher.find();
    }

    private boolean passwordContainsThreeConsecutiveLetters(String password) {
        char[] parts = password.toCharArray();
        for (int i = 2; i < parts.length; i++) {
            int iPartAsInt = (int) parts[i];
            int iMinusOnePartAsInt = (int) parts[i - 1];
            int iMinusTwoPartAsInt = (int) parts[i - 2];
            if (iPartAsInt == iMinusOnePartAsInt + 1 && iMinusOnePartAsInt == iMinusTwoPartAsInt + 1) {
                return true;
            }
        }
        return false;
    }
}

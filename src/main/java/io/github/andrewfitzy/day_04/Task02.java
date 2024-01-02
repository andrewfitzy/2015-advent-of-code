/* (C)2022 */
package io.github.andrewfitzy.day_04;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public final class Task02 {

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() throws NoSuchAlgorithmException {
        int result = 0;
        MessageDigest md = MessageDigest.getInstance("MD5");
        for (int i = 0; i < 10000000; i++) {

            String test = fileContent.get(0) + String.format("%04d", i);
            md.update(test.getBytes(Charset.defaultCharset()));
            byte[] digest = md.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                stringBuilder.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            boolean startsWith0s = Boolean.TRUE;
            for (int j = 0; j < 6; j++) {
                if (!Character.valueOf(stringBuilder.charAt(j)).equals('0')) {
                    startsWith0s = Boolean.FALSE;
                    break;
                }
            }
            if (startsWith0s) {
                result = i;
                break;
            }
        }
        return result;
    }
}

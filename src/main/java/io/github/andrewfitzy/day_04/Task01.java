/* (C)2022 */
package io.github.andrewfitzy.day_04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Task01 {
    final Logger logger = LoggerFactory.getLogger(Task01.class);
    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent;
    }

    public int solve() throws NoSuchAlgorithmException {
        int result = 0;
        MessageDigest md = MessageDigest.getInstance("MD5");
        for(int i = 0;i < 5000000;i++) {

            String test = fileContent.get(0) + String.format("%04d", i);md.update(test.getBytes());
            byte[] digest = md.digest();

            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < digest.length; j++) {
                stringBuffer.append(Integer.toString((digest[j] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            boolean startsWith0s = Boolean.TRUE;
            for (int j = 0; j < 5; j++) {
                if(!Character.valueOf(stringBuffer.charAt(j)).equals('0')) {
                    startsWith0s = Boolean.FALSE;
                    break;
                }
            }
           if(startsWith0s) {
               result = i;
               break;
           }

        }
        return result;
    }
}

package com.sysio.ecommerce.libs;

import java.util.Random;

/**
 *
 * @author Carlos Cesar Rosas
 */
public class RandomName {

    /**
     *
     * @param extension
     * @return
     */
    public static String randomIdentifier(String extension) {
        String lexicon = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = /*rand.nextInt(40) +*/ 70;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
        }
        builder.append(".").append(extension.split("/")[1]);
        return builder.toString();
    }
}
package com.tinyurl.tinyurl.tinyurl.util;

import org.springframework.util.Base64Utils;

import java.math.BigInteger;
import java.util.Base64;

public class UrlShortnerEncoding {
    static Base62 base62 = Base62.createInstance();

    public static String encodeBase62(BigInteger bigInteger) {
//        String possibleChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuffer shorturl = new StringBuffer();
//        BigInteger sixtyTwo = new BigInteger("62");
//        for (int i = 0; i < str.length(); i++)
//                shorturl.append(possibleChars[bigInteger.mod(sixtyTwo)]);
//
//        }
//        return Base64Utils.encodeToString(bigInteger.toString().getBytes());

        String shortURL = new String(base62.encode(bigInteger.toString().getBytes()));
        String newResult = shortURL;
        for (int i = 0; i < 8 - shortURL.length(); i++) {
            newResult += "a";
        }
        return newResult;

//        return new String(base62.encode(bigInteger.toString().getBytes()));
    }
}

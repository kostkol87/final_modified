package edu.flight_discounter.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashUtility {
    private static String convertToHex(final byte[] data) {
        final StringBuilder sb = new StringBuilder();

        for (final byte aData : data) {
            int halfByte = (aData >>> 4) & 0x0F;
            int twoParts = 0;
            do {
                if ((0 <= halfByte) && (halfByte <= 9))
                    sb.append((char) ('0' + halfByte));
                else
                    sb.append((char) ('a' + (halfByte - 10)));
                halfByte = aData & 0x0F;
            } while (twoParts++ < 1);
        }

        return sb.toString();
    }

    private static String getHash(final String text, final String algorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(text.getBytes("UTF-8"), 0, text.length());
        return convertToHex(md.digest());
    }

    public static String SHA1(final String string) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return getHash(string, "SHA-1");
    }

    public static String MD5(final String string) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return getHash(string, "MD5");
    }
}
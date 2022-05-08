package com.csp.java.jdk17.pattern;

/**
 * @author chensiping
 * @since 2022-05-01
 */
public class PatternSample {

    public static void main(String[] args) {

        String s = "like";

        // long result = lengthOldVersion(s);

        long result = lengthSample1(s);

        System.out.println(result);
    }

    private static long lengthOldVersion(Object obj) {

        if (obj instanceof String) {
            String s = (String) obj; // 强制转换
            return s.length();
        }

        return -1;
    }

    private static long lengthSample1(Object obj) {

        if (obj instanceof String s) {
            // s in scope
            return s.length();
        }

        // s not in scope
        return -1;
    }

    private static long lengthSample2(Object obj) {

        if (!(obj instanceof String s)) {
            // s not in scope
            return -1;
        }

        // s in scope
        return s.length();
    }
}

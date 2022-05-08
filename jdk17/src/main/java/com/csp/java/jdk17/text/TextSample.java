package com.csp.java.jdk17.text;

/**
 * @author chensiping
 * @since 2022-05-05
 */
public class TextSample {

    public static void main(String[] args) {

        String content = """
                {
                    "id": 1,\
                    "name": "mike",
                    "createdTime": "2011-08-05\s10:50:09",
                }
                 """;
        System.out.println(content);
    }
}

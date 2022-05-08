package com.csp.java.jdk17.var;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author chensiping
 * @since 2022-05-08
 */
public class VarSample {

    public static void main(String[] args) {

        var string = "hello java 10";
        var stream = Stream.of(1, 2, 3, 4);
        var list = List.of("a", "b", "c", "d");

        var hashMap = Map.of("key1", 1, "key2", 2);
        hashMap.forEach((var k, var v) -> {
            System.out.println(k + ": " + v);
        });
    }

    private void varSample() {

        // old
        IamALongAndUglyClassName instanceA1 = new IamALongAndUglyClassName();
        IamALongAndUglyClassNameToo instanceB1 = new IamALongAndUglyClassNameToo();

        // new
        var instanceA2 = new IamALongAndUglyClassName();
        var instanceB2 = new IamALongAndUglyClassNameToo();
    }

    static class IamALongAndUglyClassName {
    }

    static class IamALongAndUglyClassNameToo {
    }
}

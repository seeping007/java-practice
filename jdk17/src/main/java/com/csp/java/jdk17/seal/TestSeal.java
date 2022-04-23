package com.csp.java.jdk17.seal;

/**
 * @author chensiping
 * @since 2022-04-23
 */
public class TestSeal {

    public static void main(String[] args) {

        TestSeal testSeal = new TestSeal();

        Husky husky = new Husky();
        System.out.println("husky: " + testSeal.flip(husky));
    }

    private Animal flip(Animal animal) {

        return switch (animal) { // preview feature
            case Cat c -> c;
            case Dog d -> d;
        };
    }
}

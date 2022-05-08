package com.csp.java.jdk17.seal;

/**
 * @author chensiping
 * @since 2022-04-23
 */
public class SealSample {

    public static void main(String[] args) {

        SealSample sealSample = new SealSample();

        Husky husky = new Husky();
//        System.out.println("husky: " + testSeal.flip(husky));
    }

//    private Animal flip(Animal animal) {
//
//        return switch (animal) { // preview feature
//            case Cat c -> c;
//            case Dog d -> d;
//        };
//    }
}

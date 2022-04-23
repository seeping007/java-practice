package com.csp.java.jdk17.seal;

/**
 * @author chensiping
 * @since 2022-04-23
 */
public sealed class Dog implements Animal permits Corgi, Husky {

    @Override
    public String name() {
        return "Dog";
    }

    @Override
    public String type() {
        return "DOG";
    }
}

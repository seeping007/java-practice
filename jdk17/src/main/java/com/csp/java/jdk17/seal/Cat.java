package com.csp.java.jdk17.seal;

/**
 * @author chensiping
 * @since 2022-04-23
 */
public final class Cat implements Animal {

    @Override
    public String name() {
        return "Cat";
    }

    @Override
    public String type() {
        return "CAT";
    }
}

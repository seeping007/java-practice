package com.csp.java.jdk17.seal;

/**
 * @author chensiping
 * @since 2022-04-23
 */
public sealed interface Animal
        permits Dog, Cat {

    String name();

    String type();
}

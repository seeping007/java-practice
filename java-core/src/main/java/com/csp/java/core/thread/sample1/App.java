package com.csp.java.core.thread.sample1;

/**
 * Basic sample: single thread execution
 *
 * @author CSP
 * @since 2018/3/14
 */
public class App {

    public static void main(String[] args) {

        Bridge bridge = new Bridge();
        new UserThread(bridge, "Alex", "America").start();
        new UserThread(bridge, "Bob", "Briton").start();
        new UserThread(bridge, "Chen", "China").start();
    }
}

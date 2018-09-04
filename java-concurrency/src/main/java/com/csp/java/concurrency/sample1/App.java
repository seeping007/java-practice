package com.csp.java.concurrency.sample1;

/**
 * @author CSP
 * @since 2018/3/14
 */
public class App {

    public static void main(String[] args) {
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}

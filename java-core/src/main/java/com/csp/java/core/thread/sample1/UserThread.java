package com.csp.java.core.thread.sample1;

/**
 * @author CSP
 * @since 2018/3/14
 */
public class UserThread extends Thread {

    private final Bridge bridge;

    private final String name;

    private final String address;

    UserThread(Bridge bridge, String name, String address) {
        this.bridge = bridge;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println(name + " begin");
        while (true) {
            bridge.pass(name, address);
        }
    }
}

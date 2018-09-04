package com.csp.java.concurrency.sample1;

/**
 * @author CSP
 * @since 2018/3/14
 */
public class UserThread extends Thread {

    private final Gate gate;

    private final String name;

    private final String address;

    UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    public void run() {
        System.out.println(name + " BEGIN");
        while (true) {
            gate.pass(name, address);
        }
    }
}

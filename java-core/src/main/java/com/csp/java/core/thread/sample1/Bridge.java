package com.csp.java.core.thread.sample1;

/**
 * Bridge(shared resource): only one allowed to pass at the same time
 *
 * @author CSP
 * @since 2018/3/14
 */
public class Bridge {

    private int counter = 0;

    private String name = "unknown";

    private String address = "unknown";

    /**
     * synchronized: get lock of this instance,
     * make sure that method would be executed by single thread
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        brokenCheck();
    }

    public synchronized String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    private void brokenCheck() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("****** broken ****** " + toString());
        }
    }
}

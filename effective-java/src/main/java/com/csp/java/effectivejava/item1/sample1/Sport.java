package com.csp.java.effectivejava.item1.sample1;

/**
 * @author CSP
 * @since 2018/9/5
 */
public interface Sport {

    // static factory method of interface
    static Sport newInstance(int type) {
        switch (type) {
            case 0:
                return new Football();
            case 1:
                return new Basketball();
            default:
                return () -> System.out.println("Undefined sport.");
        }
    }

    void info();
}

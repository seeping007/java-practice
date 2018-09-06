package com.csp.java.effectivejava.item1.sample1;

/**
 * @author CSP
 * @since 2018/9/5
 */
public class Swimming implements Sport {

    private static Swimming INSTANCE;

    // reuse instance
    public static Swimming getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Swimming();
        }
        return INSTANCE;
    }

    public static Swimming newInstance() {
        return new Swimming();
    }

    @Override
    public void info() {
        System.out.println("This is swimming.");
    }
}

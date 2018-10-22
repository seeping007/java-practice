package com.csp.java.core.pattern.adapter;

/**
 * @author CSP
 * @since 2018/10/22
 */
public class App {

    public static void main(String[] args) {

        Target adapter = new Adapter(new Adaptee());
        adapter.request();
    }
}

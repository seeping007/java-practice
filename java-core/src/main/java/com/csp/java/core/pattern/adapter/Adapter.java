package com.csp.java.core.pattern.adapter;

/**
 * @author CSP
 * @since 2018/10/22
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        this.adaptee.specificRequest();
    }
}

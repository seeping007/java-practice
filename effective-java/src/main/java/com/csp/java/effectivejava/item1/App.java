package com.csp.java.effectivejava.item1;

/**
 * @author CSP
 * @since 2018/9/5
 */
public class App {

    public static void main(String[] args) {

        Sport swimming1 = Swimming.getInstance();
        swimming1.info();

        Sport swimming2 = Swimming.newInstance();
        swimming2.info();

        Sport football = Sport.newInstance(0);
        football.info();

        Sport basketball = Sport.newInstance(1);
        basketball.info();

        Sport unknown = Sport.newInstance(2);
        unknown.info();
    }
}

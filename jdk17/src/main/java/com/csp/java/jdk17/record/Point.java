package com.csp.java.jdk17.record;

/**
 * @author chensiping
 * @since 2022-05-08
 */
record Point(int x, int y) {

    public String formattedPoint() {
        return String.format("[%d,%d]", x, y);
    }
}

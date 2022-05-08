package com.csp.java.jdk17.record;

import java.util.Objects;

/**
 * @author chensiping
 * @since 2022-05-08
 */
public class PointOld {

    private final int x;
    private final int y;

    PointOld(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

    public String formattedPoint() {
        return String.format("[%d,%d]", x, y);
    }

    public boolean equals(Object o) {
        if (!(o instanceof PointOld)) return false;
        PointOld other = (PointOld) o;
        return other.x == x && other.y == y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString() {
        return String.format("Point[x=%d, y=%d]", x, y);
    }
}

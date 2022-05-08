package com.csp.java.jdk17.record;

/**
 * @author chensiping
 * @since 2022-05-08
 */
public class PointSample {

    public static void main(String[] args) {

        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);

        System.out.printf("point1: x=%d, y=%d, format=%s \n", point1.x(), point1.y(), point1.formattedPoint());
        System.out.printf("point2: x=%d, y=%d, format=%s \n", point2.x(), point2.y(), point2.formattedPoint());

        System.out.println("point1 == point2: " + point1.equals(point2));
    }
}

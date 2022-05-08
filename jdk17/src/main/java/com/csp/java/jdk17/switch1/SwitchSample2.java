package com.csp.java.jdk17.switch1;

import java.util.Calendar;

/**
 * @author chensiping
 * @since 2022-05-05
 */
public class SwitchSample2 {

    public static void main(String[] args) {

        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);

        int daysInMonth = 0;
//        daysInMonth = daysInMonth1(year, month);
        daysInMonth = daysInMonth2(year, month);
//        daysInMonth = daysInMonth3(year, month);

        System.out.println("Days in this month: " + daysInMonth);
    }

    /**
     * before jdk 14
     * 坑点:
     * 1. break: 初衷是解决不同情况下共享代码片段问题，但利大于弊，遗漏或冗余均容易改变代码逻辑，需要反复查验正确性
     * 2. 反复出现的赋值语句 (daysInMonth)
     */
    public static int daysInMonth1(int year, int month) {

        int daysInMonth;
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.MARCH:
            case Calendar.MAY:
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.OCTOBER:
            case Calendar.DECEMBER:
                daysInMonth = 31;
                break; //
            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                daysInMonth = 30;
                break;
            case Calendar.FEBRUARY:
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                throw new RuntimeException("Invalid calendar");
        }

        return daysInMonth;
    }

    /**
     * jdk 14
     * 变化点:
     * 1. switch语句 -> switch表达式 (更明确的语法约束)
     * 2. 多情况合并 (简化代码)
     * 3. 新关键字yield (switch表达式的返回值)
     * 4. 穷举约束 (代码健壮性)
     */
    public static int daysInMonth2(int year, int month) {

        int daysInMonth = switch (month) {
            case Calendar.JANUARY, Calendar.MARCH, Calendar.MAY, Calendar.JULY, Calendar.AUGUST, Calendar.OCTOBER, Calendar.DECEMBER ->
                    31;
            case Calendar.APRIL, Calendar.JUNE, Calendar.SEPTEMBER, Calendar.NOVEMBER -> 30;
            case Calendar.FEBRUARY -> {
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            default -> throw new RuntimeException("Invalid calendar");
        };

        return daysInMonth;
    }

    private static int daysInMonth3(int year, int month) {

        int daysInMonth = 0;
        switch (month) {
            case Calendar.JANUARY, Calendar.MARCH, Calendar.MAY, Calendar.JULY, Calendar.AUGUST, Calendar.OCTOBER, Calendar.DECEMBER ->
                    daysInMonth = 31;
            case Calendar.APRIL, Calendar.JUNE, Calendar.SEPTEMBER, Calendar.NOVEMBER -> daysInMonth = 30;
            case Calendar.FEBRUARY -> {
                if (((year % 4 == 0) && !(year % 100 == 0))
                        || (year % 400 == 0)) {
                    daysInMonth = 29;
                    break; // break the switch statement
                }

                daysInMonth = 28;
            }
            // default -> throw new RuntimeException("Invalid calendar");
        }

        return daysInMonth;
    }
}

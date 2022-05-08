package com.csp.java.jdk17.switch1;

/**
 * @author chensiping
 * @since 2022-05-05
 */
public class SwitchSample1 {

    // before jdk12
    public static void switchMonth1(String month) {

        switch (month) {
            case "March":
            case "April":
            case "May":
                System.out.println("Spring");
                break; //
            case "June":
            case "July":
            case "August":
                System.out.println("Summer");
                break;
            case "September":
            case "October":
            case "November":
                System.out.println("Autumn");
                break;
            case "December":
            case "January":
            case "February":
                System.out.println("Winter");
                break;
        }
    }

    // jdk 12
    public static void switchMonth2(String month) {

        // case L ->
        switch (month) {
            case "March", "April", "May" -> System.out.println("Spring");
            case "June", "July", "August" -> System.out.println("Summer");
            case "September", "October", "November" -> System.out.println("Autumn");
            case "December", "January", "February" -> System.out.println("Winter");
        }
    }

    // jdk 12
    public static void switchMonth3(String month) {

        // 支持使用 switch 的返回值进行赋值
        String season = switch (month) {
            case "March", "April", "May" -> "Spring";
            case "June", "July", "August" -> "Summer";
            case "September", "October", "November" -> "Autumn";
            case "December", "January", "February" -> "Winter";
            default -> "ERROR";
        };

        System.out.println("Current season: " + season);
    }

    // jdk 13
    public static void switchMonth4(String month) {

        // 增加了 yield 关键词用于返回值
        String season = switch (month) {
            case "March", "April", "May":
                yield "Spring";
            case "June", "July", "August":
                yield "Summer";
            case "September", "October", "November":
                yield "Autumn";
            case "December", "January", "February":
                yield "Winter";
            default:
                yield "ERROR";
        };

        System.out.println("Current season: " + season);
    }
}

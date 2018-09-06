package com.csp.java.effectivejava.item2.sample1;

/**
 * @author CSP
 * @since 2018/9/6
 */
public class App {

    public static void main(String[] args) {

        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .fat(1).calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola.toString());
    }
}

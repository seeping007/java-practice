package com.csp.java.effectivejava.item2.sample2;

/**
 * @author CSP
 * @since 2018/9/6
 */
public class App {

    public static void main(String[] args) {

        NyPizza pizza1 = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION)
                .build();
        System.out.println(pizza1.toString());

        NyPizza pizza2 = new NyPizza.Builder(NyPizza.Size.LARGE)
                .addTopping(Pizza.Topping.HAM).addTopping(Pizza.Topping.MUSHROOM).addTopping(Pizza.Topping.PEPPER)
                .build();
        System.out.println(pizza2.toString());

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM).sauceInside()
                .build();
        System.out.println(calzone.toString());
    }
}

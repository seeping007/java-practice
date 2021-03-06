package com.csp.java.effectivejava.item2.sample2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author CSP
 * @since 2018/9/6
 */
public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    /**
     * Builder is a generic type with a recursive type parameter (Item 30).
     *
     * This, along with the abstract self method, allows method chaining to work properly in subclasses,
     * without the need for casts.
     *
     * @param <T>
     */
    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}

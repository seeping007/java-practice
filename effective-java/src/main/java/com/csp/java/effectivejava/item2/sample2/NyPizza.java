package com.csp.java.effectivejava.item2.sample2;

import java.util.Objects;

/**
 * @author CSP
 * @since 2018/9/6
 */
class NyPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this); // return the correct subclass
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                ", toppings=" + toppings +
                '}';
    }
}

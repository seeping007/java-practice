package com.csp.java.jdk17;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author chensiping
 * @since 2022-05-08
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Fork(3)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class PatternBench {

    private static final Animal animal = new Animal.Dog("Corgi");

    public static void main(String[] args) throws RunnerException {

        Options options = new OptionsBuilder()
                .include(PatternBench.class.getSimpleName())
                .forks(3)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    public Animal.Dog useCast() {

        if (animal instanceof Animal.Dog) {
            return (Animal.Dog) animal;
        }

        return null;
    }

    @Benchmark
    public Animal.Dog usePattern() {

        if (animal instanceof Animal.Dog dog) {
            return dog;
        }

        return null;
    }

    sealed interface Animal permits Animal.Dog, Animal.Cat {

        record Dog(String name) implements Animal {
            // blank
        }

        record Cat(String name) implements Animal {
            // blank
        }
    }
}

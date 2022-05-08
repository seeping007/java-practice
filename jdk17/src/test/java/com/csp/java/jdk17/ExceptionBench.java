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
@Fork(1)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class ExceptionBench {

    private static String STR = "Hello, world";  // length == 12

    public static void main(String[] args) throws RunnerException {

        Options options = new OptionsBuilder()
                .include(ExceptionBench.class.getSimpleName())
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(5)
                .build();

        new Runner(options).run();
    }

    /**
     * Benchmark                       Mode  Cnt          Score          Error  Units
     * ExceptionBench.noException     thrpt    5  737619926.123 ± 45724449.240  ops/s
     * ExceptionBench.withException1  thrpt    5     744422.979 ±    82791.211  ops/s
     * ExceptionBench.withException2  thrpt    5      11330.202 ±     4697.797  ops/s
     * <p>
     * 1. 不要滥用异常（使用异常机制处理正常的状况）
     * 2. 多主动判断，少抛异常
     * 3. 调试信息按需开启（堆栈等）
     */

    @Benchmark
    public void noException() {
        try {
            STR.substring(12);
        } catch (RuntimeException e) {
            // ignore the exception
        }
    }

    @Benchmark
    public void withException1() {
        try {
            STR.substring(14);
        } catch (RuntimeException e) {
            // ignore the exception
        }
    }

    @Benchmark
    public void withException2() {
        try {
            STR.substring(14);
        } catch (RuntimeException e) {
            // print stacktrace
            e.printStackTrace();
        }
    }
}

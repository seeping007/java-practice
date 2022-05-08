package com.csp.java.jdk17;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author chensiping
 * @since 2022-05-01
 */
@BenchmarkMode(Mode.Throughput) // 基准测试模式
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Fork(1) // 多个单独的进程测试每个方法
@Warmup(iterations = 3, time = 3) // 预热，JVM对特定代码会存在优化（本地化）
@Measurement(iterations = 5, time = 5) // 执行多少次
public class HelloBench {

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(HelloBench.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void wellHelloThere() {
        // this method was intentionally left blank.
    }
}

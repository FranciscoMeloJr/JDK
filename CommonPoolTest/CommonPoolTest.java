import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.time.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
https://dzone.com/articles/be-aware-of-forkjoinpoolcommonpool
 If you want to override an ergonomic behavior of JDK, you can else specify three system properties:
    java.util.concurrent.ForkJoinPool.common.parallelism - the parallelism level, a non-negative integer
    java.util.concurrent.ForkJoinPool.common.threadFactory - the class name of a ForkJoinPool.ForkJoinWorkerThreadFactory. The system class loader is used to load this class.
    java.util.concurrent.ForkJoinPool.common.exceptionHandler - the class name of a Thread.UncaughtExceptionHandler. The system class loader is used to load this class.
    java.util.concurrent.ForkJoinPool.common.maximumSpares - the maximum number of allowed extra threads to maintain target parallelism (default 256). 
*/

public class CommonPoolTest {

    public static void main(String[] args) {
        System.out.println("CPU Core: " + Runtime.getRuntime().availableProcessors());
        System.out.println("CommonPool Parallelism: " + ForkJoinPool.commonPool().getParallelism());
        System.out.println("CommonPool Common Parallelism: " + ForkJoinPool.getCommonPoolParallelism());

        long start = System.nanoTime();
        /*List<CompletableFuture<Void>> futures = IntStream.range(0, 100)
                .mapToObj(i -> CompletableFuture.runAsync(CommonPoolTest::blockingOperation))
                .collect(Collectors.toUnmodifiableList());

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join(); */
        System.out.println("Processed in " + Duration.ofNanos(System.nanoTime() - start).toSeconds() + " sec");
    }

    private static void blockingOperation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
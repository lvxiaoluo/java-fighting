package org.example.thread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author lvle
 * @date 2021-07-04 10:42
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture.completedFuture("000")
                .thenApply(r -> r)
                .whenComplete((r, e) -> System.out.println(format(r)));
        CompletableFuture
                .supplyAsync(() -> {
                    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
                    return "111";
                })
                .thenApply(r->r)
                .whenComplete((r, e) -> System.out.println(format(r)));

    }
    private static String format(String msg) {
        return String.format("[%s] %s", Thread.currentThread().getName(), msg);
    }


    @Test
    public void test1(){
        CompletableFuture.supplyAsync(() -> {
            // random n millisecond
            int ms = new Random().nextInt(100);
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(ms));
            String msg = String.format("supplyAsync %s ms", ms);
            System.out.println(format(msg));
            return msg;
        }).thenApply(s -> {
            System.out.println(format("thenApply apply s.length()"));
            return s.length();
        }).whenComplete((s, throwable) -> System.out.println(format("done " + s)));
    }
}

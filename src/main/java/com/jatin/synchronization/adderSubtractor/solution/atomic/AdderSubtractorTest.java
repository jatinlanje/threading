package com.jatin.synchronization.adderSubtractor.solution.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AdderSubtractorTest { //dirty read
    public static void main(String[] args) throws InterruptedException {

        Count count = new Count(new AtomicInteger(0));

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder);
        executor.execute(subtractor);

        executor.awaitTermination(1, TimeUnit.MILLISECONDS);
        System.out.println(count.getValue());
    }
}

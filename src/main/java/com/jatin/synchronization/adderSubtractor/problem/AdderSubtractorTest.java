package com.jatin.synchronization.adderSubtractor.problem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AdderSubtractorTest { //dirty read
    public static void main(String[] args) throws InterruptedException {

        Count count = new Count(0);

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder); //race condition
        executor.execute(subtractor); //race condition

        executor.awaitTermination(1, TimeUnit.MILLISECONDS);
        System.out.println(count.getValue());
    }
}

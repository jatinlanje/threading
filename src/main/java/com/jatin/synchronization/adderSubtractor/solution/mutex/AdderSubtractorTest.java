package com.jatin.synchronization.adderSubtractor.solution.mutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdderSubtractorTest {
    public static void main(String[] args) throws InterruptedException {

        Count count = new Count(0);
        Lock lock = new ReentrantLock();

        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder);
        executor.execute(subtractor);

        executor.awaitTermination(1, TimeUnit.MILLISECONDS);
        System.out.println(count.getValue());
    }
}

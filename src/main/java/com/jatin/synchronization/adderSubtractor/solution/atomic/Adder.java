package com.jatin.synchronization.adderSubtractor.solution.atomic;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class Adder implements Runnable {

    private Count count;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            count.increment(i);
        }
    }

}

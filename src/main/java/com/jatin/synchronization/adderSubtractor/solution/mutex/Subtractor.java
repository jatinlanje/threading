package com.jatin.synchronization.adderSubtractor.solution.mutex;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class Subtractor implements Runnable {

    private Count count;
    private Lock lock;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            lock.lock();
            Integer value = count.getValue();
            count.setValue(value - i);
            lock.unlock();
        }
    }
}

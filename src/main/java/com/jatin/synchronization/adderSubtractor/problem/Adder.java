package com.jatin.synchronization.adderSubtractor.problem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Adder implements Runnable {

    private Count count;
    @Override

    public void run() {
        for (int i = 1; i <= 100; i++) {
            Integer value = count.getValue();
            count.setValue(value + i);
        }
    }

}

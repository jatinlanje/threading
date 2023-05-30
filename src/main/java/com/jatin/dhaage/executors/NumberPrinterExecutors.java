package com.jatin.dhaage.executors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberPrinterExecutors implements Runnable {

    private Integer number;

    @Override
    public void run() {
        System.out.println("Number: " + number + " Printed by: " + Thread.currentThread().getName());
    }
}

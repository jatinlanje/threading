package com.jatin.dhaage.runnable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberPrinterRunnable implements Runnable {

    private Integer number;

    @Override
    public void run() {
        System.out.println("Number: " + number + " Printed by: " + Thread.currentThread().getName());
    }
}

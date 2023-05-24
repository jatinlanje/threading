package com.jatin.dhaage.thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberPrinterThread extends Thread {

    private Integer number;

    @Override
    public void run() {
        System.out.println("Number: " + number + " Printed by Thread: " + Thread.currentThread().getName());
    }
}
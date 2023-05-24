package com.jatin.dhaage.thread;

public class NumberPrinterThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            Thread printer = new NumberPrinterThread(i);
            //printer.run();
            printer.start();
        }
    }
}

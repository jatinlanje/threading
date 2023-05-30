package com.jatin.dhaage.runnable;

public class NumberPrinterRunnableTest {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
//            Runnable printer = new NumberPrinterRunnable(i);
//            Thread thread = new Thread(printer);
            Thread thread = new Thread(new NumberPrinterRunnable(i));
            thread.start();
        }
    }
}

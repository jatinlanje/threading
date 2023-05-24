package com.jatin.dhaage.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberPrinterExecutorsTest {
    public static void main(String[] args) {
        //Executor executor=Executors.newSingleThreadExecutor();
        //ExecutorService executor=Executors.newFixedThreadPool(10); //better memory optimisation
        ExecutorService executor = Executors.newCachedThreadPool(); //better for waiting time
        for (int i = 0; i <= 100; i++) {
            Runnable printer = new NumberPrinterExecutors(i);
            executor.execute(printer);
        }
        executor.shutdown();
    }
}

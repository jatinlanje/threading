package com.jatin.dhaage.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TextPrinterCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TextPrinterCallable textPrinter = new TextPrinterCallable();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> returnValue = executor.submit(textPrinter);
        System.out.println(returnValue.get());
        executor.shutdown();
    }
}

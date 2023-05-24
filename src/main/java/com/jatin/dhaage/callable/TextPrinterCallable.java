package com.jatin.dhaage.callable;

import java.util.concurrent.Callable;

public class TextPrinterCallable implements Callable<String> {

    @Override
    public String call() {
        return "Hello World";
    }
}

package com.jatin.synchronization.producerConsumer.solution.semaphores;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class Producer implements Runnable {

    private String name;
    private Queue<FoodItem> slots;
    private int maxItems;
    private Semaphore producer;
    private Semaphore consumer;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            producer.acquire();
            slots.add(new FoodItem());
            System.out.println(name + "produced. Left food item = " + slots.size());
            consumer.release();
        }
    }
}

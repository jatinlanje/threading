package com.jatin.synchronization.producerConsumer.solution.semaphores;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class Consumer implements Runnable {

    private String name;
    private Queue<FoodItem> slots;
    private Semaphore consumer;
    private Semaphore producer;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            consumer.acquire();
            slots.remove();
            System.out.println(name + "consumed. Left food item = " + slots.size());
            producer.release();
        }
    }
}

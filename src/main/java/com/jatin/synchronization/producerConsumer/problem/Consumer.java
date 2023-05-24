package com.jatin.synchronization.producerConsumer.problem;

import lombok.AllArgsConstructor;

import java.util.Queue;

@AllArgsConstructor
public class Consumer implements Runnable {

    private String name;
    private Queue<FoodItem> slots;

    @Override
    public void run() {
        while (true) {
            slots.remove();
            System.out.println(name + "consumed. Left food item = " + slots.size());
        }
    }
}

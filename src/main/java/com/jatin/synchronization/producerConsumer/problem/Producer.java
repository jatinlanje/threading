package com.jatin.synchronization.producerConsumer.problem;

import lombok.AllArgsConstructor;

import java.util.Queue;

@AllArgsConstructor
public class Producer implements Runnable {

    private String name;
    private Queue<FoodItem> slots;
    private int maxItems;

    @Override
    public void run() {
        while (true) {
            slots.add(new FoodItem());
            System.out.println(name + "produced. Left food item = " + slots.size());
        }
    }
}

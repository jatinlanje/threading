package com.jatin.synchronization.producerConsumer.solution.synchronizedKeyword;

import lombok.AllArgsConstructor;

import java.util.Queue;

@AllArgsConstructor
public class Consumer implements Runnable {

    private String name;
    private Queue<FoodItem> slots;

    @Override
    public void run() {
        while (true) {
            synchronized (this.slots) {
                if (slots.size() > 0) {
                    slots.remove();
                    System.out.println(name + "consumed. Left food item = " + slots.size());
                }
            }
        }
    }
}

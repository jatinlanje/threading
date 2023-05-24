package com.jatin.synchronization.producerConsumer.problem;

import java.util.ArrayDeque;
import java.util.Queue;

public class ProducerConsumerTest {
    public static void main(String[] args) {

        Queue<FoodItem> slots = new ArrayDeque<>();
        int maxItems = 20;

        Producer p1 = new Producer("p1", slots, maxItems);
        Producer p2 = new Producer("p2", slots, maxItems);
        Producer p3 = new Producer("p3", slots, maxItems);

        Consumer c1 = new Consumer("c1", slots);
        Consumer c2 = new Consumer("c2", slots);
        Consumer c3 = new Consumer("c3", slots);

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();

    }
}

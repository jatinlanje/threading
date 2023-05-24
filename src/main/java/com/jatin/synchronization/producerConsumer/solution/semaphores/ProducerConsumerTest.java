package com.jatin.synchronization.producerConsumer.solution.semaphores;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerTest {
    public static void main(String[] args) {

        Queue<FoodItem> slots = new ArrayDeque<>();
        int maxItems = 3;

        Semaphore producer = new Semaphore(maxItems);
        Semaphore consumer = new Semaphore(0);

        Producer p1 = new Producer("p1", slots, maxItems, producer, consumer);
        Producer p2 = new Producer("p2", slots, maxItems, producer, consumer);
        Producer p3 = new Producer("p3", slots, maxItems, producer, consumer);

        Consumer c1 = new Consumer("c1", slots, consumer, producer);
        Consumer c2 = new Consumer("c2", slots, consumer, producer);
        Consumer c3 = new Consumer("c3", slots, consumer, producer);


        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();

    }
}

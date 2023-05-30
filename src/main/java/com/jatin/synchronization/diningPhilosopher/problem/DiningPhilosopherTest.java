package com.jatin.synchronization.diningPhilosopher.problem;

import com.jatin.synchronization.diningPhilosopher.problem.DiningPhilosopher;

public class DiningPhilosopherTest {
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) {
        Object[] forks = new Object[NUM_PHILOSOPHERS];
        DiningPhilosopher[] philosophers = new DiningPhilosopher[NUM_PHILOSOPHERS];

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];

            philosophers[i] = new DiningPhilosopher(i, leftFork, rightFork);
            philosophers[i].start();
        }
    }
}

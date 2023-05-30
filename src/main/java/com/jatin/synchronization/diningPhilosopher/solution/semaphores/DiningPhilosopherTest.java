package com.jatin.synchronization.diningPhilosopher.solution.semaphores;

import com.jatin.synchronization.diningPhilosopher.solution.semaphores.DiningPhilosopher;

import java.util.concurrent.Semaphore;

public class DiningPhilosopherTest {
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) {
        Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS];
        DiningPhilosopher[] philosophers = new DiningPhilosopher[NUM_PHILOSOPHERS];

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1);
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];

            philosophers[i] = new DiningPhilosopher(i, leftFork, rightFork);
            philosophers[i].start();
        }
    }
}

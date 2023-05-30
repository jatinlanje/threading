package com.jatin.synchronization.diningPhilosopher.solution.semaphores;

import java.util.concurrent.Semaphore;

public class DiningPhilosopher extends Thread{
    private int id;
    private Semaphore leftFork;
    private Semaphore rightFork;

    public DiningPhilosopher(int id, Semaphore leftFork, Semaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating");
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                // Acquire the left fork
                leftFork.acquire();
                System.out.println("Philosopher " + id + " has taken the left fork");
                // Acquire the right fork
                rightFork.acquire();
                System.out.println("Philosopher " + id + " has taken the right fork");
                // Start eating
                eat();
                // Release the right fork
                rightFork.release();
                System.out.println("Philosopher " + id + " has released the right fork");
                // Release the left fork
                leftFork.release();
                System.out.println("Philosopher " + id + " has released the left fork");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

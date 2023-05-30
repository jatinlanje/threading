package com.jatin.synchronization.diningPhilosopher.problem;

public class DiningPhilosopher extends Thread{
    private int id;
    private Object leftFork;
    private Object rightFork;

    public DiningPhilosopher(int id, Object leftFork, Object rightFork) {
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
                // TODO: Implement the logic for acquiring forks and eating
                eat();
                // TODO: Implement the logic for releasing forks
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

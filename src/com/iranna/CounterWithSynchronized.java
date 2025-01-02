package com.iranna;


public class CounterWithSynchronized {
    private int counter = 0;

    // Synchronized method to increment the counter
    public synchronized void increment() {
        counter++; // Critical section
        System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
    }

    // Synchronized method to get the counter value
    public synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        CounterWithSynchronized counter = new CounterWithSynchronized();

        // Create multiple threads to increment the counter
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                try {
                    Thread.sleep(100); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print final counter value
        System.out.println("Final Counter Value: " + counter.getCounter());
    }
}

package com.iranna;


public class ThreadMethods2 {
    public static void main(String[] args) {
        // Declare worker2 first
        Thread worker2 = new Thread(() -> {
            System.out.println("Worker 2: Started");
            try {
                Thread.sleep(2000); // Simulate some work
            } catch (InterruptedException e) {
                System.out.println("Worker 2: Interrupted");
            }
            System.out.println("Worker 2: Finished");
        });

        // Now declare worker1
        Thread worker1 = new Thread(() -> {
            System.out.println("Worker 1: Started");
            try {
                System.out.println("Worker 1: Waiting for Worker 2 to complete");
                worker2.join(); // Worker 1 waits for Worker 2 to finish
            } catch (InterruptedException e) {
                System.out.println("Worker 1: Interrupted while waiting");
            }
            System.out.println("Worker 1: Finished");
        });

        System.out.println("Main Thread: Starting Worker Threads");
        worker2.start(); // Start worker2 first
        worker1.start(); // Start worker1 after
    }
}

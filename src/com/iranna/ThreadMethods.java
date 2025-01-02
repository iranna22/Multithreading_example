package com.iranna;

public class ThreadMethods {

    public static void main(String[] args) {
        // Create a thread using a subclass of Thread
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: Started");
            try {
                System.out.println("Thread 1: Sleeping for 2 seconds");
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread 1: Interrupted while sleeping");
            }
            System.out.println("Thread 1: Finished");
        });

        // Create another thread
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: Started");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: Counting " + i);
                try {
                    Thread.sleep(500); // Sleep for 500 milliseconds between counts
                } catch (InterruptedException e) {
                    System.out.println("Thread 2: Interrupted while sleeping");
                }
            }
            System.out.println("Thread 2: Finished");
        });

        System.out.println("Main thread: Starting threads");
        
        // Start the threads
        thread1.start();
        System.out.println("Main thread: between the two threads");
        thread2.start();
//you comment some parts and check
       try {
            System.out.println("Main thread: Waiting for thread 1 to finish");
            thread1.join(); // Wait for thread1 to complete
            System.out.println("Main thread: Thread 1 has finished");

            System.out.println("Main thread: Waiting for thread 2 to finish");
            thread2.join(); // Wait for thread2 to complete
            System.out.println("Main thread: Thread 2 has finished");
        } catch (InterruptedException e) {
            System.out.println("Main thread: Interrupted while waiting");
        }

        System.out.println("Main thread: All threads have finished. Exiting program");
        System.out.println("Main thread: hi");
    }
}

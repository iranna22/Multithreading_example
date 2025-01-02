package com.iranna;

public class UserAndDaemonThreadExample {
    public static void main(String[] args) {
        // Create a user thread
        Thread userThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("User thread: Task " + i);
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("User thread has completed its tasks.");
        });

        // Create a daemon thread
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running in the background...");
                try {
                    Thread.sleep(500); // Simulate background work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Set the second thread as a daemon
        daemonThread.setDaemon(true);

        // Start both threads
        userThread.start();
        daemonThread.start();

        // Main thread completes
        System.out.println("Main thread has finished execution.");
    }
}

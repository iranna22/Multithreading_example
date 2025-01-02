package com.iranna;


import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void performTask() {
        lock.lock(); // Acquire the lock
        try {
            System.out.println(Thread.currentThread().getName() + " is performing a task");
            // Critical section
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        Runnable task = example::performTask;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

package com.iranna;

public class ThreadPriorityExample {
    public static void main(String[] args) {
        // Thread with default priority
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Priority: " 
                                   + Thread.currentThread().getPriority());
            }
        }, "Thread-1");
        
        // Thread with minimum priority
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Priority: " 
                                   + Thread.currentThread().getPriority());
            }
        }, "Thread-2");
        thread2.setPriority(Thread.MIN_PRIORITY);

        // Thread with maximum priority
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Priority: " 
                                   + Thread.currentThread().getPriority());
            }
        }, "Thread-3");
        thread3.setPriority(Thread.MAX_PRIORITY);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

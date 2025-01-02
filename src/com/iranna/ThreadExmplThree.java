package com.iranna;

/* Creating threads with different constructors of Thread class */
public class ThreadExmplThree {
    public static void main(String[] args) {
        // Using Thread(String name)
        Thread thread1 = new Thread("Thread-1") {
            @Override
            public void run() {
                System.out.println(getName() + " is running.");
            }
        };
        thread1.start();

        // Using Thread(Runnable r)
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is running.");
        };
        Thread thread2 = new Thread(task);
        thread2.start();

        // Using Thread(Runnable r, String name)
        Thread thread3 = new Thread(task, "Thread-3");
        thread3.start();
    }
}

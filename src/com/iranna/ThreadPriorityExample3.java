package com.iranna;
/*Different ways of creating threads*/


//Implementation class for Runnable (used by thread1)
class ThreadTask implements Runnable {
 @Override
 public void run() {
     for (int i = 0; i < 5; i++) {
         System.out.println(Thread.currentThread().getName() + " - Priority: " 
                            + Thread.currentThread().getPriority());
     }
 }
}

//Extending Thread class (used by thread2)
class CustomThread extends Thread {
 public CustomThread(String name) {
     super(name);
 }

 @Override
 public void run() {
     for (int i = 0; i < 5; i++) {
         System.out.println(Thread.currentThread().getName() + " - Priority: " 
                            + Thread.currentThread().getPriority());
     }
 }
}

public class ThreadPriorityExample3 {
 public static void main(String[] args) {
     // Thread with default priority using Runnable implementation class
     Thread thread1 = new Thread(new ThreadTask(), "Thread-1");

     // Thread with custom priority using Thread extension
     CustomThread thread2 = new CustomThread("Thread-2");
     thread2.setPriority(6);

     // Thread with custom priority using lambda (for variety)
     Thread thread3 = new Thread(() -> {
         for (int i = 0; i < 5; i++) {
             System.out.println(Thread.currentThread().getName() + " - Priority: " 
                                + Thread.currentThread().getPriority());
         }
     }, "Thread-3");
     thread3.setPriority(2);

     // Start threads
     thread1.start();
     thread2.start();
     thread3.start();
 }
}

package com.iranna;


class ThreadExmplTwo implements Runnable{  
public void run(){  
System.out.println("thread with impl Runnable is running...");  
}  
  
public static void main(String args[]){  
ThreadExmplTwo m1=new ThreadExmplTwo();  
Thread t1 =new Thread(m1);   // Using the constructor Thread(Runnable r)  
t1.start();  
 }  
}  
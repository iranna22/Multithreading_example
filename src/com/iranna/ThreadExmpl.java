package com.iranna;


public class ThreadExmpl extends Thread{  
public void run(){  
System.out.println("thread with extending Thread is running...");  
}  
public static void main(String args[]){  
	ThreadExmpl t1=new ThreadExmpl();  
t1.start();  
 }  
}  
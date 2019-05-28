package com.java.threads;

public class Synchronize {

	public static void main(String[] args) {
		ThreadD t1 = new ThreadD(new Demo1());
		ThreadD t2 = new ThreadD(new Demo1());
		ThreadD t3 = new ThreadD(new Demo1());
		t1.start();
		t2.start();
		t3.start();
		
	}

}



class ThreadD extends Thread {
	Demo1 d;
	public ThreadD(Demo1 d) {
		this.d = d;
	}
	@Override
	public void run() {
		Demo1.classLevel();
		d.objectLevel();
	}
}
class Demo1 {
	public Demo1() {
		
	}
	public static final synchronized void classLevel() {
		System.out.println("Class level method.");
	}
	
	public synchronized void objectLevel() {
		System.out.println("object level method.");
	}
}

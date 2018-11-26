package com.java.threads;
import java.util.Date;

public class ThreadLocalDemo {
	public static void main(String[] args) throws InterruptedException {
		thread t1 = new thread();
		thread t2 = new thread();
		thread t3 = new thread();
		t1.start();
		t2.start();
		Thread.sleep(1000);
		t3.start();
	}

}

class classLock {
	public static synchronized void display() {
		System.out.println("Somebody has acquired class lock.");
	}
}

class thread extends Thread {
	ThreadLocal<String> local = new ThreadLocal<String>();

	@Override
	public void run() {
		System.out.println("ACTIVE COUNT IN THREAD GROUP\t" + activeCount());
		setPriority(10);
		System.out.println("PRIORITY\t" + getPriority());
		local.set(new Date().toString());
		setName("HelloThread");
		System.out.println("THREAD NAME\t" + getName() + "THREAD START:" + local.get());
		classLock.display();

	}
}
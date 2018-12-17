package com.java.threads;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) {
		CountDownLatch mainLatch = new CountDownLatch(3);
		new Thread(new ThreadClass("Cache", 3000, mainLatch)).start();

		new Thread(new ThreadClass("API", 3000, mainLatch)).start();

		new Thread(new ThreadClass("Database", 3000, mainLatch)).start();

		try {
			mainLatch.await();
			System.out.println("All the services are up" + mainLatch.getCount());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ThreadClass implements Runnable {
	String nameOfThread;
	int sTime;
	CountDownLatch latch;

	public ThreadClass(String name, int startTime, CountDownLatch latch) {
		this.nameOfThread = name;
		this.sTime = startTime;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			this.latch.countDown();
			Thread.sleep(this.sTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The service :\t" + nameOfThread + "\t is up...");

	}

}

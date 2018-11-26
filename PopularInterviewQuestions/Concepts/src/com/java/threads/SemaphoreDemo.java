package com.java.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(4);
		Thread_3 t1 = new Thread_3(sem);
		Thread_3 t2 = new Thread_3(sem);
		Thread_3 t3 = new Thread_3(sem);
		t1.start();
		t2.start();
		t3.start();
	}
}

class Thread_3 extends Thread {
	Semaphore semaphore;
	int i = 0;

	public Thread_3(Semaphore sem) {
		this.semaphore = sem;
	}

	@Override
	public void run() {

		try {
			System.out.println(Thread.currentThread().getName());
			this.semaphore.acquire();
			while (i < 3) {
				System.out.println(i++);
			}
			this.semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

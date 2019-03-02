package com.java.threads;

public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		thread6 t1 = new thread6("t1");
		thread6 t2 = new thread6("t2");
		thread6 t3 = new thread6("t3");
		t1.start();
		t1.join();
		t2.start();
		// Join is used to bring order to the way threads are executed or run.
		t2.join();
		t3.start();
		// t3.join();
	}
}

class thread6 extends Thread {
	public thread6(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println("THREAD NAME\t" + getName());

		}
	}
}
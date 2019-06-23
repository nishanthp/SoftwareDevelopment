package com.java.threads;

public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread6 t1 = new Thread6("t1");
		Thread6 t2 = new Thread6("t2");
		Thread6 t3 = new Thread6("t3");
		t1.start();
		t1.join();
		t2.start();
		// Join is used to bring order to the way threads are executed or run.
		t2.join();
		t3.start();
		// t3.join();
		
		// Runnable interface does not have run() method implemented. 
		// Thread class implements Runnable interface.  
	}
}


class Thread6 extends Thread {
	public Thread6(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println("THREAD NAME\t" + getName());

		}
	}
}
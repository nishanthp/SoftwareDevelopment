package com.java.threads;

import java.util.concurrent.Callable;

public class RunnableThread {

	public static void main(String[] args) {

		T1 t1 = new T1();
		t1.run();

		Thread t2 = new Thread(new T1());
		t2.start();
	}

}

class T1 implements Runnable {

	@Override
	public void run() {
		System.out.println("This is runnable thread.");

	}

}

class T2 implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

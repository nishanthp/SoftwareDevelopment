package com.java.threads;
import java.util.ArrayList;

public class PCUsingWaitAndNotifyDemo {
	public static Boolean available = false;
	// make object hold a list. can eliminate boolean available.
	public static Object12 ob12 = new Object12();

	public static void main(String[] args) {
		new Thread(new Producer1()).start();
		new Thread(new Consumer1()).start();
	}

	static class Producer1 extends Thread {

		@Override
		public void run() {
			while (true) {
				synchronized (ob12) {
					if (available == false) {
						System.out.println("PRODUCED:" + getName());
						ob12.setData(10);
						available = true;
						ob12.notifyAll();
					}

					else {
						try {
							ob12.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	static class Consumer1 extends Thread {

		@Override
		public void run() {
			while (true) {
				synchronized (ob12) {
					if (available == true) {

						System.out.println("CONSUMED:   " + getName());
						System.out.println("DATA:      " + ob12.getData());
						available = false;
						ob12.notifyAll();
					}

					else {
						try {
							ob12.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	static class Object12 {
		int data;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

	}
}

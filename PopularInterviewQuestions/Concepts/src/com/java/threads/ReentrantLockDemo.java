package com.java.threads;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	public static void main(String[] args) {
		ObjectDemo o = new ObjectDemo();
		new Thread(new ThreadDe(o)).start();
		new Thread(new ThreadDe(o)).start();

	}
}

class ThreadDe extends Thread {
	ObjectDemo object;

	public ThreadDe(ObjectDemo o) {
		this.object = o;
	}

	@Override
	public void run() {
		try {
			System.out.println("THREAD NAME:" + getName());
			System.out.println(this.object.setAndgetValue(10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ObjectDemo {
	ReentrantLock lock = new ReentrantLock(true);
	int objectValue;

	public int setAndgetValue(int i) throws InterruptedException {
		lock.lock();
		System.out.println("QUEUE LENGTH FOR THE LOCK:     " + lock.getQueueLength());
		Thread.sleep(2000);
		objectValue = i;
		return getValue();
	}

	private int getValue() {
		lock.unlock();
		return objectValue;
	}

}

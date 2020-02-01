package com.java.threads;

import java.util.LinkedList;
import java.util.List;

public class ConsumerProducerProblem {

	public static void main(String[] args) {
		Subject s = new Subject();
		Producer1 pThread = new Producer1(s);
		Consumer1 cThread = new Consumer1(s);
		pThread.start();
		cThread.start();
	}

}

class Producer1 extends Thread {
	Subject s;
	public Producer1(Subject sub) {
		this.s = sub;
	}

	public void run() {
		while (true) {
			synchronized (this.s) {
				while (this.s.list.size() == 5) {
					try {
						this.s.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int index = 0;
				while (this.s.list.size() < 5) {
					System.out.println("adding to subject list " + index);
					this.s.list.add(index++);
				}
				this.s.notify();
			}
		}
	}
}

class Consumer1 extends Thread {
	Subject s;
	public Consumer1(Subject sub) {
		this.s = sub;
	}

	public void run() {
		while (true) {
			synchronized (this.s) {
				while (this.s.list.size() == 0) {
					try {
						// releases the object monitor and goes to sleep.
						// continues to the next line, only
						// when it is notified.
						this.s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				while (this.s.list.size() > 0) {
					System.out.println("Removing from the subject list "
							+ this.s.list.remove(this.s.list.size() - 1));
				}
				// Will wake all the threads that called wait on this object
				// monitor to wake up (runnable state).
				// However, it does NOT release the object monitor (object
				// lock). Only after the execution of
				// synchronized block is complete, the object monitor is
				// released.
				this.s.notify();
			}
		}
	}
}

// This is the class that holds the linkedlist.
class Subject {
	List<Integer> list = new LinkedList<>();
}

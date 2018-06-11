package javaThreadConcept;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PCBlockingQueueDemo {
	static BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>();

	public static void main(String[] args) {
		new Thread(new Producer(bq)).start();
		new Thread(new Consumer(bq)).start();
	}
}

class Producer extends Thread {
	BlockingQueue<Integer> localBQ;
	int i = 0;

	public Producer(BlockingQueue<Integer> bq) {
		this.localBQ = bq;
	}

	@Override
	public void run() {
		System.out.println("PRODUCER" + getName());
		while (i < 5) {
			System.out.println("PRODUCING:   " + i++);
			try {
				this.localBQ.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

class Consumer extends Thread {
	BlockingQueue<Integer> localrb;

	public Consumer(BlockingQueue<Integer> bq) {
		this.localrb = bq;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("CONSUMER:     " + getName());
				System.out.println(this.localrb.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
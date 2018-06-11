package javaThreadConcept;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static void main(String[] args) {
		CyclicBarrier mainLatch = new CyclicBarrier(3);
		new Thread(new ThreadClass1("Cache", 3000, mainLatch)).start();

		new Thread(new ThreadClass1("API", 3000, mainLatch)).start();

		new Thread(new ThreadClass1("Database", 3000, mainLatch)).start();

		try {
			mainLatch.await();
			System.out.println("All the services are up" + mainLatch.getNumberWaiting());
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ThreadClass1 implements Runnable {
	String nameOfThread;
	int sTime;
	CyclicBarrier latch;

	public ThreadClass1(String name, int startTime, CyclicBarrier latch) {
		this.nameOfThread = name;
		this.sTime = startTime;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(this.sTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The service :\t" + nameOfThread + "\t is up...");
		try {
			this.latch.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

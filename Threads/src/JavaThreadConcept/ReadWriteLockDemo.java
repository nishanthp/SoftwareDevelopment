package JavaThreadConcept;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ReadWriteLockDemo {
	public static void main(String[] args) throws InterruptedException {
		TreadSafeArray array = new TreadSafeArray();
		Thread tw = new Thread(new ThreadWrite(array));
		tw.start();

		Thread tr1 = new Thread(new ThreadRead(array));
		tr1.start();

		Thread tr2 = new Thread(new ThreadRead(array));
		tr2.start();

	}
}

class ThreadRead extends Thread {
	TreadSafeArray localArray;

	public ThreadRead(TreadSafeArray array) {
		this.localArray = array;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("THREAD NAME:      " + getName());
			System.out.println(this.localArray.getValue());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ThreadWrite extends Thread {
	TreadSafeArray localArray;

	public ThreadWrite(TreadSafeArray array) {
		this.localArray = array;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 3) {
			System.out.println("THREAD NAME:      " + getName());
			this.localArray.setValue(11);
			i++;
		}
	}

}

class TreadSafeArray {
	ReadWriteLock lock = new ReentrantReadWriteLock();
	Lock readLock;
	Lock writeLock;
	ArrayList<Integer> integerArray = new ArrayList<>();

	public TreadSafeArray() {
		integerArray.add(10);
		readLock = lock.readLock();
		writeLock = lock.writeLock();
	}

	public void setValue(Integer i) {
		writeLock.lock();
		integerArray.add(1, i);
		writeLock.unlock();
	}

	public Integer getValue() {
		readLock.lock();
		int returnVal = integerArray.get(0);
		readLock.unlock();
		return returnVal;
	}
}
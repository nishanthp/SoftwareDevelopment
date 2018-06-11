package JavaThreadConcept;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ImplementLockDemo {

}

// implemnets a lock using synchronised method.
class ReadWriteLock  {
	Object lock;
	boolean writer = false;
	int reader = 0;
	int shared_data = -1;

	public int read() throws InterruptedException {
		while (writer) {
			lock.wait();
		}
		synchronized (lock) {
			reader += 1;
		}
		lock.notifyAll();
		int local_var = shared_data;
		synchronized (lock) {
			reader -= 1;
			lock.notifyAll();
		}

		return local_var;
	}

	public void write(int data) throws InterruptedException {
		while (reader > 0 || writer) {
			lock.wait();
		}
		synchronized (lock) {
			writer = true;
		}
		shared_data = data;
		lock.notifyAll();
		synchronized (lock) {
			writer = false;
		}
	}
}
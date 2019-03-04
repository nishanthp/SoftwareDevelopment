package com.java.threads;

public class SynchronisedBlock {
	public static void main(String[] args) {
		resource r = new resource();
		object o = new object(r);
		o.start();
		System.out.println("HOLDS LOCK" + object.holdsLock(r));
		
		Object2 ob2 = new Object2(r);
		ob2.start();

	}
}

// Thread can implement Runnable/Callable interface too.
class object extends Thread {
	resource res;

	public object(resource r) {
		this.res = r;
	}

	@Override
	public void run() {
		synchronized (this.res) {
			System.out.println(holdsLock(this.res));
			this.res.display();
		}
	}
}

class Object2  extends Thread {
	resource res1;
	public Object2(resource r) {
		this.res1 = r ;
	}
	@Override
	public synchronized void run() {
		this.res1.display();
	}
}

class resource extends Object{
	public void display() {
		System.out.println("This is resource obejct");
	}
}
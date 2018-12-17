package com.java.threads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ReadWriteLockDemo {
	public static void main(String[] args) throws InterruptedException {
		TreadSafeArray array = new TreadSafeArray();
		Thread tw = new ThreadWrite(array);
		tw.start();
		Thread tr1 = new ThreadRead(array);
		tr1.start();
		tr1.join();
		Thread tr2 = new ThreadRead(array);
		tr2.start();
		tr2.join();

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
		System.out.println("THREAD NAME:      " + getName());
		this.localArray.setValue(11);

	}

}

class TreadSafeArray {
	ReadWriteLock lock = new ReentrantReadWriteLock();
	Lock readLock;
	Lock writeLock;
	int sharedResource;

	public TreadSafeArray() {
		readLock = lock.readLock();
		writeLock = lock.writeLock();
	}

	public void setValue(Integer i) {
		writeLock.lock();
		sharedResource = i;
		writeLock.unlock();
	}

	public Integer getValue() {
		readLock.lock();
		int returnVal = sharedResource;
		readLock.unlock();
		return returnVal;
	}
}
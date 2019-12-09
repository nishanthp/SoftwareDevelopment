package com.accepted.submissions.threads;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	class Foo {
		CountDownLatch lock1;
		CountDownLatch lock2;
		public Foo() {
			lock1 = new CountDownLatch(1);
			lock2 = new CountDownLatch(1);
		}

		public void first(Runnable printFirst) throws InterruptedException {
			// printFirst.run() outputs "first". Do not change or remove this
			// line.
			printFirst.run();
			lock1.countDown();
		}

		public void second(Runnable printSecond) throws InterruptedException {
			lock1.await();
			// printSecond.run() outputs "second". Do not change or remove this
			// line.
			printSecond.run();
			lock2.countDown();

		}

		public void third(Runnable printThird) throws InterruptedException {
			lock1.await();
			lock2.await();
			// printThird.run() outputs "third". Do not change or remove this
			// line.
			printThird.run();
		}
	}

}

package com.accepted.submissions.threads;

import java.util.concurrent.CountDownLatch;

public class PrintFooBar {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	class FooBar {
		private int n;
		CountDownLatch l1;
		CountDownLatch l2;
		public FooBar(int n) {
			this.n = n;
			l1 = new CountDownLatch(1);
		}

		public void foo(Runnable printFoo) throws InterruptedException {

			for (int i = 0; i < n; i++) {
				if (l2 != null)
					l2.await();
				l2 = new CountDownLatch(1);
				// printFoo.run() outputs "foo". Do not change or remove this
				// line.
				printFoo.run();
				l1.countDown();
			}
		}

		public void bar(Runnable printBar) throws InterruptedException {

			for (int i = 0; i < n; i++) {
				l1.await();
				l1 = new CountDownLatch(1);
				// printBar.run() outputs "bar". Do not change or remove this
				// line.
				printBar.run();
				l2.countDown();
			}
		}
	}

}

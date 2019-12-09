package com.accepted.submissions.threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintEvenOdd {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	class ZeroEvenOdd {
		private int n;
		Semaphore sZero;
		Semaphore sEven;
		Semaphore sOdd;
		public ZeroEvenOdd(int n) {
			this.n = n;
			sZero = new Semaphore(1);
			sEven = new Semaphore(0);
			sOdd = new Semaphore(0);
		}

		// printNumber.accept(x) outputs "x", where x is an integer.
		public void zero(IntConsumer printNumber) throws InterruptedException {
			for (int i = 1; i <= n; i++) {
				sZero.acquire();
				printNumber.accept(0);
				if (i % 2 == 0) {
					sEven.release();
				} else {
					sOdd.release();
				}
			}
		}

		public void even(IntConsumer printNumber) throws InterruptedException {
			for (int i = 2; i <= n; i += 2) {
				sEven.acquire();
				printNumber.accept(i);
				sZero.release();
			}
		}

		public void odd(IntConsumer printNumber) throws InterruptedException {
			for (int i = 1; i <= n; i += 2) {
				sOdd.acquire();
				printNumber.accept(i);
				sZero.release();
			}
		}
	}
}

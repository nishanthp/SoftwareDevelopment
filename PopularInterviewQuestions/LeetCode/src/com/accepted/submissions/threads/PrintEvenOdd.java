package com.accepted.submissions.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class PrintEvenOdd {

	public static void main(String[] args) {
		// Ran on leetcode.
//		long l1= 1234L;
//		long l2 = 1234L;
//		System.out.println(((Object)l1).equals(l2));
//		
//		Payment p1 = new Payment();
//		p1.id = "12323";
//		p1.name = "pname1";
//		
//		Payment p2 = new Payment();
//		p2.id = "6543";
//		p2.name = "pname1334";
//		
//		List<Payment> oldList = new ArrayList<>();
//		oldList.add(p1);
//		oldList.add(p2);
//		
//		List<String> result = oldList
//        .stream()
//        .map(Payment::getName)
//        .collect(Collectors.toList());
//		
//		for(String current : result) {
//			System.out.println(current);
//		}
		
		String n = "lvsr1cdcorderconsumer-x8pzg-tess0075";
		System.out.println(n.contains("lvs"));

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

class Payment {
	String id;
	String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

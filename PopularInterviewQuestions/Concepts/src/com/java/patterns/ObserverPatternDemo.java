package com.java.patterns;

import java.util.ArrayList;

public class ObserverPatternDemo {
	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer1 ob1 = new Observer1(subject);
		Observer2 ob2 = new Observer2(subject);
		subject.setNumber(10);
	}
}

abstract class Observer {
	Subject subject;

	public abstract void update();
}

class Observer1 extends Observer {

	public Observer1(Subject sub) {
		this.subject = sub;
		this.subject.addToObserverList(this);
	}

	@Override
	public void update() {
		System.out.println("Observer 1 notified.");
	}

}

class Observer2 extends Observer {

	public Observer2(Subject sub) {
		this.subject = sub;
		this.subject.addToObserverList(this);
	}

	@Override
	public void update() {
		System.out.println("Observer 2 notified.");
	}

}

class Subject {
	ArrayList<Observer> observers = new ArrayList<>();
	int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		notifyObserver();
	}

	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public void addToObserverList(Observer observer) {
		observers.add(observer);
	}
}
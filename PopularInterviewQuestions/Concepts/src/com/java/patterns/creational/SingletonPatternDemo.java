package com.java.patterns.creational;

public class SingletonPatternDemo {
	public static void main(String[] args) {
		System.out.println(SingletonDemo.getInstance().hashCode());
		System.out.println(SingletonDemo.getInstance().hashCode());
	}
}

class SingletonDemo {
	static SingletonDemo singletonDemoInstance = null;

	private SingletonDemo() {
	}

	public static SingletonDemo getInstance() {
		if (null == singletonDemoInstance) {
			singletonDemoInstance = new SingletonDemo();
		}
		return singletonDemoInstance;
	}

	public void display() {
		System.out.println("This is a singleton class.");
	}
}

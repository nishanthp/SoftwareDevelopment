package com.java.concepts;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo {
	private static final Logger LOGGER = Logger.getLogger(LoggerDemo.class.getName()); 

	public static void main(String[] args) {
		LoggerDemo d = new LoggerDemo();
		System.out.println(d.getLogger().getName());
		System.out.println("class " + LOGGER.getName());
		
		
		Ex e = new Ex("");
		System.out.println(e);
		Ex e1 = new Ex("Admin");
		System.out.println(e1);
	}	
	
	public Logger getLogger() {
		this.LOGGER.log(Level.SEVERE, "OMG");
		return this.LOGGER;
	}

}


class Ex {
	private static final float serialVersionUID = 1L;
	private String name;
	Ex(String name) {
		this.name = name;
	}
//	public String toString() {
//		return getClass().getName();
//	}
}

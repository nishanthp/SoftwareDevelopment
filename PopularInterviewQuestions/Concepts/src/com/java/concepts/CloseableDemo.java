package com.java.concepts;

import java.io.Closeable;

import javax.xml.ws.WebServiceException;


public class CloseableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Learning implements Closeable{
	String firstName;
	String lastName; 
	Learning(){
		this.firstName ="nish";
		this.lastName = "pr";
	}
	
	public String getName(){
		return this.firstName + this.lastName;
	}

	@Override
	public void close() throws WebServiceException {
		// Used to release the system resources associated with this stream.
		
	}
}
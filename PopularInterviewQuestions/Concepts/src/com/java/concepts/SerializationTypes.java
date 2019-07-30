package com.java.concepts;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class SerializationTypes {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("key", 1);
		HashMap<String, S3Bucket> mapObject = new HashMap<String, S3Bucket>();
		mapObject.put("1", new S3Bucket());
		ByteArrayOutputStream bt = new ByteArrayOutputStream();
		try {
			ObjectOutputStream out = new ObjectOutputStream(bt);
			out.writeObject(map);
			out.close(); 
			System.out.println(bt.toByteArray());
			bt.close();
			
			
			ObjectOutputStream outObject = new ObjectOutputStream(bt);
			out.writeObject(mapObject);
			out.close(); 
			System.out.println(bt.toByteArray());
			bt.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class S3Bucket implements Serializable {
	
}

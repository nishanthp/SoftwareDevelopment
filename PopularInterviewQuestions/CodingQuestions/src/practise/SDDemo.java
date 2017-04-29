package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SDDemo {
	demo incomingObj = null;

	public static void main(String[] args) {
		String filePath = "C:" + File.separator + "text.txt";
		try {
			FileOutputStream file = new FileOutputStream(filePath);
			ObjectOutputStream obj = new ObjectOutputStream(file);
			obj.writeObject(new demo("test", 11));
			file.close();
			obj.close();
			System.out.println("Object serialized...");

			FileInputStream filein = new FileInputStream(filePath);
			ObjectInputStream input = new ObjectInputStream(filein);
			demo object = (demo) input.readObject();
			filein.close();
			input.close();
			System.out.println(object.demoInt + object.demoName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class demo implements Serializable {
	String demoName;
	int demoInt;

	public demo(String name, int num) {
		this.demoName = name;
		this.demoInt = num;
	}

}

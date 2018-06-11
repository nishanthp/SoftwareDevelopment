package javaThreadConcept;
import java.util.ArrayList;

public class LockSplittingDemo {
	public static void main(String[] args) {
		TreadSafeObjectArray tso = new TreadSafeObjectArray();
		new Thread(new Threading(tso)).start();
		new Thread(new Threading(tso)).start();
		new Thread(new Threading(tso)).start();
	}
}

class Threading extends Thread {
	TreadSafeObjectArray localArray;
	display localObj;

	public Threading(TreadSafeObjectArray array) {
		this.localArray = array;
	}

	@Override
	public void run() {
		synchronized (this.localArray) {
			localObj = this.localArray.getValue();
			System.out.println("THREAD NAME:   " + getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (localObj) {
			System.out.println("THREAD NAME:   " + getName());
			System.out.println("THE VALUE:    " + localObj.get());
		}
	}

}

class TreadSafeObjectArray {

	ArrayList<display> integerArray = new ArrayList<>();

	public TreadSafeObjectArray() {
		integerArray.add(new display());
	}

	public void setValue(Integer i) {

		integerArray.add(1, new display());

	}

	public display getValue() {
		return integerArray.get(0);
	}
}

class display {
	int i = 0;

	public int get() {
		return i;
	}

	public void set(int reqV) {
		i = reqV;
	}
}
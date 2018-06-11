package javaThreadConcept;

public class ThreadDemo {
	public static void main(String[] args) {
	}
}

class thread2 extends Thread {
	Object pi;

	public thread2(int i) {
		this.pi = i;
	}

	@Override
	public void run() {

	}
}
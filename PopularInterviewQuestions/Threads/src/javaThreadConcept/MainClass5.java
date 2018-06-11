package JavaThreadConcept;

public class MainClass5 {
	public static void main(String[] args) throws InterruptedException {
		thread6 t1 = new thread6("t1");
		thread6 t2 = new thread6("t2");
		thread6 t3 = new thread6("t3");
		t1.start();
		t1.join();
		t2.start();
		// t2.join();
		t3.start();
		// t3.join();
	}
}

class thread6 extends Thread {
	public thread6(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println("THREAD NAME\t" + getName());

		}
	}
}
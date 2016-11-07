import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntergerDemo {
	public static AtomicInteger at = new AtomicInteger(0);

	public static void main(String[] args) {
		ThreadD td1 = new ThreadD();
		ThreadD td2 = new ThreadD();
		td1.start();
		td2.start();
	}

	static class ThreadD extends Thread {
		@Override
		public void run() {
			int incrmented = at.incrementAndGet();
			System.out.println("THREAD NAME:   " + getName() + "VALUE IS:     " + incrmented);
			int added10 = at.addAndGet(10);
			System.out.println("THREAD NAME:   " + getName() + "VALUE BY ADDING 10:     " + added10);
		}
	}
}

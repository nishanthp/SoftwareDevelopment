package JavaThreadConcept;
import java.util.concurrent.CountDownLatch;

public class VolatileDemo {
	public static volatile int my_variable = 0;

	public static void main(String[] args) {
		new Thread(new ThreadChanger()).start();
		new Thread(new ThreadListner()).start();
	}

	static class ThreadChanger implements Runnable {
		@Override
		public void run() {
			int localVar = my_variable;
			while (localVar < 10) {
				System.out.println("INCREMENTING local variable by 1\t" + localVar);
				my_variable = localVar++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	static class ThreadListner implements Runnable {
		@Override
		public void run() {
			int localVariable = my_variable;
			while (my_variable < 10) {
				 System.out.println("\t" + localVariable);
				 System.out.println(my_variable);
				if (localVariable != my_variable) {
					localVariable = my_variable;
					System.out.println("I GOT THE CHANGE:\t" + localVariable);
				}

			}

		}
	}
}
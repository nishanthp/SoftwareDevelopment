package javaThreadConcept;

import java.lang.reflect.GenericArrayType;

public class ThreadGroupDemo {
	public static void main(String[] args) {
		ThreadGroup g = new ThreadGroup("NewThread");
		thread1 t1 = new thread1(g, "MyThread");
		boolean interrupt = t1.isInterrupted();
		thread1.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("THREAD NAME:\t" + t.getName() + "REASON FOR TERMINATION:\t" + e.getMessage());

			}
		});
		t1.start();
		g.interrupt();
		System.out.println(t1.isInterrupted());
		System.out.println("ACTIVE COUNT ON MAIN THREAD\t" + Thread.currentThread().getThreadGroup());
	}
}

class thread1 extends Thread {
	public thread1(ThreadGroup group, String name) {
		super(group, name);
	}

	@Override
	public void run() {
		System.out.println(getThreadGroup());
		System.out.println(activeCount());
		try {
			Thread.sleep(2000);
			System.out.println("Does it reach here!!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
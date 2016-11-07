import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Thread_1 t1 = new Thread_1();
		Thread_1 t2 = new Thread_1();
		Thread_1 t3 = new Thread_1();
		/*
		 * Executors return an executor service with n threads. This internally
		 * uses a ThreadPoolExecutor, the one shown below.
		 */
		ExecutorService executoprService = Executors.newFixedThreadPool(1);
		Future<Boolean> ft1 = executoprService.submit(t1);
		Future<Boolean> ft2 = executoprService.submit(t2);
		Future<Boolean> ft3 = executoprService.submit(t3);
		/* This is a non blocking call. */
		System.out.println(ft1.isDone());
		/* This is a blocking call. */
		Boolean result = ft2.get();
		System.out.println("RESULT OF t2:" + result);
		System.out.println(ft2.isDone());
		System.out.println(ft3.isDone());
		executoprService.shutdown();

		System.out.println("Starting executor service 2...");
		// Another way of creating an executor service.
		ExecutorService executoprService2 = new ThreadPoolExecutor(2, 2, 10000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(15));
		executoprService2.submit(t1);
		/*
		 * When we shutdown the executor service after submitting a task and if
		 * the task is not finished or we submit a task to an executor after
		 * shutting it down, causes RejectedExecutionException.
		 */
		executoprService2.shutdownNow();
		executoprService2.submit(t2);
		executoprService2.submit(t3);

	}
}

class Thread_1 implements Callable<Boolean> {

	@Override
	public Boolean call() throws Exception {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("This thread is done..." + Thread.currentThread().getName());
		return Boolean.TRUE;
	}
}

package com.java.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

	public static void main(String[] args)
			throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		// CompletableFuture are better version of Futures, as the callable
		// methods can be chained as seen bellow.
		CompletableFuture cF = CompletableFuture.supplyAsync(() -> {
			return "CompletableFutures";
		});
		CompletableFuture result = cF.thenApply(name -> "Hello " + name);
		CompletableFuture stage2 = result
				.thenAccept(value -> System.out.println(value));
		stage2.thenRun(() -> System.out.println("Good to know"));
	}

}

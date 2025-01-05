package io.lab.imHarish03.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<Integer> demoFuture = service.submit(() -> {
			System.out.println("Async call waiting");
			Thread.sleep(10000);
			return 100;
		});

		System.out.println("Main Thread");

		System.out.println(demoFuture.get());
	}

}

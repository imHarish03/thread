package io.lab.imHarish03.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.execute(new Runnable() {
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " executing the task");
			}
		});

		executorService.shutdown();

		ExecutorService executorService2 = Executors.newFixedThreadPool(3);

		Callable<String> task1 = () -> {
			String threadName = Thread.currentThread().getName();
			return threadName + " executing Task 31";
		};

		Callable<String> task2 = () -> {
			String threadName = Thread.currentThread().getName();
			return threadName + " executing Task 32";
		};

		Callable<String> task3 = () -> {
			String threadName = Thread.currentThread().getName();
			return threadName + " executing Task 33";
		};

		Future<String> future1 = executorService2.submit(task1);
		Future<String> future2 = executorService2.submit(task2);
		Future<String> future3 = executorService2.submit(task3);

		System.out.println(future1.get());
		System.out.println(future2.get());
		System.out.println(future3.get());

		executorService2.shutdown();

	}

}

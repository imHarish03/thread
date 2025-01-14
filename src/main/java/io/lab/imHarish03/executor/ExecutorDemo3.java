package io.lab.imHarish03.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Callable<String> task1 = () -> {
			String threadName = Thread.currentThread().getName();
			return threadName + " executing Task 1";
		};

		Callable<String> task2 = () -> {
			String threadName = Thread.currentThread().getName();
			return threadName + " executing Task 2";
		};

		Callable<String> task3 = () -> {
			String threadName = Thread.currentThread().getName();
			return threadName + " executing Task 3";
		};

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(task1);
		callableTasks.add(task2);
		callableTasks.add(task3);

		List<Future<String>> futures = executorService.invokeAll(callableTasks);

		for (Future<String> future : futures) {
			System.out.println(future.get());
		}

		executorService.shutdown();

	}
}

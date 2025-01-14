package io.lab.imHarish03.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService3 = Executors.newFixedThreadPool(3);

		Callable<String> task31 = () -> {
			String threadName = Thread.currentThread().getName();
			return threadName + " executing Task 1";
		};

		Callable<String> task32 = () -> {
			String threadName = Thread.currentThread().getName();
			return threadName + " executing Task 2";
		};

		Callable<String> task33 = () -> {
			String threadName = Thread.currentThread().getName();
			return threadName + " executing Task 3";
		};

		List<Callable<String>> callableTasks3 = new ArrayList<>();
		callableTasks3.add(task31);
		callableTasks3.add(task32);
		callableTasks3.add(task33);

		String result3 = executorService3.invokeAny(callableTasks3);

		System.out.println(result3);

		executorService3.shutdown();
	}

}

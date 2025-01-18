package io.lab.imHarish03.fork.join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciForkJoin {
	// RecursiveTask to calculate Fibonacci numbers
	static class FibonacciTask extends RecursiveTask<Integer> {
		private final int n;

		public FibonacciTask(int n) {
			this.n = n;
		}

		@Override
		protected Integer compute() {
			// Base cases
			if (n <= 1) {
				return n;
			}

			// Recursive division of tasks
			FibonacciTask task1 = new FibonacciTask(n - 1);
			FibonacciTask task2 = new FibonacciTask(n - 2);

			// Fork the first task
			task1.fork();

			// Compute the second task directly (to avoid extra overhead)
			int result2 = task2.compute();

			// Join the result of the first task
			int result1 = task1.join();

			return result1 + result2;
		}
	}

	public static void main(String[] args) {
		int n = 10; // Fibonacci number to calculate

		// Create a ForkJoinPool to execute the task
		ForkJoinPool pool = new ForkJoinPool();

		// Create the Fibonacci task
		FibonacciTask task = new FibonacciTask(n);

		// Submit the task to the pool and get the result
		int result = pool.invoke(task);

		// Print the result
		System.out.println("Fibonacci(" + n + ") = " + result);

		// Shutdown the pool
		pool.shutdown();
	}
}

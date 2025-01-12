package io.lab.imHarish03.practice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Practice_01_CompletableFeature {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*
		 * Creating a CompletableFuture: Write a program to create a CompletableFuture
		 * that returns a string after a delay of 3 seconds.
		 */

		CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hari";
		});
		System.out.println("Result for 1: " + stringCompletableFuture.get());

		/*
		 * Using thenApply: Create a CompletableFuture that multiplies a number by 2 and
		 * uses thenApply to add 5 to the result.
		 */

		int num = 5;
		CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return num * 2;
		}).thenApply((result) -> {
			return result + 5;
		});
		System.out.println("Result for 2: " + integerCompletableFuture.get());

		/*
		 * Chaining multiple stages: Chain three asynchronous stages where each stage
		 * performs a mathematical operation (e.g., addition, multiplication, and
		 * subtraction) on an input number.
		 */

		CompletableFuture<Integer> chianMultipleCompletableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return num * 2;
		}).thenApply((result) -> {
			return result + 5;
		}).thenApply((result) -> {
			return result - 2;
		});

		System.out.println("Result for 3: " + chianMultipleCompletableFuture.get());

		/*
		 * Combining two CompletableFutures: Combine two CompletableFutures that return
		 * numbers and compute their sum.
		 */

		CompletableFuture<Integer> demo1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 2; // First CompletableFuture returns 2
		});

		CompletableFuture<Integer> demo2 = CompletableFuture.supplyAsync(() -> {
			return 3; // Second CompletableFuture returns 3
		});

		// Combine the results of demo1 and demo2
		CompletableFuture<Integer> combined = demo1.thenCombine(demo2, (result1, result2) -> result1 + result2);
		System.out.println("Result for 4: " + combined.get());

		CompletableFuture<Integer> demo3 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 2; // First CompletableFuture returns 2
		}).thenCompose(result -> CompletableFuture.supplyAsync(() -> {
			return 4 + result;
		}));

		System.out.println("Result for 5: " + demo3.get());

		/*
		 * Using thenAccept: Create a CompletableFuture that calculates the factorial of
		 * a number and prints the result using thenAccept.
		 */
		int number = 5;

		CompletableFuture.supplyAsync(() -> calculateFactorial(number))
				.thenAccept(result -> System.out.println("Factorial of " + number + ": " + result)).join(); // Ensures
																											// the main
																											// thread
																											// waits for
																											// the
																											// CompletableFuture
																											// to
																											// complete

		System.out.println("Demo");

	}

	private static int calculateFactorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

}

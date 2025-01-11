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
		System.out.println(stringCompletableFuture.get());

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
		System.out.println(integerCompletableFuture.get());

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
		}).thenApply((result)->{
			return result-2;
		});
		
		System.out.println(chianMultipleCompletableFuture.get());
		
		/*
		 * Using thenAccept: Create a CompletableFuture that calculates the factorial of
		 * a number and prints the result using thenAccept.
		 */
		
		
		
	}

}

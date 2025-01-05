package io.lab.imHarish03.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StepThreeSolution {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<Integer> squeareCompletableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Calculating the sum of even numbers ...");
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				if (i % 2 == 0) {
					sum += i;
				}
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Finished calculating the sum of even numbers");
			return sum;
		}).thenCompose((result) -> CompletableFuture.supplyAsync(() -> {
			// Adding bonus points
			System.out.println("Calculating squares");
			return result * result;
		}));

		System.out.println(squeareCompletableFuture.get());
	}

}

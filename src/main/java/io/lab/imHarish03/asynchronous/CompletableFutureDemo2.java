package io.lab.imHarish03.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Accessing customer loyalty points data over the network...");
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return 200;
		}).thenCompose((result) -> CompletableFuture.supplyAsync(() -> {
			// Adding bonus points
			int totalPoints = result;
			if (result >= 10 && result <= 100) {
				totalPoints += 10;
			} else if (result >= 101 && result <= 200) {
				totalPoints += 20;
			}
			return totalPoints;
		}));

		future.complete(150);
		System.out.println("Total points " + future.get());

	}

}

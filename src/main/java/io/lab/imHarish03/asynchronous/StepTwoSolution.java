package io.lab.imHarish03.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StepTwoSolution {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
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
		});

		CompletableFuture<String> futureWithCallback = future.thenApply(result -> {
			String inBinary = Integer.toBinaryString(result);
			return inBinary;
		});

		System.out.println("Sum of even numbers in binary: " + futureWithCallback.get());

	}

}

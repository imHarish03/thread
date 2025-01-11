package io.lab.imHarish03.asynchronous;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChainingExample {

	public static void main(String[] args) {
		
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching initial number...");
            return 10; // Task returns 10
        })
        // Use thenApply to transform the result
        .thenApply(result -> {
            System.out.println("Transforming result (thenApply)...");
            return result * 2; // Multiply by 2 (20)
        })
        // Use thenCompose to chain a dependent CompletableFuture
        .thenCompose(result -> {
            System.out.println("Chaining dependent task (thenCompose)...");
            return CompletableFuture.supplyAsync(() -> result + 5); // Add 5 (25)
        })
        // Combine the result with another independent CompletableFuture
        .thenCombine(
            CompletableFuture.supplyAsync(() -> {
                System.out.println("Fetching another number (thenCombine)...");
                return 15; // Another task returns 15
            }),
            (result1, result2) -> {
                System.out.println("Combining results (thenCombine)...");
                return result1 + result2; // Combine 25 + 15 (40)
            }
        );

        // Print the final result
        future.thenAccept(result -> System.out.println("Final Result: " + result));

        // Ensure the main thread waits for async tasks to complete
        try {
            Thread.sleep(2000); // Wait for async tasks to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // thenApply   -> Transform & return proper type
        // thenCompose -> Result will be CompletableFuture
        // thenAccept  -> returns nothing 
		
	}
}

package io.lab.imHarish03.asynchronous;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StepOneSolution {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		  // Task 01
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.nanoTime();
        Future<Integer> future1 = executorService.submit(new SumOfEvenTask());
        Future<Integer> future2 = executorService.submit(new SumOfSquaresTask());

        if (!future1.isDone() && !future2.isDone()) {
            System.out.println("Sum of Even Numbers: " + future1.get());
            System.out.println("Sum of Squares: " + future2.get());
        }

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Both tasks finished in " + (elapsedTime/1000000)/1000 + " seconds");

        executorService.shutdown();
	}

}

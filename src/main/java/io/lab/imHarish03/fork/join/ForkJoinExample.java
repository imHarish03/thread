package io.lab.imHarish03.fork.join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
	static int count=0;
	
	 // RecursiveTask to calculate sum
    static class SumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 1000; // Threshold for dividing tasks
        private long[] array;
        private int start;
        private int end;
        

        public SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
        	count++;
        	System.out.println("Computing Tasks: "+count);
        	
            // If the task is small enough, process it directly
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Divide the task into two smaller tasks
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                // Fork the tasks and wait for results
                leftTask.fork();
                rightTask.fork();

                // Join the results from the sub-tasks
                long leftResult = leftTask.join();
                long rightResult = rightTask.join();

                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        long[] array = new long[10000]; // Array with 10,000 elements

        // Fill the array with values
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // ForkJoinPool to manage the parallel tasks
        ForkJoinPool pool = new ForkJoinPool();

        // Create the sum task and submit it to the pool
        SumTask task = new SumTask(array, 0, array.length);
        System.out.println("Task Created");
        
        long result = pool.invoke(task);

        // Print the result
        System.out.println("Sum of the array: " + result);
        System.out.println("Counter: " + count);

        // Shutdown the pool
        pool.shutdown();
    }
}

package io.lab.imHarish03.synchronization;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		MyRunnable myRunnable = new MyRunnable();
		// MyRunnable myRunnablew = new MyRunnable();

		Thread thread1 = new Thread(myRunnable, "Thread1");
		Thread thread2 = new Thread(myRunnable, "Thread2");

		thread1.start();
		thread2.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Final value of counter is: " + myRunnable.getCounter());
	}

}

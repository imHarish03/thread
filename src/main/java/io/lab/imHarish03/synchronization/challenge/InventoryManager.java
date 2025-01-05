package io.lab.imHarish03.synchronization.challenge;

public class InventoryManager implements Runnable {
	private int itemCount = 200000;

	public int getItemCount() {
		return itemCount;
	}

	@Override
	public void run() {
		String function = Thread.currentThread().getName();

		if (function.equals("issue")) {

			synchronized (this) {
				for (int i = 0; i < 100000; i++) {
					itemCount--;
				}
			}
		} else if (function.equals("receive")) {
			synchronized (this) {
				for (int i = 0; i < 100000; i++) {
					itemCount++;
				}
			}
		}
	}
}

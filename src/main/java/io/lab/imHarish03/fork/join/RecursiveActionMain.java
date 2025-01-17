package io.lab.imHarish03.fork.join;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class RecursiveActionMain {

	public static void main(String[] args) {

		Random random = new Random();
		List<Long> data = random.longs(11, 1, 5).boxed().collect(Collectors.toList());

		ForkJoinPool pool = new ForkJoinPool();
		SumListAction task = new SumListAction(data);
		
		pool.invoke(task);

	}

}

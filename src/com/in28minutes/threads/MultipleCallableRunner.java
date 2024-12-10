package com.in28minutes.threads;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		List<CallableTask> tasks = List.of(new CallableTask("Namo"), new CallableTask("Tasmia"),
				new CallableTask("Tahmid"));

		List<Future<String>> results = executorService.invokeAll(tasks);

		for (Future<String> result : results) {
			System.out.println(result.get());
		}

		executorService.shutdown();
	}

}

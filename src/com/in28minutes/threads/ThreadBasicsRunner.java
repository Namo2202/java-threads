package com.in28minutes.threads;

class Task1 extends Thread {
	public void run() { // SIGNATURE
		System.out.println("\nTask1 Started");
		for (int i = 101; i <= 199; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\nTask1 Done");
	}
}

class Task2 implements Runnable {

	@Override
	public void run() {
		System.out.println("\nTask2 Started");
		for (int i = 201; i <= 299; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\nTask2 Done");
	}

}

public class ThreadBasicsRunner {

	public static void main(String[] args) throws InterruptedException {

		// states
		// - NEW
		// - RUNNABLE
		// - RUNNING
		// - BLOCKED/WAITING
		// - TERMINATED/DEAD

		// Task 1
		System.out.print("\nTask1 Kicked off");
		Task1 task1 = new Task1();
		task1.setPriority(1);
		task1.start(); // task1.run()

		// Task 2
		System.out.print("\nTask2 Kicked off");
		Task2 task2 = new Task2();
		Thread task2thread = new Thread(task2);
		task1.setPriority(10);
		task2thread.start();

		// wait for task1 and task2 to complete
		task1.join();
		task2thread.join();

		// Task 3
		System.out.print("\nTask3 Kicked off");
		for (int i = 301; i <= 399; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\nTask3 Done");
	}

}

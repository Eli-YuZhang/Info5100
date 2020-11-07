package assignment7;

import java.util.*;

public class SumValue {

	/* generate array of random numbers */
	static void generateRandomArray(int[] arr) {
		Random r = new Random();
		for (int i = 0; i < arr.length; i++)
			arr[i] = r.nextInt();
		// If r.nextInt(11), then sum of 4m numbers is always near 20m (= 4m * (10/2))
		// Proof that Random in Java is pseudo-random (Some thoughts)
	}

	/* get sum of an array using 4 threads */
	static long sum(int[] arr) {

		int numofthreads = 4;

		// A collection to store threads
		ArrayList<subThreadSum> list = new ArrayList<>();

		for (int i = 0; i < numofthreads; i++) {
			subThreadSum thread = new subThreadSum(i * (arr.length / numofthreads),
					(i + 1) * (arr.length / numofthreads), arr);
			list.add(thread);
			thread.start();
		}

		// .join() the sub threads into the main thread, to ensure that main is executed
		// AFTER each threads are done.
		// handle interrupted threads
		for (int i = 0; i < numofthreads; i++) {
			try {
				list.get(i).join();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		//Sum up all threads
		long sum = 0;
		for (int i = 0; i < numofthreads; i++) {
			sum += list.get(i).getSum();
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] arr = new int[4000000];
		generateRandomArray(arr);
		long sum = sum(arr);
		System.out.println("Sum: " + sum);
	}
}

class subThreadSum extends Thread {
	private int start;
	private int end;
	private long sum = 0;
	private int[] arr;

	public subThreadSum(int startIndex, int endIndex, int[] arr) {
		start = startIndex;
		end = endIndex;
		this.arr = arr;
	}

	public long getSum() {
		return sum;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			sum += arr[i];
		}
		System.out.println(Thread.currentThread().getName() + "'s sum is: " + sum);
	}
}

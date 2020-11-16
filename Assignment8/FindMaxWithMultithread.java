package assignment8;

//Give a very large array of integers, find the maximum value within the array using multithreading.

import java.util.*;

public class FindMaxWithMultithread {
	
	/* generate array of random numbers */
	public static int[] generateRandomarray(int[] array) {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(1000000);
		}
		return array;
	}

	/* get sum of an array using 4 threads */
	public static int findMax(int[] array) {
	    int numOfThreads = 4;
		int max = 0;
		// A collection to store threads
		ArrayList<FindMax> list = new ArrayList<FindMax>();
		try {
			for (int i = 0; i < numOfThreads; i++) {
				FindMax fm = new FindMax(i * (array.length / numOfThreads), (i + 1) * (array.length / numOfThreads), array);
				fm.start();
				list.add(fm);
			}
			// .join() the sub threads into the main thread
			// handle interrupted threads
			for (int i = 0; i < list.size(); i++) {
				list.get(i).join();
			}
			//Get max of each threads
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getMax() > max) {
					max = list.get(i).getMax();
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println("Max value is: " + findMax(generateRandomarray(new int[400000])));
	}
}

class FindMax extends Thread {

	private int start;
	private int end;
	private int max = 0;
	private int[] array;

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public FindMax(int startIndex, int endIndex, int[] array) {
		start = startIndex;
		end = endIndex;
		this.array = array;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
	}
}

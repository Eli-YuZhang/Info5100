package Assignment4;

//Test case for KthLargestElement.java

//"Implement the test cases in class Test's main method."

public class Test {
	public static void main(String[] args) {
		KthLargestElement obj = new KthLargestElement();

		int[] array = { 3, 2, 1, 5, 6, 1, 4, 3, 3 };
		int k = 2;

		System.out.println(obj.kthLargest(array, k));
	}
}

package assignment7;

public class ReverseHello implements Runnable {

	private int num;
	
	//if (i = num), then all output in Console is 0
	public ReverseHello(int i) {
		num = i;
	}

	@Override
	public void run() {
		System.out.println("Hello from Thread " + num + "!");
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 50; i > 0; i--) {
			Thread t = new Thread(new ReverseHello(i));
			t.start();
			t.join();
		}

	}
}

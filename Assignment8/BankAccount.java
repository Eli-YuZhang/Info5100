package assignment8;

import java.util.Random;

/*1.Write a BankAccount class which implements:
 *a.deposit(int amount)
 *b.withdraw(int amount)
 *c.getBalance()
 */

public class BankAccount {

	private final Object lock = new Object();
	private double balance;

	public BankAccount() {
		this.balance = 0;
	}

	public void deposit(int amount) throws InterruptedException {
		synchronized (lock) {
			balance += amount;
			System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", the current balance is " + balance);
		}
	}

	public void withdraw(int amount) throws InterruptedException {
		synchronized (lock) {
			if (balance < amount) {
				System.out.println("Withdraw failed, not enough balance avliable");
			} else {
				balance -= amount;
				System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", the current balance is " + balance);
			}
		}
	}

	public double getBalance() throws InterruptedException {
		synchronized (lock) {
			return balance;
		}
	}

	public class Depositor extends Thread {
		Random random = new Random();
		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				int amount = random.nextInt(100);
				try {
					deposit(amount);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// withdraw money
	class Withdrawer extends Thread {
		Random random = new Random();
		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				int amount = random.nextInt(3);
				try {
					withdraw(amount);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 2.Write a main function to simulate the bank system. Use multi threading to randomly deposit or withdraw random amount
	public static void main(String[] args) throws InterruptedException {
		BankAccount bankAccount = new BankAccount();
		Depositor d = bankAccount.new Depositor();
		Withdrawer w = bankAccount.new Withdrawer();

		Thread[] t = new Thread[10];

		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				t[i] = new Thread(d);
			} else {
				t[i] = new Thread(w);
			}
		}

		for (int i = 0; i < 4; i++) {
			t[i].start();
		}

		for (int i = 0; i < 4; i++) {
			t[i].join();
		}
	}
}

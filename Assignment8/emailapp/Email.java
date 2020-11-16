package emailapp;

import java.security.SecureRandom;
import java.util.Scanner;

public class Email {

	private String firstName, lastName;
	private String department;
	private String email;
	private String alternateEmail;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String companySuffix = "aeycompany.com";
	private String password;
	private String randomPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";

	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Ask for the department
	private String SetDepartment() {
		System.out.println("1 For Sales\n" + 
					"2 For Development\n" + 
					"3 For Accounting\n" + 
					"0 For none\n" + 
					"Enter department code:");
		Scanner scan = new Scanner(System.in);
		int depCode = scan.nextInt();
		if (depCode == 1) {
			return department = "sales";
		} else if (depCode == 2) {
			return department = "dev";
		} else if (depCode == 3) {
			return department = "accounting";
		} else {
			return department = "";
		}
	}

	private String getDepartment() {
		return this.department;
	}

	// Generate a random password
	private String randomPassword(int length) {
		SecureRandom sr = new SecureRandom();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < defaultPasswordLength; i++) {
			int randIndex = sr.nextInt(randomPassword.length());
			sb.append(randomPassword.charAt(randIndex));
		}
		return sb.toString();
	}

	// Setters to change the password, set mailbox capacity, define an alternate
	// email address
	public void setChangePassword(String password) {
		this.password = password;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public void setMailCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}

	// Getters to display the name, email and mailbox capacity
	public String getName() {
		return firstName + " " + lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getMailCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getChangePassword() {
		return password;
	}

	public String showInfo() {
		System.out.println("New Worker: " + this.firstName + " " + this.lastName + ". " + "Department Codes:");
		SetDepartment();
		System.out.println("DISPLAY NAME: " + this.firstName + " " + this.lastName);
		System.out.println("DEPARTMENT: " + getDepartment());
		if (getDepartment() == "") {
			System.out.println("COMPANY EMAIL: " + this.firstName.toLowerCase() + "." + this.lastName.toLowerCase()
					+ "@" + getDepartment() + companySuffix);
		} else {
			System.out.println("COMPANY EMAIL: " + this.firstName.toLowerCase() + "." + this.lastName.toLowerCase()
					+ "@" + getDepartment() + "." + companySuffix);
		}
		System.out.println("PASSWORD: " + randomPassword(defaultPasswordLength));
		System.out.println("MAILBOX CAPACITY: " + mailboxCapacity + "mb");
		return "";
	}
}
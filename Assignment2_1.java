/**
 * The deadline of this assignment is 09/25/2020 23:59 PST. Please feel free to
 * contact Yafei and Yaqi for any questions.
 */

class Employee {
	String name;
	int age;
	Gender gender;
	double salary;// salary per month

	// Constructor. Please set all the data in constructor.
	public Employee(String name, int age, Gender gender, double salary) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}

	// Getter for `name`. Return the current `name` data
	public String getName() {
		return this.name;
	}

	// Setter for `name`. Set `name` data
	public void setName(String name) {
		this.name = name;
	}
	
	public void raiseSalary(double byPercent) {
		this.salary = this.salary * (100.0 + byPercent / 100.0);
	}
}

enum Gender {
	MALE, FEMALE;
}

public class Assignment2_1 {
	// Assignment

	/**
	 * Write a method to calculate the Social Security Tax of an employee and print
	 * it. If the salary is less than or equal to 8900, the Social Security Tax is
	 * 6.2% of the salary. If the salary is more than 8900, the Social Security Tax
	 * is 6.2% of 106,800.
	 */
	public double socialSecurityTax(Employee employee) {
		double sst = employee.salary <= 8900 ? 0.062 * employee.salary : 0.062 * 106800;
		System.out.println("This employee's Social Security Tax is" + sst);
		return sst;
	}

	/**
	 * Write a method to calculate an employee's contribution for insurance coverage
	 * and print it. Amount of deduction is computed as follows: If the employee is
	 * under 35, rate is 3% of salary; if the employee is between 35 and
	 * 50(inclusive), rate is 4% of salary; If the employee is between 50 and
	 * 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6%
	 * of salary.
	 */
	public double insuranceCoverage(Employee employee) {
		double cfic = 0;
		int age = employee.age;
		double salary = employee.salary;

		if (age < 35) {
			cfic = salary * 0.03;
		} else if (35 <= age || age <= 50) {
			cfic = salary * 0.04;
		} else if (50 < age || age < 60) {
			cfic = salary * 0.05;
		} else {
			cfic = salary * 0.06;
		}
		System.out.println("This employee's contribution for insurance coverage" + cfic);
		return cfic;
	}

	/**
	 * Write a method to sort three employees' salary from low to high, and then
	 * print their name in order. For example, Alice's salary is 1000, John's salary
	 * is 500, Jenny's salary is 1200, you should print: John Alice Jenny
	 */
	public void sortSalary(Employee e1, Employee e2, Employee e3) {
		// Assumption : Employees don't have the same salaries

		/*
		 * I do saw the methods we discussed in Wechat group and I have tested them
		 * myself in IDE, but I am still trying to understand Comparable and Comparators
		 * so I am using my old dumb method here
		 */

		String n1 = e1.getName();
		String n2 = e2.getName();
		String n3 = e3.getName();
		String nameList;
		if (e1.salary < e2.salary) {
			if (e1.salary < e3.salary) {
				nameList = n1 + n3 + n2;
			} else {
				if (e2.salary < e3.salary) {
					nameList = n1 + n2 + n3;
				} else {
					nameList = n3 + n1 + n2;
				}
			}
		} else {
			if (e3.salary < e2.salary) {
				nameList = n3 + n2 + n1;
			} else {
				if (e1.salary < e3.salary) {
					nameList = n2 + n1 + n3;
				} else {
					nameList = n2 + n3 + n1;
				}
			}
		}
		System.out.println(nameList);
	}

	/**
	 * Write a method to raise an employee's salary to three times of his/her
	 * original salary. Eg: original salary was 1000/month. After using this method,
	 * the salary is 3000/month. Do not change the input of this method. Try to add
	 * a new method in Employee class: public void raiseSalary(double byPercent)
	 */
	public void tripleSalary(Employee employee) {
		employee.raiseSalary(200.0);
		// salary * 3 = raise salary by 200%
	}

	// Extra credit

	/**
	 * I have written some code below. What I want is to swap two Employee objects.
	 * One is Jenny and one is John. But after running it, I got the result below:
	 * Before: a=Jenny Before: b=John After: a=Jenny After: b=John There is no
	 * change after swap()! Do you know the reason why my swap failed? Write your
	 * understanding of the reason and explain it.
	 */
	/*
	 * Explanation: Employee here is a reference type. In the main method, variable
	 * a and b are references pointing to Jenny and John and their information.
	 * According to parameter passing mechanics in Java, the reference types will
	 * only pass on their address of reference. In this situation, x is the copy of
	 * a's address, y is the copy of b's address, thus, the swap method only make x
	 * and y point to each other's object, but won't effect a and b.
	 */
	public static void main(String[] args) {
		Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
		Employee b = new Employee("John", 30, Gender.MALE, 2500);
		System.out.println("Before: a=" + a.getName());
		System.out.println("Before: b=" + b.getName());
		swap(a, b);
		System.out.println("After: a=" + a.getName());
		System.out.println("After: b=" + b.getName());
	}

	public static void swap(Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
	}
}
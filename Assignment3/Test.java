package Assignment3;

public class Test {
	public static void main(String[] args) {
		Student a = new Student("Audi", 2001);
		Student b = new Student("BMW", 2002);
		Student c = new Student("Cadillac", 2003);
		Student d = new Student("Dodge", 2004);
		Student e = new Student("Ford", 2005);
		Student f = new Student("Ferrari", 2006);
		Student g = new Student("GM", 2007);
		Student h = new Student("Hummer", 2008);
		Student i = new Student("Jagura", 2009);
		Student j = new Student("KTM", 2010);
		Student k = new Student("Lexus", 2011);
		
		Course info5100 = new Course("Info5100");
		info5100.registerStudent(a);
		info5100.registerStudent(b);
		info5100.registerStudent(c);
		info5100.registerStudent(d);
		info5100.registerStudent(e);
		info5100.registerStudent(f);
		info5100.registerStudent(g);
		info5100.registerStudent(h);
		info5100.registerStudent(i);
		info5100.registerStudent(j);
		info5100.registerStudent(k); // N0.11, test isFull()
		
		System.out.print("Students registered for Info5100 course are: ");
        for (int helper = 0; helper < info5100.getNumberOfStudent(); helper++) {
            System.out.print(info5100.getStudents()[helper].getName() + ", ");
        }
	}
}

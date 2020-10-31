package assignment6;

public class Test {
	public static void main(String[] args) {
		Cat c = new Cat("Tom", "ELi", "Gray", "Short");
		c.setBoardStart(10, 16, 2020);
		c.setBoardEnd(10, 30, 2020);
		System.out.println(c.toString());
		System.out.println(c.boarding(10, 17, 2020));
		System.out.println(c.boarding(3, 22, 2000));
		
		System.out.println("\n --------------\n");

		Dog d = new Dog("Dog", "Owner", "White", "Small");
		d.setSex(1);
		System.out.println(d.toString());
	}

}

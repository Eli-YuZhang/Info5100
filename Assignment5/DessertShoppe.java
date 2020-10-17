package assignment5;

public class DessertShoppe {
	public static final double TAX_RATE = 0.065;
	public static final String STORE_NAME = "M & M Dessert Shoppe";
	public static final int MAX_NAMESIZE = 30;
	public static final int MAX_WIDTH = 5;
	
	public DessertShoppe() {
	
	}
	
	public static String cents2dollarsAndCents(int cents) {
		return (cents * 0.01) + "";
	}
}


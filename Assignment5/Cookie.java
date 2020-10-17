package assignment5;

public class Cookie extends DessertItem {
	private int number;
	private double pricePerDozen;

	public Cookie(String name, int number, double pricePerDozen) {
		super(name);
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}

	@Override
	public int getCost() {
		return (int) Math.round(number * pricePerDozen / 12);
	}

	public int getNumber() {
		return number;
	}

	public double getPricePerDozen() {
		return pricePerDozen;
	}
}

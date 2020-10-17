package assignment5;

public class Sundae extends IceCream {
	private String sundaeName;
	private double toppingCost;

	public Sundae(String name, double cost, String sundaeName, double toppingCost) {
		super(name, cost);
		this.sundaeName = sundaeName;
		this.toppingCost = toppingCost;
	}

	@Override
	public int getCost() {
		return (int) Math.round(super.getCost() + toppingCost);
	}

	public String getSundaeName() {
		return sundaeName;
	}

	public double getToppingCost() {
		return toppingCost;
	}
}

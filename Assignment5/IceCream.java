package assignment5;

public class IceCream extends DessertItem{
	private double cost;
	
	public IceCream(String name, double cost) {
		super(name);
		this.cost = cost;
	}

	@Override
	public int getCost() {
		return (int)Math.round(cost);
	}
	
}

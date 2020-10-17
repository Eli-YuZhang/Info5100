package assignment5;

public class Candy extends DessertItem{
	private double weight;
	private double pricePerLb;
	
	public Candy() {
	}
	
	public Candy(String name, double weight, double pricePerLb) {
		super(name);
		this.weight = weight;
		this.pricePerLb = pricePerLb;
	}

	@Override
	public int getCost() {
		return (int)Math.round(weight * pricePerLb);
	}
	
	public double getWeight(){
		return this.weight;
	}
	
	public double getPricePerLb(){
		return this.pricePerLb;
	}
}

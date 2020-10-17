package assignment5;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
	
	private List<DessertItem> list;

	public Checkout() {
		this.list = new ArrayList<>();
	}

	public void enterItem(DessertItem item) {
		list.add(item);
	}

	public int numberOfItems() {
		return list.size();
	}
	
	public void clear() {
		list.clear();
	}

	public int totalCost() {
		// Tax not included
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).getCost();
		}

		return sum;
	}

	public int totalTax() {
		return (int) Math.round(totalCost() * DessertShoppe.TAX_RATE);
	}

	@Override
	public java.lang.String toString() {

		StringBuilder sb = new StringBuilder();

		System.out.println(DessertShoppe.STORE_NAME);
		System.out.println("--------------------");

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i) instanceof Candy) {
				sb.append("\n" + ((Candy) list.get(i)).getWeight() + " lbs. @ " + ((Candy) list.get(i)).getPricePerLb()*0.01 + " /lb.");

			} else if (list.get(i) instanceof Cookie) {
				sb.append("\n" + ((Cookie) list.get(i)).getNumber() + " @ " + ((Cookie) list.get(i)).getPricePerDozen()*0.01 + " /dz.");

			} else if (list.get(i) instanceof Sundae) {
				sb.append("\n" + ((Sundae) list.get(i)).getSundaeName() + " Sundae with");
			}

			sb.append("\n" + list.get(i).getName() + " " + DessertShoppe.cents2dollarsAndCents(list.get(i).getCost()));
			// "\t" + getCost() to display cost on the right
		}

		// Tax
		sb.append("\nTax " + DessertShoppe.cents2dollarsAndCents(totalTax()));

		// Total
		sb.append("\nTotal cost " + DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax()));

		return sb.toString();
	}
}

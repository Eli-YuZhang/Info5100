package assignment6;

import java.util.Date;

// switch to Calendar in later versions
@SuppressWarnings("deprecation")

public class Dog extends Pet implements Boardable {
	private Date boardStart;
	private Date boardEnd;
	private String size;

	public Dog(String name, String ownerName, String color, String size) {
		super(name, ownerName, color);
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "DOG:\n" + super.toString() + "Size: " + this.getSize() + "\n";
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		if (dateValidate(month, day, year)) {
			boardStart = new Date(year, month, day);
		}
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		if (dateValidate(month, day, year)) {
			boardEnd = new Date(year, month, day);
		}
	}

	@Override
	public boolean boarding(int month, int day, int year) {
		if (dateValidate(month, day, year)) {
			Date curDate = new Date(year, month, day);
			return (boardStart.compareTo(curDate) <= 0) && (boardEnd.compareTo(curDate) >= 0);
		}
		return false;
	}
}
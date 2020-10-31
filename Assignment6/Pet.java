package assignment6;

public class Pet {
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	public static final int SPAYED = 2;
	public static final int NEUTERED = 3;
	private String petName;
	private String ownerName;
	private String color;
	protected int sex;

	private String[] sexTypes = { "Male", "Female", "Spayed", "Neutered" };

	public Pet(String petName, String ownerName, String color) {
		this.petName = petName;
		this.ownerName = ownerName;
		this.color = color;
	}

	public String getPetName() {
		return petName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getColor() {
		return color;
	}

	public String getSex() {
		return sexTypes[sex];
	}

	public void setSex(int sexid) {
		sex = sexid;
	}

	@Override
	public String toString() {
		return this.petName + " owned by " + this.ownerName + "\nColor: " + this.color + "\nSex: " + getSex() + "\n";
	}

	public boolean dateValidate(int month, int day, int year) {
		if (year < 1000 || year > 9999)
			return false;
		if (month < 1 || month > 12)
			return false;
		if (day <= 0 || day > 31)
			return false;
		return true;
	}
}

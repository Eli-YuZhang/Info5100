package Assignment3;

public class Professor {
	// required parameters
	private String firstName;
	private String lastName;
	private int id;

	// optional parameters
	private int officeRoomNumber;
	private String email;

	public Professor(String firstName, String lastName, int id, int officeRoomNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.officeRoomNumber = officeRoomNumber;
		this.email = email;
	}
	
	public String toString() {
		return "Name:" + this.firstName + " " + this.lastName + " ID: " + this.id + " Office Room: " + this.officeRoomNumber + " Email: " + this.email; 
	}

	public String getFirstName() {
		return firstName;
	}
 
	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}

	public int getOfficeRoomNumber() {
		return officeRoomNumber;
	}

	public String getEmail() {
		return email;
	}

	public static class Builder {
		// required parameters
		private String firstName;
		private String lastName;
		private int id;

		// optional parameters
		private int officeRoomNumber;
		private String email;

		public Builder(String firstName, String lastName, int id) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = id;
		}

		public Builder setId(int id) {
			this.id = id;
			return this;
		}

		public Builder setOfficeRoomNumber(int officeRoomNumber) {
			this.officeRoomNumber = officeRoomNumber;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Professor build() {
			return new Professor(firstName, lastName, id, officeRoomNumber, email);
		}
	}
}

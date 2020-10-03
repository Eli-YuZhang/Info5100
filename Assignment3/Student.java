package Assignment3;

public class Student {
	private String name;
	private int studentId;
	
	public Student(String name, int studentId) {
		this.name = name;
		this.studentId = studentId;
		System.out.println(name + ", Student ID :" + studentId);
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return studentId;
	}
	
	public void setId(int studentId) {
		this.studentId = studentId;
	}
	
}


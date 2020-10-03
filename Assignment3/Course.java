package Assignment3;

public class Course {
	//parameters
	private String name;
	private int numberOfStudent;
	private Student[] studentList = new Student[10];

	
	public Course (String name) {
		this.name = name;
		numberOfStudent = 0;
	}
	
	public String getCourseName(){
		return this.name;
	}
	
	public Student[] getStudents(){
		return this.studentList;
	}
	
	public int getNumberOfStudent() {
		return this.numberOfStudent;
	}
	
	public boolean isFull() {
		return this.numberOfStudent == 10;
	}
	
	
	public void registerStudent(Student student) {
		if(this.isFull()) {
			 System.out.println(student.getName() +" Registration failed. " + getCourseName() +" course is full");
		}
		else {
			this.studentList[numberOfStudent] = student;
			this.numberOfStudent++;
			System.out.println("Successfully registered!");
		}
	}
}

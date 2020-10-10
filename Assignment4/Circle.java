package Assignment4;

public class Circle {
	private double radius = 1.0;
	private String color = "red";

	// constructor

	public Circle() {

	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getArea() {
		return Math.PI * (radius * radius);
	}
	
	public void print() {
        System.out.println("Radius is " + this.radius + ", Color is " + 
        				this.color + ", Base area is " + this.getArea());
	}
}

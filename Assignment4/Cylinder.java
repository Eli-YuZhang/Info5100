package Assignment4;

public class Cylinder extends Circle {
	private double height = 1.0;

	// constructor
	public Cylinder() {
		// super();
	}

	public Cylinder(double height) {
		// super();
		this.height = height;
	}

	public Cylinder(double height, double radius) {
		super(radius);
		this.height = height;
	}

	public Cylinder(double height, double radius, String color) {
		super(radius, color);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getVolume() {
		return super.getArea() * this.height;
	}

	@Override
	// Surface area
	public double getArea() {
		return 2 * Math.PI * this.getRadius() * (this.getRadius() + this.getHeight());
	}

	@Override
	// Because the required output is Base area, so I implement super.getArea()here;
	// To print the Surface area as output, implement this.getArea() or getArea()
	public void print() {
		System.out.println("Radius is " + super.getRadius() + ", Height is " + this.getHeight() + ", Color is "
				+ super.getColor() + ", Base area is " + super.getArea() + ", Volume is " + this.getVolume());
	}
}

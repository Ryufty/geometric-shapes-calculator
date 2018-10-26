public class Triangle implements Shapes {
	private double side1;
	private double side2;
	private double base;
	
	public Triangle(double side1, double side2, double base) {
		setSide1(side1);
		setSide2(side2);
		setBase(base);
	}
	
	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) { // setters
		this.side1 = side1;
	}
	
	public double getSide2() {  // getters
		return side2;
	}

	public void setSide2(double side2) {  // setters
		this.side2 = side2;
	}
	
	public double getBase() {  // setters
		return base;
	}

	public void setBase(double base) {  // getters
		this.base = base;
	}
	
	@Override
	public String toString() {
		return new String("Triangle {s1=" + getSide1() + ", " +
				                   "s2=" + getSide2() + ", " +
				                   "s3=" + getBase() + "}" +
								   ", perimeter = " + perimeter());
	} 
	
	@Override
	public double perimeter() {
		return (getBase() +  getSide1() + getSide2());
	}
}

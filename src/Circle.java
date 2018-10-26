public class Circle implements Shapes {
	private double radio;
	
	public Circle(double radio) {
		setRadio(radio);
	}
	
	public void setRadio(double radio) {     // setter
		this.radio = radio;
	}
	
	public double getRadio(){	// getter
		return radio;
	}
	
	@Override
	public double perimeter(){
		return 2 * getRadio() * Math.PI;
	}
	
	Area circleArea = () -> Math.PI * getRadio() * getRadio();
	
	@Override
	public String toString() {
		return new String("Circle {r=" + getRadio() + "}" + ", perimeter = " + perimeter() +
						  "\n Circle Area: " + circleArea.getArea());
	}
	
}

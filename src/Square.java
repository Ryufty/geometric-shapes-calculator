public class Square extends Rectangle {  // subclass for rectangle
	public Square(double side){
		super(side, side);    // from super class constructor
	}
	
	Area squareArea = () -> getWidth() * getWidth();
	
	@Override
	public String toString() {    // from java library I think...
		return new String("Square {s=" + getWidth() + "}" + ", perimeter = " + perimeter() +
						  "\n Square Area: " + squareArea.getArea());
	} 
}

public class Rectangle extends Parallelogram {
	public Rectangle(double width, double height) {
		super (width, height);
	}
	
	Area rectangleArea = () -> getWidth() * getHeight();
	
	@Override
	public String toString() {
		return new String("Rectangle w={" + getWidth() + "}, " + "h={" + getHeight() + "}" + ", perimeter = " + perimeter() +
				          "\n Rectangle Area: " + rectangleArea.getArea());
	} 
	
}

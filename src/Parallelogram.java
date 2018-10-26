
public class Parallelogram implements Shapes {
	private double width;
	private double length;
	
	public Parallelogram(double width, double height) {
		setWidth(width);
		setHeight(height);
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return length;
	}

	public void setHeight(double height) {
		this.length = height;
	}
	
	@Override
	public double perimeter() {
		return (2 * (getWidth() + getHeight())); 
	}
	
	@Override
	public String toString() {
		return new String("Parallelogram {w=" + getWidth() + ", " +
				                   "h=" + getHeight() + "}" +				               
								   ", perimeter = " + perimeter());
	} 
}

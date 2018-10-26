import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
	static Shapes[] shapes;
	static {
		shapes = new Shapes[32];
	}
	
	public static void readFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String s;
			int count = 0;  // to count the good shapes
			
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
				
				for(int i = 0; i < tokens.length; i++) {
					switch(tokens[i]) {
					case "Circle":
						if (tokens.length == 2 && Double.parseDouble(tokens[1]) > 0) {
							shapes[count] = new Circle(Double.parseDouble(tokens[i + 1]));
							count++;
						} else {
							System.out.println("Invalid radius!");
						}
						break;
					case "Parallelogram":
						if (tokens.length == 3 && Double.parseDouble(tokens[1]) > 0 
											   && Double.parseDouble(tokens[2]) > 0) {
							shapes[count] = new Parallelogram(Double.parseDouble(tokens[i + 1]), 
									 						  Double.parseDouble(tokens[i + 2]));
							count++;
						}else {
							System.out.println("Invalid sides!");
						}
						break;
					case "Square": 
						if (tokens.length == 2 && Double.parseDouble(tokens[1]) > 0) {
							shapes[count] = new Square(Double.parseDouble(tokens[i + 1]));
							count++;
						}else {
							System.out.println("Invalid side!");
						}
						break;
					case "Triangle":
						if (tokens.length == 4 && (Double.parseDouble(tokens[1]) + Double.parseDouble(tokens[2])) > Double.parseDouble(tokens[3])
								&& (Double.parseDouble(tokens[2]) + Double.parseDouble(tokens[3])) > Double.parseDouble(tokens[1])
								&& (Double.parseDouble(tokens[1]) + Double.parseDouble(tokens[3])) > Double.parseDouble(tokens[2])
											   && Double.parseDouble(tokens[1]) > 0
											   && Double.parseDouble(tokens[2]) > 0
											   && Double.parseDouble(tokens[3]) > 0) {
							shapes[count] = new Triangle(Double.parseDouble(tokens[i + 1]), 
														 Double.parseDouble(tokens[i + 2]), 
														 Double.parseDouble(tokens[i + 3]));
							count++;
						} else {
							System.out.println("Invalid sides!");
						}
						break;
					case "Rectangle":
						if (tokens.length == 3 && Double.parseDouble(tokens[1]) > 0 
						   					   && Double.parseDouble(tokens[2]) > 0) {
							shapes[count] = new Rectangle(Double.parseDouble(tokens[i + 1]), Double.parseDouble(tokens[i + 2]));
							count++;
						} else {
							System.out.println("Invalid sides!");
						}
						break;
					default: 
						break;
					}
				}
			}
			
			for (Shapes shape : shapes) {
				System.out.println(shape.toString());
			}
			
			System.out.println(count);
			System.out.println("\n\n----------- task2 ------------\n");
			
			double maxCircle = 0;
			double minTriangle = 10000000;
			

			for (int j = 0; j < shapes.length; j++) {
				if (shapes[j] instanceof Circle) {
					if (shapes[j].perimeter() > maxCircle) {
						maxCircle = shapes[j].perimeter();
					}
				} 
				else if (shapes[j] instanceof Triangle) { 
					if (shapes[j].perimeter() < minTriangle) {
						minTriangle = shapes[j].perimeter();
					}
				}
			}
			
			for (int x = shapes.length - 1; x >= 0; x--) {
				if (shapes[x] instanceof Circle) {
					if (shapes[x].perimeter() < maxCircle) {
						System.out.println(shapes[x].toString());
					} else {
						for (int y = x; y < shapes.length - 1; y++){
							shapes[y] = shapes[y + 1];
						}
					}
				} 
				else if (shapes[x] instanceof Triangle) { 
					if (shapes[x].perimeter() > minTriangle) {
						System.out.println(shapes[x].toString());
					} else {
						for (int z = x; z < shapes.length - 1; z++){
							shapes[z] = shapes[z + 1];
							
						}
					}
				} else {
					System.out.println(shapes[x].toString());
				}
			}
			
			System.out.println("\n\n----------- task3 ------------\n");
			
			double totalParallelogram = 0;
			double totalTriangle = 0;
			
			for (int k = 0; k < shapes.length; k++) {
				if (shapes[k] instanceof Parallelogram) {
					totalParallelogram += shapes[k].perimeter();
				} 
				else if (shapes[k] instanceof Triangle) { 
					totalTriangle += shapes[k].perimeter();
				}
			}
			
			System.out.println("Total perimeter of Parallelogram is: " + totalParallelogram);
			System.out.println("Total perimeter of Triangle is: " + totalTriangle);
			
			System.out.println("\n\n----------- task4 ------------\n");
			
			for (int i = 0; i < shapes.length; i++) {
				if (shapes[i] instanceof Circle) {
					System.out.println(shapes[i].toString());
				}
				else if (shapes[i] instanceof Rectangle) {
					System.out.println(shapes[i].toString());
				}
				else if (shapes[i] instanceof Square) {
					System.out.println(shapes[i].toString());
				}
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		readFile("shapes.txt");
	}
}

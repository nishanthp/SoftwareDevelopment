package JavaPatterns;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory("Circle");
		Shape circle = factory.produceShape();
		circle.shape();
	}
}

class ShapeFactory {
	String shapeType;

	public ShapeFactory(String shapeTyp) {
		this.shapeType = shapeTyp;
	}

	public Shape produceShape() {
		if (this.shapeType == "Circle") {
			return new Circle();
		} else if (this.shapeType == "Square") {
			return new Square();
		} else if (this.shapeType == "Rectangle") {
			return new Rectangle();
		} else {
			return null;
		}

	}
}

interface Shape {
	public void shape();
}

class Circle implements Shape {

	@Override
	public void shape() {
		System.out.println("This is a circle.");

	}

}

class Rectangle implements Shape {

	@Override
	public void shape() {
		System.out.println("This is a rectangle.");

	}

}

class Square implements Shape {

	@Override
	public void shape() {
		System.out.println("This is a square.");

	}

}
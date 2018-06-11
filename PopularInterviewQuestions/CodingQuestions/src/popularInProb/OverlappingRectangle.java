package popularInProb;

public class OverlappingRectangle {
	public static void main(String[] args) {
		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);
		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 0);
		OverlappingRectangle rect = new OverlappingRectangle();
		System.out.println(rect.rectangleOverlap(l1, l2, r1, r2));
	}

	public Boolean rectangleOverlap(Point l1, Point l2, Point r1, Point r2) {
		if (l1.x > r2.x || l2.x > r1.x) {
			return false;
		}
		if (l1.y < r2.y || l2.y < r1.y) {
			return false;
		}
		return true;
	}

}

class Point {
	int x, y;

	public Point(int x_cor, int y_cor) {
		this.x = x_cor;
		this.y = y_cor;
	}
}

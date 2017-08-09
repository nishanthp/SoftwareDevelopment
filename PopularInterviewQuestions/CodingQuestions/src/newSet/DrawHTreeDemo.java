package newSet;

public class DrawHTreeDemo {
	public static void main(String[] args) {
		double length = 0;
		double depth = 0;
		double x_mid = 0;
		double y_mid = 0;
		drawHTree(x_mid, y_mid, depth, length);
	}

	private static void drawHTree(double x_mid, double y_mid, double depth, double length) {
		if (depth <= 0 || length <= 0) {
			return;
		}

		// draw horizontal line.
		drawLine(x_mid - length / 2, y_mid, x_mid + length / 2, y_mid);
		// draw the left horizontal line.
		drawLine(x_mid - length / 2, y_mid - length / 2, x_mid - length / 2, y_mid + length / 2);
		// draw the right horizontal line.
		drawLine(x_mid + length / 2, y_mid - length / 2, x_mid + length / 2, y_mid + length / 2);
		// draw the H at four corners of H at each depth.
		drawHTree(x_mid - length / 2, y_mid + length / 2, depth - 1, length / Math.sqrt(2));
		drawHTree(x_mid - length / 2, y_mid - length / 2, depth - 1, length / Math.sqrt(2));
		drawHTree(x_mid + length / 2, y_mid - length / 2, depth - 1, length / Math.sqrt(2));
		drawHTree(x_mid + length / 2, y_mid + length / 2, depth - 1, length / Math.sqrt(2));
	}

	private static void drawLine(double x, double y, double x1, double y1) {
		// TODO Method to draw the line with the above two end points.
	}

}

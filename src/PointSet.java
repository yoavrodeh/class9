import java.util.ArrayList;
import java.util.List;

public class PointSet {
	public static class Point {
		private int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() { return x; }
		public int getY() { return y; }
		public int dist(Point other) {
			return Math.abs(other.x - x)
					+ Math.abs(other.y - y);
		}
	}

	private List<Point> points;
	public PointSet(int size) {
		points = new ArrayList<>(size);
	}
	
	public void add(int x, int y) {
		points.add(new Point(x, y));
	}
	
	public int closestDist(Point p) {
		int minDist = -1;
		for (Point p2 : points) {
			int dist = p.dist(p2);
			if (minDist < 0 || dist < minDist)
				minDist = dist;
		}
		return minDist;
	}
}

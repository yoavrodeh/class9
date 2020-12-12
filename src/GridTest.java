import java.util.Random;

public class GridTest {
	public static Random rand = new Random();

	public static int oneTest(int size) {
		PointSet ps = new PointSet(size);
		for (int i = 0; i < size; i++)
			ps.add(rand.nextInt(size), rand.nextInt(size));
		PointSet.Point center = new PointSet.Point(
				size / 2, size / 2);
		return ps.closestDist(center);
	}

	public static void main(String[] args) {
		int sum = 0;
		int numTests = 1000000;
		for (int i = 0; i < numTests; i++)
			sum += oneTest(100);
		System.out.println((double)sum / numTests);
	}
}

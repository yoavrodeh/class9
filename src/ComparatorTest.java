import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ComparatorTest {
	private Random rand = new Random();
	private Integer[] a;
	private long count = 0;

	private class Reverse implements Comparator<Integer> {
		@Override
		public int compare(Integer i1, Integer i2) {
			count++;
			if (i1.equals(i2))
				return 0;
			return i1 > i2 ? -1 : 1;
		}
	}

	public long run(int size) {
		a = new Integer[size];
		for (int i = 0; i < size; i++)
			a[i] = rand.nextInt();
		Arrays.sort(a, new Reverse());
		return count;
	}

	public static void main(String[] args) {
		ComparatorTest t = new ComparatorTest();
		int size = 1000;
		System.out.format("int[%d] took %d comparisons%n",
				size, t.run(size));
		// int[1000] took 8680 comparisons
	}
}

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExample {
	
	private static class Reverse
			implements Comparator<Integer> {
		@Override
		public int compare(Integer i1, Integer i2) {
			if (i1.equals(i2))
				return 0;
			return i1 > i2 ? -1 : 1;
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = {3, 5, 2, 1, 8, 1, 21, 13};
		Arrays.sort(a, new Reverse());
		System.out.println(Arrays.toString(a));
		// [21, 13, 8, 5, 3, 2, 1, 1]
	}
}

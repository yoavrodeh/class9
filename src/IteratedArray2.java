import java.util.Iterator;

public class IteratedArray2 implements Iterable<String> {
	private String a[];

	public IteratedArray2(int size) {
		a = new String[size];
		for (int i = 0; i < size; i++)
			a[i] = "Element" + i;
	}

	private class Iterator1 implements Iterator<String> {
		private int count = 0;

		@Override
		public boolean hasNext() {
			return count < a.length;
		}
		@Override
		public String next() {
			return a[count++];
		}
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator1();
	}


	private class Iterator2 implements Iterator<String> {
		private int count = 0, numSteps;

		public Iterator2(int numSteps) {
			this.numSteps = numSteps;
		}
		@Override
		public boolean hasNext() {
			return numSteps > 0;
		}
		@Override
		public String next() {
			String temp = a[count];
			count = (count + 3) % a.length;
			numSteps--;
			return temp;
		}
	}
	
	public Iterator<String> iterator2(int numSteps) {
		return new Iterator2(numSteps);
	}
}

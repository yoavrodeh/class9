import java.util.Iterator;

public class IteratedArray implements Iterator<String> {
	private String a[];
	private int count = 0;

	public IteratedArray(int size) {
		a = new String[size];
		for (int i = 0; i < size; i++)
			a[i] = "Element" + i;
	}

	@Override
	public boolean hasNext() {
		return count < a.length;
	}
	@Override
	public String next() {
		return a[count++];
	}
	public void initIterator() {
		count = 0;
	}
}

package ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandList implements Iterable<String> {
	List<String> strs;

	public RandList(List<String> strs) {
		this.strs = strs;
	}

	private class It implements Iterator<String> {
		List<String> shuffled;
		int i = 0;

		public It() {
			shuffled = new ArrayList<>(strs);
			Collections.shuffle(shuffled);
		}

		@Override
		public boolean hasNext() {
			return i < shuffled.size();
		}

		@Override
		public String next() {
			return shuffled.get(i++);
		}
	}

	@Override
	public Iterator<String> iterator() {
		return new It();
	}

	public static void main(String[] args) {
		RandList a = new RandList(
				Arrays.asList("aaa", "bbb", "ccc"));
		for (String s : a)
			System.out.println(s);
	}
}

import java.util.Iterator;
public class MainForIteratedArray2 {
	public static void main(String[] args) {
		IteratedArray2 arr = new IteratedArray2(5);
		Iterator<String> i = arr.iterator();
		while (i.hasNext())
			System.out.print(i.next() + " ");
		// Element0 Element1 Element2 Element3 Element4
	}
}

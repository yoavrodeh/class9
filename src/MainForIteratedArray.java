public class MainForIteratedArray {
	public static void main(String[] args) {
		IteratedArray arr = new IteratedArray(4);
		arr.initIterator();
		while(arr.hasNext())
			System.out.print(arr.next() + " ");
		// Element0 Element1 Element2 Element3 
	}
}

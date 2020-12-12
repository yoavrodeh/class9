public class MainForMyList {
	public static void main(String[] args) {
		MyList<Integer> l = new MyList<>();
		l.add(4);
		l.add(2);
		l.add(17);
		for (int val : l)
			System.out.print(val + " ");
		// 17 2 4
	}
}

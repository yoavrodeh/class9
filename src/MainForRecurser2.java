public class MainForRecurser2 {
	public static void main(String[] args) {
		Func func = new Func() {
			@Override
			public int f(int x, int y) {
				return x + y;
			}
		};
		Recurser r = new Recurser(1, 1, func); 
		System.out.println(r.recurse(6));		
	}
}

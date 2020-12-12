public class MainForRecurser {
	public static void main(String[] args) {
		class Fibonnaci implements Func {
			@Override
			public int f(int x, int y) {
				return x + y;
			}
		}
		Recurser r = new Recurser(1, 1, new Fibonnaci());
		System.out.println(r.recurse(6)); // 13
		
		class Fib2 implements Func {
			@Override
			public int f(int x, int y) {
				return x * y;
			}
		}
		Recurser r2 = new Recurser(1, 2, new Fib2());
		System.out.println(r2.recurse(6)); // 256
	}
}

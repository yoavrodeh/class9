public class Recurser {
	private int val0, val1;
	private Func func;
	
	public Recurser(int val0, int val1, Func func) {
		this.val0 = val0;
		this.val1 = val1;
		this.func = func;
	}
	
	public int recurse(int n) {
		if (n == 0)
			return val0;
		if (n == 1)
			return val1;
		return func.f(recurse(n - 1), recurse(n - 2));
	}
}


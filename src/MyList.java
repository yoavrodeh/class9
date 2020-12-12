import java.util.Iterator;

public class MyList<E> implements Iterable<E> {
	private Node<E> head = null;

	public void add(E val) {
		head = new Node<>(val, head);
	}

	@Override
	public Iterator<E> iterator() {
		return new MyListIterator();
	}

	private class MyListIterator implements
				Iterator<E> {
		private Node<E> current = head;
		@Override
		public boolean hasNext() {
			return current != null;
		}
		@Override
		public E next() {
			E res = current.getVal();
			current = current.getNext();
			return res;
		}
	}
}

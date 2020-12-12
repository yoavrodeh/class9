public class Node<E> {
	private E val;
	private Node<E> next;

	public Node(E val, Node<E> next) {
		this.val = val;
		this.next = next;
	}
	public E getVal() {
		return val;
	}
	public Node<E> getNext() {
		return next;
	}
}
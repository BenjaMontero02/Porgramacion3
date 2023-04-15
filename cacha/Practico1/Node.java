public class Node<T> {

	private T info;
	private Node<T> next;
	private Node<T> back;

	public Node() {
		this.info = null;
		this.next = null;
	}
	
	public Node(T info, Node<T> next, Node<T> back) {
		this.setInfo(info);
		this.setNext(next);
		this.setBack(back);
	}
	
	void setBack(Node<T> back2) {
		this.back = back2;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public int compareTo(Object o) {
		return 0;
	}

}

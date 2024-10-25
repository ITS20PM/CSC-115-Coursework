//Name: Patrick Meng
// Student ID: V00934970
public class A5Stack<T> implements Stack<T> {
	
	private Node<T> head;

	public A5Stack() {
		// TODO: implement this
		this.head = null;
	}
	
	public void push(T v) {
		// TODO: implement this
		Node<T> temp = new Node<T>(v);
		temp.next = head;
		head = temp;
	}
	
	public T pop(){
		// TODO: implement this	
		if(isEmpty()){
			throw new EmptyStackException();
		}
		T top = this.head.getData();
		head = head.getNext();
		return top; // so it compiles
	}

	public T top(){
		// TODO: implement this
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return this.head.getData();
	}	
	
	public void popAll() {
		// TODO: implement this	
		head = null;
	}
	
	public boolean isEmpty() {
		// TODO: implement this	

		return this.head == null; // so it compiles
	}
	
}
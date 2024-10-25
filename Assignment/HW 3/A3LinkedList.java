// Name: Patrick Meng
// Student number: v00934970

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node node = new A3Node(s);
		if(isEmpty()){
			head = node;
			tail = node;
		}
		else{
			head.prev = node;
			node.next = head;
			head = head.prev;
		}
		length++;
	}

	public void addBack(String s) {
		A3Node cur = new A3Node(s);
		if(isEmpty()){
			tail = cur;
			head = cur;
		}
		else{
			tail.next = cur;
			cur.prev = tail;
			tail = tail.next;
		}
		length++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		if(isEmpty()) 
			return;
		if(length==1){
			head = null;
			tail = null;
			length = 0;
			return;
		}
		head = head.next;
		head.prev = null;
		length--;
	}
	
	public void removeBack() {
		if(isEmpty())
			return;
		if(length==1){
			head = null;
			tail = null;
			length = 0;
			return;
		}
		tail = tail.prev;
		tail.next = null;
		length--;
	}
	
	
	public void rotate(int n) {
		if(isEmpty()||n%length==0) 
			return;
		
		for(int i = 1; i <= n%length; i++){
			A3Node temp = new A3Node(tail.getData());
			tail = tail.prev;
			tail.next = null;
			head.prev = temp;
			temp.next = head;
			head = temp;
		}
	}
	
	public void interleave(A3LinkedList other) {
		A3Node cur1 = head;
		A3Node cur2 = other.head;
		for(int i = 1; i <= length-1; i++){
			A3Node temp = cur1.next;
			A3Node temp2 = cur2.next;
			cur1.next = temp2;
			temp2.prev = cur1;
			cur2.next = temp;
			temp.prev = cur2;
			
			cur1 = temp2;
			cur2 = temp;
		}
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	
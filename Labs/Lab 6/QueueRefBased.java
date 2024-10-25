public class QueueRefBased<T> implements Queue<T>{
    
	private QueueNode<T> front;
	private QueueNode<T> back;

	public QueueRefBased() {
		front = null;
		back = null;
	}

	public int size() {
		int count = 0;
		// TODO: complete
		QueueNode<T> cur = front;
		while(cur != null){
			cur = cur.getNext();
			count++;
		}
		return count;
	}


	public boolean isEmpty() {
		// TODO: complete
		return front == null;
	}


	public void enqueue (T element) {
		// TODO: complete
		QueueNode<T> temp = new QueueNode<T>(element);
		if(isEmpty()){
			front = temp;
			back = temp;
			
		}
		else{
		back.next = temp;
		back = temp;
		}
		
	}

	public T dequeue() {
		// TODO: complete
		T res = front.data;
		front = front.getNext();
		return res;
	}

	public T peek() {
		// TODO: complete
		return front.data;
	}

	public void makeEmpty() {
		// TODO: complete
		front = null;
		back = null;
	}
}


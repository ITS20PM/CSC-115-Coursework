public class StudentLinkedList implements StudentList {

	StudentNode head;
	int count;

	/*
	 * Purpose: initialize the fields for the list implementation
	 *          by setting head to null and count to 0
	 */
	public StudentLinkedList() {
		head = null;
		count = 0;
	}

	public void add(Student s) {
		// TODO: complete
		StudentNode new_node = new StudentNode(s,null);
		if(head == null){
			head = new_node;
		}
		else{
			StudentNode cur = head;
			while(cur.next!=null){
				cur = cur.next;
			}
			cur.next = new_node;
		}
		count++;
	}

	public int size() {
		// TODO: complete
		return count;
	}

	public void removeFront() {
		// TODO: complete
		if(head == null&&count==0) 
			return;
		head = head.next;
		count--;
	}

	public boolean contains(Student s) {
		// TODO: complete
		StudentNode cur = head;
		while(cur!=null){
			if(cur.getData().getSID().equals(s.getSID()))
				return true;
			cur = cur.next;
		}
		return false;
	}
	
	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this list separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		// DO NOT CHANGE THIS METHOD - it is correct
		// Changing it will result in your code getting
		// a score of 0 from the autograder for this lab
		
		String s = "";
		StudentNode tmp = head;

		while(tmp != null) {
			s  += tmp.getData() + "\n";
			tmp = tmp.next;
			// could be written as tmp.setNext(tmp.getNext());
		}

		return s;
	}
}

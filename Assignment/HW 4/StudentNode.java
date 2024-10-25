/*
 * StudentNode.java
 * A singly-linked student node class
 */
public class StudentNode {
    
	public StudentNode next;
	private Student    data;

	public StudentNode(Student data) {
		this.data = data;
		this.next = null;
	}

	public StudentNode(Student data, StudentNode next) {
		this.data = data;
		this.next = next;
	}

	/*
	 * Purpose: returns the value of this StudentNode's next
	 * Parameters: none
	 * Returns: StudentNode - the next
	 */
	public StudentNode getNext() {
		return this.next;
	}

	/*
	 * Purpose: set's this StudentNode's next to parameter value
	 * Parameters: StudentNode - next
	 * Returns: nothing
	 */
	public void setNext(StudentNode next) {
		this.next = next;
	}

	/*
	 * Purpose: returns the value of this StudentNode's data
	 * Parameters: none
	 * Returns: Student - the data
	 */
	public Student getData() {
		return this.data;
	}

	/*
	 * Purpose: set's this StudentNode's data to parameter value
	 * Parameters: Student - data
	 * Returns: nothing
	 */
	public void setData(Student data) {
		this.data = data;
	}
    
}

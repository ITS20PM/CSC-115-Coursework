public class A4LinkedList implements A4List {
    
	// Completed for you, should not be changed
	private StudentNode head;
	private StudentNode tail;
	private int numElements;

	// Completed for you, should not be changed
	public A4LinkedList() {
		head = null;
		tail = null;
		numElements = 0;
	}
	
	// Completed for you, should not be changed
	public int size(){
		return numElements;
	}
	
	// Completed for you, should not be changed
	public boolean isEmpty() {
		return head == null;
	}
	
	// Completed for you, should not be changed
	public void insert(Student s) {
		StudentNode n = new StudentNode(s);
		if (head == null) {
			head = n;
		} else {
			tail.next = n;
		}
		tail = n;
		numElements++;
	}
	
	/*
	 * Purpose: create a string representation of list 
	 * Parameters: none
	 * Returns: String - the string representation
	 *
	 * Completed for you, should not be changed
	 */
	public String toString() {
		return "{" + toStringRecursive(head) + "}";
	} 
	
	public String toStringRecursive(StudentNode cur) {
		if (cur == null) {
			return "";
		} else if (cur.next == null) {
			return cur.getData().toString() + toStringRecursive(cur.next);
		} else {
			return cur.getData().toString() + ", " + toStringRecursive(cur.next);
		}
	}

	public int inProgram(String program) {
		return inProgramRecursive(head, program);
	}
	
	private int inProgramRecursive(StudentNode cur, String program) {
		if(cur == null) return 0;
		
		if(cur.getData().getProgram().equals(program))
			return 1 + inProgramRecursive(cur.getNext(), program);
		else
			return inProgramRecursive(cur.getNext(), program);
	}

	public Student getStudent(String sID) {
		return getStudentRecursive(head, sID);
	}
	
	private Student getStudentRecursive(StudentNode cur, String sID) {
		if(cur == null) 
			return null;
		else if(cur.getData().getSID().equals(sID))
			return cur.getData();
		
		return getStudentRecursive(cur.getNext(), sID);
	}
	
	public double averageGPA() {
		if (size() == 0) {
			return 0.0;
		} else {
			return sumGPARecursive(head)/size();
		}
	}
	
	private double sumGPARecursive(StudentNode cur) {
		if(cur == null) return 0.0;
		
		return cur.getData().getGPA() + sumGPARecursive(cur.getNext());
	}
	
	public double programAverage(String program) {
		if(inProgramRecursive(head, program) == 0)
			return 0.0;
		
		return sumRecursively(head, program)/inProgramRecursive(head, program);
	}
	
	private double sumRecursively(StudentNode cur, String program){
		if(cur == null)
			return 0.0;
		
		if(cur.getData().getProgram().equals(program))
			return cur.getData().getGPA() + 
			sumRecursively(cur.getNext(), program);
		else
			return sumRecursively(cur.getNext(), program);
	}
	
	public Student lowestGPA() {
		if(this.head == null) 
			return null;
		
		double min = head.getData().getGPA();
		String id = head.getData().getSID();
		StudentNode cur = head;
		id = minRecursively(cur.getNext(), min, id);
		
		cur = head;
		return getStudentRecursive(cur, id);
	}
	
	private String minRecursively(StudentNode cur, double min, String id){
		if(cur == null) 
			return id;
		else if(cur.getData().getGPA()<min){
			min = cur.getData().getGPA();
			id = cur.getData().getSID();
		}
		
		return minRecursively(cur.getNext(), min, id);
	}

}




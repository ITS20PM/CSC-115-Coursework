public class IntegerLinkedList {

	private IntegerNode	head;
	private int count;

	public IntegerLinkedList() {
		head = null;
		count = 0;
	}
	
	/*
	 * size
	 * Purpose: returns the size of this IntegerList
	 * Parameters: none
	 * Returns: int - the size
	 */
	public int size() {
		return count;
	}

	/*
	 * addFront
	 * Purpose: adds element with i to the front of this Integerlist
	 * Parameters: int - i
	 * Returns: nothing
	 */
	public void addFront (int i) {
		IntegerNode n = new IntegerNode(i, head);
		head = n;
		count++;
	}


	/*
	 * toString
	 * Purpose: returns a String representation of this IntegerList
	 * Parameters: none
	 * Returns: String - the String representation
	 */
	public String toString() {
		return toString(head);
	}

	private String toString(IntegerNode n) {
		if (n==null) {
			return "";
		} else {
			if(n.next != null) {
				return n.getElement() + " " + toString(n.next);
			} else {
				return n.getElement() + toString(n.next);
			}
		}
	}
		
	/*
	 * addOneRecursive
	 * Purpose: recursively adds 1 to every element in this IntegerList
	 * Parameters: none
	 * Returns: nothing
	 */
	public void addOneRecursive() {
		addOneRecursiveHelper(head);
	}

	/*
	 * addOneRecursiveHelper
	 * Purpose: recursively adds 1 to IntegerNode n and every element following n
	 * Parameters: IntegerNode - n
	 * Returns: nothing
	 */
	private void addOneRecursiveHelper(IntegerNode n) {
		if (n == null) {
			return;
		} else {
			
			// get data in current node and add 1 to it
			int valPlusOne = n.getElement() + 1;
			
			// set element in current node to valPlusOne
			n.setElement(valPlusOne);
			
			// add one to the elements in the  REST of the list
			addOneRecursiveHelper(n.next);
		}
	}

	/*
	 * doubleValues
	 * Purpose: recursively doubles every element in this IntegerList
	 * Parameters: none
	 * Returns: nothing
	 */
	public void doubleValues() {
		// TODO: implement and test this method
		doubleValues(head);
	}

	private void doubleValues(IntegerNode head){
		IntegerNode cur = head;
		
		if(cur == null) return;
		
		cur.setElement(2*cur.getElement());
		doubleValues(cur.getNext());
	}


	/*
	 * doubleOddValues
	 * Purpose: recursively doubles every odd valued element in this IntegerList
	 *  By "odd valued element" we mean the Node's element is an odd number
	 *  NOT that it is at an odd position in the list
	 * Parameters: none
	 * Returns: nothing
	 */
	public void doubleOddValues() {
		// TODO: implement and test this method
		doubleOddValues(head);
	}

	private void doubleOddValues(IntegerNode head){
		IntegerNode cur = head;
		
		if(cur == null) return;
		
		if(cur.getElement()%2 != 0)
			cur.setElement(2*cur.getElement());
		
		doubleOddValues(cur.getNext());
	}



	/*
	 * sum
	 * Purpose: recursively sums every element in this IntegerList
	 * Parameters: none
	 * Returns: int - the sum
	 */
	public int sum() {
		return sum(head);
	}


	/*
	 * sum
	 * Purpose: recursively sums element in IntegerNode n and every element following n
	 * Parameters: IntegerNode - n
	 * Returns: int - the sum
	 */
	private int sum(IntegerNode n) {
		if (n==null) {
			return 0;
		} else {
			int first = n.getElement();
			int sumRest = sum(n.next);
			
			return first + sumRest;
		}
	}

	/*
	 * product
	 * Purpose: recursively computes the product of every element in this IntegerList
	 *  Note: the product of an empty list is 1
	 * Parameters: none
	 * Returns: int - the product
	 */
	public int product() {
		// TODO: implement and test this method
		return product(head);
	}
	
	private int product(IntegerNode head){
		IntegerNode cur = head;
		if(cur == null) return 1;
		
		return cur.getElement()*product(cur.getNext());
	}

	/*
	 * doubleOddPositionValues
	 * Purpose: recursively doubles every element at an odd postion in this IntegerList
	 *          the first  element in this list is at position 0 (is not odd)
	 *          the second element in this list is at position 1 (is odd)
	 *          the third  element in this list is at position 2 (is not odd)
	 *          ...
	 * Parameters: none
	 * Returns: nothing
	 */
	public void doubleOddPositionValues() {
		doubleOddPositionValues(head, 0);
	}

	/*
	 * doubleOddPositionValues
	 * Purpose: recursively doubles element in IntegerNode n if n is at odd position
	 *          and every element after n at odd positions
	 * Parameters: IntegerNode - n, int - position
	 * Returns: nothing
	 */
	private void doubleOddPositionValues(IntegerNode n, int position) {
		if (n == null) {
			return;
		} else {
			if (position % 2 != 0) {
				int doubleVal = n.getElement() * 2;
				n.setElement(doubleVal);
			}
			doubleOddPositionValues(n.next, position+1);
		}
	}


	/*
	 * allNegative
	 * Purpose: recursively determines whether all elements in this IntegerList are negative
	 * Parameters: none
	 * Returns: boolean - true if all negative, false otherwise
	 * Note: an empty list is considered to have all negative values (as there are no
	 *       non-negative values found in the list)
	 */
	public boolean allNegative() {
		// TODO: implement and test this method
		return allNegative(head);
	}
	
	private boolean allNegative(IntegerNode head){
		IntegerNode cur = head;
		if(cur == null) 
			return true;
		
		return (cur.getElement() < 0&&allNegative(cur.getNext()));
	}


	/*
	 * isSortedAscending
	 * Purpose: recursively determines whether every element in this IntegerList
	 *      is sorted in ascending order
	 *      {1, 2, 2, 5} is sorted in ascending order
	 *      {3, 2, 2, 5} is not sorted in ascending order
	 * Parameters: none
	 * Returns: boolean - true if sorted, false otherwise
	 * Note: an empty list is considered sorted
	 */
	public boolean isSortedAscending() {
		// TODO: implement and test this method
		return isSortedAscending(head);
	}  
	
	private boolean isSortedAscending(IntegerNode head){
		IntegerNode cur = head;
		if(cur == null || cur.getNext() == null) 
			return true;
		else if(cur.getElement() > cur.getNext().getElement())
			return false;
		else
			return isSortedAscending(cur.getNext());
	}
	
}


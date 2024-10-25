public class ShapeList{
    
	private static final int DEFAULT_SIZE = 2;

	private Shape[] elements;
	private int count;

	public ShapeList() {
		elements = new Shape[DEFAULT_SIZE];
		count = 0;
	}

	/*
	 * Purpose: returns the number of elements in list
	 * Parameters: none
	 * Returns: int - the number of elements
	 */
	public int size() {
		return count;
	}

	/*
	 * Purpose: adds Shape s to back of this list
	 * Parameters: Shape - s
	 * Returns: nothing
	 *
	 * IMPLEMENTATION NOTE: if elements is full, a new
	 * array should be created to hold all of the original
	 * elements and also shape s.
	 */
	public void add(Shape s) {
		if(count >= elements.length){
			Shape[] elements2 = new Shape[elements.length+10];
			for(int i = 0; i < elements.length; i++){
				elements2[i] = elements[i];
			}
			this.elements = elements2;
		}
		
		elements[count] = s;
		count++;
	}

	/*
	 * Purpose: returns a String reprensentation of the elements
	 *      in this list separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		String s = "";

		for(int i=0; i<count; i++) {
			s += elements[i] + "\n";
		}

		return s;
	}

	/*
	 * Purpose: removes the first element in this list
	 * Parameters: none
	 * Returns: nothing
	 *
	 * IMPLEMENTATION NOTE: After removing the first element,
	 * all other elements should be shuffledforward 
	 * so that there are no gaps in the array.
	 */
	public void removeFront() {
		if(count == 0) return;
		
		for(int i = 0; i < elements.length-1; i++){
			elements[i] = elements[i+1];
		}
		count--;
	}
    
    
}

/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/

public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;

	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		storage = new Comparable[DEFAULT_SIZE];
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 * Precondition: size > 0
	 */
	public HeapPriorityQueue(int size) {
		//TODO: Implement this
		storage = new Comparable[size];
		currentSize = 0;
	}
	
	/*
	 * The array implementation of insert MUST throw
	 * a HeapFullException if the array is full
	 */
	public void insert ( Comparable element ) {
		//TODO: Implement this
		if(this.storage.length == currentSize)
			throw new HeapFullException();
		storage[currentSize] = element;
		int i = currentSize;
		while(i > 0&&storage[i].compareTo(storage[(i-1)/2])<0){
			Comparable temp = storage[i];
			storage[i] = storage[(i-1)/2];
			storage[(i-1)/2] = temp;
			i = (i-1)/2;
		}
		currentSize++;
	}
	
	// TODO: Add other methods here
	public Comparable removeMin(){
		if(currentSize == 0)
			throw new HeapEmptyException();
		Comparable min = storage[0];
		storage[0] = storage[currentSize-1];
		
		int i = 0; 	
		while(i < currentSize-1){
			int index = i;
			if(2*i+1<currentSize-1&&storage[i].compareTo(storage[2*i+1])>0){
				if(2*i+2>=currentSize-1||storage[2*i+1].compareTo(storage[2*i+2])<0)
					i = 2*i+1;
				else
					i = 2*i+2;
			} 
			else if(2*i+2<currentSize-1&&storage[i].compareTo(storage[2*i+2])>0){
				if(storage[2*i+2].compareTo(storage[2*i+1])<=0)
					i = 2*i+2;
				else 
					i = 2*i+1;
			}
				
			if(i != index){
				Comparable temp = storage[index];
				storage[index] = storage[i];
				storage[i] = temp;
			}
			else{
				break;
			}
		}

		storage[currentSize-1] = 0;
		currentSize--;
		
		return min;
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public int size(){
		return currentSize;
	}
	
	public String toString() {
		String s = "";
		String sep = "";
		for(int i=0;i<currentSize;i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}

}

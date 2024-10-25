public class A4Exercises {

	/*
	 * Purpose: subtract val from all elements in the given array
	 * Parameters: int[] array - the array to modify
	 *             int val - the value to modify items by
	 * Returns: void - nothing
	 */
	public static void subtractFromAll(int[] array, int val) {
		subtractFromAllRecursive(array, val, array.length-1);
	}
	
	private static void subtractFromAllRecursive(int[] array, int val, int i) {
		if(i < 0) return;
		
		array[i] -= val;
		subtractFromAllRecursive(array, val, i-1);
	}
	
	/*
	 * Purpose: determines whether the given array contains toFind
	 * Parameters: int[] array - the array to search
	 *             int toFind - the value to search for
	 * Returns: boolean - true if found, false otherwise
	 */
	public static boolean arrayContains(int[] array, int toFind) {
		return arrayContainsRecursive(array, toFind, array.length-1);
	}
	
	private static boolean arrayContainsRecursive(int[] array, int toFind, int i) {
		if(i < 0) return false;
		
		return array[i] == toFind || arrayContainsRecursive(array, toFind, i-1);
	}
	
	/*
	 * Purpose: determines if the array values are sorted in ascending order
	 * Parameters: int[] array - the array to search
	 * Returns: boolean - true if the array is sorted, false otherwise
	 */	
	public static boolean isSorted(int[] array) {
		if (array.length <= 1) { // if there is only one element (or less),
			return true;		 // then the array is sorted
		} else {
			return isSortedRecursive(array, array[array.length-1], array.length-2);
		}
	}
	
	public static boolean isSortedRecursive(int[] array, int prev, int i) {
		// Note: prev is the value of the previous element, i is the current index
		if(i < 0) return true;
		
		return prev >= array[i] && isSortedRecursive(array, array[i], i-1);
	}
}
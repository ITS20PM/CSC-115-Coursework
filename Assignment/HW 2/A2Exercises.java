//Name: Patrick Meng
//Student ID: V00934970

public class A2Exercises {
	
	/*
	 * Purpose: Add item to the given array of auction items
	 * Parameters: AuctionItem[] array - the array to add the AuctionItem to
	 * 			   AuctionItem item - the item to add to the array
	 * Returns: AuctionItem[] - a new array containing all of the auction
	 *                   items found in original array plus the item
	 */
	public static AuctionItem[] addItem(AuctionItem[] array, AuctionItem item) {
		AuctionItem[] collection = new AuctionItem[array.length+1];
		
		for(int i = 0; i < array.length; i++){
			collection[i] = array[i];
		}
		collection[collection.length-1] = item;
		
		return collection; // so it compiles
	}
	
	/*
	 * Purpose: get the sum of top bids made on auction items in the array
	 * Parameters: AuctionItem[] array
	 * Returns: int - the sum of all top bids
	 */
	public static int sumOfBids(AuctionItem[] array) {
		int result = 0;
		
		for(int i = 0; i < array.length; i++){
			result += array[i].getTopBid();
		}
		return result; // so it compiles
	}
	
	/*
	 * Purpose: get the number of auction items currently being
	 *          won by people with the given lastName
	 * Parameters: AuctionItem[] arr - the array of auction items
	 *             String lastName - the last name to search for
	 * Returns: int - the number of auction items people with the
	 *                given last name are currently winning
	 */
	public static int bidsByName(AuctionItem[] arr, String lastName) {
		int result = 0;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i].getTopBidder().getLastName().equals(lastName))
				result++;
		}
		return result; // so it compiles
	}
	
	/*
	 * Purpose: get the number of auction items where the top bid
	 *          is less than threshold dollars above the starting price
	 * Parameters: AuctionItem[] arr - the array of auction items
	 *             int threshold - the threshold above starting price
	 * Returns: int - the number of items where the top bid is within
	 *                threshold dollars from the starting price
	 */
	public static int countGoodDeals(AuctionItem[] arr, int threshold) {
		int result = 0;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i].amountAboveStarting() < threshold)
				result++;
		}
		return result; // so it compiles
	}
}
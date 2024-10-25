//name: Patrick Meng
//Student ID: V00934970

public class AuctionItem {
	private String name;
	private int startingPrice;
	private int topBid;
	private Person topBidder;
	
	public AuctionItem(String name, int startingPrice, int topBid, Person topBidder) {
		this.name = name;
		this.startingPrice = startingPrice;
		this.topBid = topBid;
		this.topBidder = topBidder;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStartingPrice() {
		return startingPrice;
	}
	
	public int getTopBid() {
		return topBid;
	}
	
	public Person getTopBidder() {
		return topBidder;
	}
	
	/*
	 * Purpose: return the string representation for this event
	 * Parameters: none
	 * Returns: String - the string representation
	 */	
	public String toString() {
		String result;
		result = "Item name: "+name+"\n";
		result += "Current Winning Bid: "+topBid+"\n";
		result += "Bidder: "+topBidder;
		return result;
	}
	
	/*
	 * Purpose: determine if the other auction item is equal to this item
	 * Parameters: AuctionItem other - the other event to examine
	 * Returns: boolean - true if they are equal, false otherwise
	 *
	 * Note: Two auction items are considered the same if they have
	 * the same name and starting price
	 */
	public boolean equals(AuctionItem other) {
		return this.name.equals(other.getName())
			&& this.startingPrice == other.getStartingPrice();
		// so it compiles
	}
	
	/*
	 * Purpose: handles an attempted bid at an auction
	 * Parameters: int amount - the amount being bid
	 *             Person bidder - the person making the bid
	 * Returns: boolean - true if the bid was successful, false otherwise
	 *
	 * Notes: the bid is only successful if the amount being bid is 
	 *        higher than the current top bid.
	 */
	public boolean makeBid(int amount, Person bidder) {
		if(amount > this.topBid){
			this.topBid = amount;
			this.topBidder = bidder;
			return true;
		}
		return false;
		// so it compiles
	}
	
	/*
	 * Purpose: determine how many dollars above the starting bid
	 *          this item is currently being auctioned for
	 * Parameters: none
	 * Returns: int - the amount of dollars above the starting price
	 *          this item is currently being auctioned for.
	 */
	public int amountAboveStarting() {
		return this.topBid - this.startingPrice; // so it compiles
	}
	
}
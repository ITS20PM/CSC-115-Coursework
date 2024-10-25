public class A2Tester {

	private static int testPassCount = 0;
	private static int testCount = 0;

	public static void main(String[] args) {

		// Uncomment and test one method at a time. 
		// Write additional tests as you see fit.

		/* Part 1: The Date class */
		testAuctionItemConstructor();
		testEquals();
		testMakeBid();
		testAmountAboveStarting();
		
		/* Part 2: The A2Exercises class */
		testAddItem();
		testSumOfBids();
		testBidsByName();
		testCountGoodDeals();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testAuctionItemConstructor() {
		System.out.println("\nTesting AuctionItem Constructor");
		
		Person p1 = new Person("Gillian", "Flynn", 49);
		Person p2 = new Person("Veronica", "Roth", 32);
		
		AuctionItem a1 = new AuctionItem("ruby necklace", 1600, 2500, p1);
		AuctionItem a2 = new AuctionItem("oil painting", 500, 510, p2);
		
		int result = 0;
		int expected = 0;
		
		result = a1.getStartingPrice();
		expected = 1600;
		displayResults(result==expected, "a1 construcutor startingBid initialized");
		
		result = a1.getTopBid();
		expected = 2500;
		displayResults(result==expected, "a1 construcutor topBid initialized");
		
		// Uncomment the tests below once the tests above pass
		
		Person resultBidder = null;
		Person expectedBidder = null;
		
		resultBidder = a1.getTopBidder();
		expectedBidder = p1;
		displayResults(resultBidder.equals(expectedBidder), "a1 construcutor topBidder initialized");
		
		resultBidder = a2.getTopBidder();
		expectedBidder = p2;
		displayResults(resultBidder.equals(expectedBidder), "a2 construcutor topBidder initialized");
		
	}
	
	public static void testEquals() {
		System.out.println("\nTesting AuctionItem equals method");
		
		Person p1 = new Person("Gillian", "Flynn", 49);
		Person p2 = new Person("Veronica", "Roth", 32);
		
		AuctionItem a1 = new AuctionItem("ruby necklace", 1600, 2500, p1);
		AuctionItem a2 = new AuctionItem("oil painting", 500, 510, p2);
		AuctionItem a3 = new AuctionItem("oil painting", 1600, 2500, p1);
		AuctionItem a4 = new AuctionItem("oil painting", 500, 510, p2);
		AuctionItem a5 = new AuctionItem("ruby necklace", 500, 510, p2);
		AuctionItem a6 = new AuctionItem("ruby necklace", 500, 510, p1);
		
		boolean result = false;
		boolean expected = false;
		
		result = a1.equals(a2);
		displayResults(result==false, "a1 equals a2");
		result = a1.equals(a3);
		displayResults(result==false, "a1 equals a3");
		result = a2.equals(a3);
		displayResults(result==false, "a2 equals a3");
		result = a2.equals(a4);
		displayResults(result==true, "a2 equals a4");
		result = a6.equals(a5);
		displayResults(result==true, "a6 equals a4");
		result = a4.equals(a5);
		displayResults(result==false, "a4 equals a5");
	
	}
	
	public static void testMakeBid() {
		System.out.println("\nTesting AuctionItem makeBid method");
		
		Person p1 = new Person("Gillian", "Flynn", 49);
		Person p2 = new Person("Veronica", "Roth", 32);
		
		AuctionItem a1 = new AuctionItem("ruby necklace", 1600, 2500, p1);
		AuctionItem a2 = new AuctionItem("oil painting", 500, 510, p2);
		
		Person topBidder = null;
		int topBid = 0;
		boolean bidSuccessful = false;
				
		bidSuccessful = a1.makeBid(2200, p2);
		topBidder = p1;
		topBid = 2500;
		displayResults(bidSuccessful==false, "a1.makeBid(2200, p2)");
		displayResults(a1.getTopBidder().equals(topBidder), "a1.makeBid(2200, p2)");
		displayResults(a1.getTopBid()==topBid, "a1.makeBid(2200, p2)");
		
		bidSuccessful = a1.makeBid(2500, p2);
		topBidder = p1;
		topBid = 2500;
		displayResults(bidSuccessful==false, "a1.makeBid(2200, p2)");
		displayResults(a1.getTopBidder().equals(topBidder), "a1.makeBid(2200, p2)");
		displayResults(a1.getTopBid()==topBid, "a1.makeBid(2200, p2)");
		
		bidSuccessful = a1.makeBid(2501, p2);
		topBidder = p2;
		topBid = 2501;
		displayResults(bidSuccessful==true, "a1.makeBid(2200, p2)");
		displayResults(a1.getTopBidder().equals(topBidder), "a1.makeBid(2200, p2)");
		displayResults(a1.getTopBid()==topBid, "a1.makeBid(2200, p2)");
		
		bidSuccessful = a1.makeBid(2600, p2);
		topBidder = p2;
		topBid = 2600;
		displayResults(bidSuccessful==true, "a1.makeBid(2200, p2)");
		displayResults(a1.getTopBidder().equals(topBidder), "a1.makeBid(2200, p2)");
		displayResults(a1.getTopBid()==topBid, "a1.makeBid(2200, p2)");
		
	}
	
	public static void testAmountAboveStarting() {
		System.out.println("\nTesting AuctionItem amountAboveStarting method");
		
		Person p1 = new Person("Gillian", "Flynn", 49);
		Person p2 = new Person("Veronica", "Roth", 32);
		
		AuctionItem a1 = new AuctionItem("ruby necklace", 1600, 2500, p1);
		AuctionItem a2 = new AuctionItem("oil painting", 500, 510, p2);
		
		int result = 0;
		int expected = 0;
				
		result = a1.amountAboveStarting();
		expected = 900;
		displayResults(result==expected, "a1.amountAboveStarting()");
		
		result = a2.amountAboveStarting();
		expected = 10;
		displayResults(result==expected, "a1.amountAboveStarting()");
		
		Person p3 = new Person("Patrick", "Meng", 20);
		Person p4 = new Person("Steven", "Huang", 22);
		Person p5 = new Person("Tim", "Ye", 20);
		
		AuctionItem a3 = new AuctionItem("Ipad", 50, 250, p3);
		AuctionItem a4 = new AuctionItem("Drone", 150, 500, p4);
		AuctionItem a5 = new AuctionItem("Laptop", 200, 750, p5);
		
		result = a3.amountAboveStarting();
		expected = 200;
		displayResults(result==expected, "a1.amountAboveStarting()");
		
		result = a4.amountAboveStarting();
		expected = 350;
		displayResults(result==expected, "a1.amountAboveStarting()");
		
		result = a5.amountAboveStarting();
		expected = 550;
		displayResults(result==expected, "a1.amountAboveStarting()");
	}
		
	public static void testAddItem() {
		System.out.println("\nTesting addItem method");
		Person p1 = new Person("Gillian", "Flynn", 49);
		Person p2 = new Person("Veronica", "Roth", 32);
		Person p3 = new Person("Paula", "Hawkins", 48);
		Person p4 = new Person("John", "Green", 43);
		
		AuctionItem a1 = new AuctionItem("ruby necklace", 1600, 2500, p1);
		AuctionItem a2 = new AuctionItem("oil painting", 500, 510, p2);
		AuctionItem a3 = new AuctionItem("ancient map", 50, 800, p1);
		AuctionItem a4 = new AuctionItem("yoga membership", 1200, 1250, p1);
		AuctionItem a5 = new AuctionItem("Tesla Cyber Truck", 75000, 99000, p3);
		AuctionItem a6 = new AuctionItem("signed jersey", 350, 400, p4);
		AuctionItem a7 = new AuctionItem("all-inclusive getaway", 2200, 2800, p2);
				
		AuctionItem[] arr0 = {};
		AuctionItem[] arr1 = {a3};
		AuctionItem[] arr2 = {a3, a1};
		AuctionItem[] arr3 = {a3, a1, a2, a4};
	
		boolean arraysEqual = false;
		AuctionItem[] result = null;

		arraysEqual = arrayEquals(arr0, arr1);
		displayResults(arraysEqual==false, "arr0 equals arr1 before add");
		
		result = A2Exercises.addItem(arr0, a3);
		arraysEqual = arrayEquals(result, arr1);
		displayResults(arraysEqual==true, "after add to arr0");
		
		result = A2Exercises.addItem(result, a1);
		arraysEqual = arrayEquals(result, arr2);
		displayResults(arraysEqual==true, "after second add to arr0");
		arraysEqual = arrayEquals(arr1, arr2);
		displayResults(arraysEqual==false, "arr1 equals arr2");
		
		result = A2Exercises.addItem(result, a2);
		result = A2Exercises.addItem(result, a4);
		arraysEqual = arrayEquals(result, arr3);
		displayResults(arraysEqual==true, "arr0 equals arr3 after 4 adds");
	}
	
	public static boolean arrayEquals(AuctionItem[] arr1, AuctionItem[] arr2) {
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (!arr1[i].equals(arr2[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void testSumOfBids() {
		System.out.println("\nTesting sumOfBids method");
		Person p1 = new Person("Gillian", "Flynn", 49);
		Person p2 = new Person("Veronica", "Roth", 32);
		Person p3 = new Person("Paula", "Hawkins", 48);
		Person p4 = new Person("John", "Green", 43);
		
		AuctionItem a1 = new AuctionItem("ruby necklace", 1600, 2500, p1);
		AuctionItem a2 = new AuctionItem("oil painting", 500, 510, p2);
		AuctionItem a3 = new AuctionItem("ancient map", 50, 800, p1);
		AuctionItem a4 = new AuctionItem("yoga membership", 1200, 1250, p1);
		AuctionItem a5 = new AuctionItem("Tesla Cyber Truck", 75000, 99000, p3);
		AuctionItem a6 = new AuctionItem("signed jersey", 350, 400, p4);
		AuctionItem a7 = new AuctionItem("all-inclusive getaway", 2200, 2800, p2);
		
		AuctionItem[] arr0 = {};
		AuctionItem[] arr1 = {a3};
		AuctionItem[] arr2 = {a3, a1};
		AuctionItem[] arr3 = {a3, a1, a2, a4, a5};
		AuctionItem[] arr4 = {a3, a1, a2, a4};
		AuctionItem[] arr5 = {a3, a1, a2};
		AuctionItem[] arr6 = {a3, a1, a2, a4, a5, a6, a7};
		
		int result = 0;
		int expected = 0;
		
		result = A2Exercises.sumOfBids(arr0);
		displayResults(result==expected, "sumOfBids in arr0");
		
		result = A2Exercises.sumOfBids(arr1);
		expected = 800;
		displayResults(result==expected, "sumOfBids in arr1");
		
		result = A2Exercises.sumOfBids(arr2);
		expected = 3300;
		displayResults(result==expected, "sumOfBids in arr2");
		
		result = A2Exercises.sumOfBids(arr3);
		expected = 2500+510+800+1250+99000;
		displayResults(result==expected, "sumOfBids in arr3");
		
		result = A2Exercises.sumOfBids(arr4);
		expected = 2500+510+800+1250;
		displayResults(result==expected, "sumOfBids in arr2");
		
		result = A2Exercises.sumOfBids(arr5);
		expected = 3810;
		displayResults(result==expected, "sumOfBids in arr2");
		
		result = A2Exercises.sumOfBids(arr6);
		expected = 2500+510+800+1250+99000+400+2800;
		displayResults(result==expected, "sumOfBids in arr2");
	}
	
	public static void testBidsByName() {
		System.out.println("\nTesting bidsByName method");
		Person p1 = new Person("Gillian", "Flynn", 49);
		Person p2 = new Person("Veronica", "Roth", 32);
		Person p3 = new Person("Paula", "Hawkins", 48);
		Person p4 = new Person("John", "Green", 43);
		
		AuctionItem a1 = new AuctionItem("ruby necklace", 1600, 2500, p1);
		AuctionItem a2 = new AuctionItem("oil painting", 500, 510, p2);
		AuctionItem a3 = new AuctionItem("ancient map", 50, 800, p1);
		AuctionItem a4 = new AuctionItem("yoga membership", 1200, 1250, p1);
		AuctionItem a5 = new AuctionItem("Tesla Cyber Truck", 75000, 99000, p3);
		AuctionItem a6 = new AuctionItem("signed jersey", 350, 400, p4);
		AuctionItem a7 = new AuctionItem("all-inclusive getaway", 2200, 2800, p2);
		
		AuctionItem[] arr0 = {};
		AuctionItem[] arr1 = {a3};
		AuctionItem[] arr2 = {a3, a1};
		AuctionItem[] arr3 = {a3, a1, a2, a4, a5, a6, a7};
		
		int result = 0;
		int expected = 0;
		
		result = A2Exercises.bidsByName(arr0, "Flynn");
		expected = 0;
		displayResults(result==expected, "bidsByName Flynn in arr0");
		
		result = A2Exercises.bidsByName(arr1, "Flynn");
		expected = 1;
		displayResults(result==expected, "bidsByName Flynn in arr1");
		
		result = A2Exercises.bidsByName(arr1, "Roth");
		expected = 0;
		displayResults(result==expected, "bidsByName Roth in arr1");
		
		result = A2Exercises.bidsByName(arr3, "Flynn");
		expected = 3;
		displayResults(result==expected, "bidsByName Flynn in arr3");
		
		result = A2Exercises.bidsByName(arr3, "Roth");
		expected = 2;
		displayResults(result==expected, "bidsByName Roth in arr3");

		result = A2Exercises.bidsByName(arr3, "Green");
		expected = 1;
		displayResults(result==expected, "bidsByName Roth in arr3");
		
	}
	
	public static void testCountGoodDeals(){
		System.out.println("\nTesting countGoodDeals method");

		Person p1 = new Person("Gillian", "Flynn", 49);
		Person p2 = new Person("Veronica", "Roth", 32);
		Person p3 = new Person("Paula", "Hawkins", 48);
		Person p4 = new Person("John", "Green", 43);
		
		AuctionItem a1 = new AuctionItem("ruby necklace", 1600, 2500, p1);
		AuctionItem a2 = new AuctionItem("oil painting", 500, 510, p2);
		AuctionItem a3 = new AuctionItem("ancient map", 50, 800, p1);
		AuctionItem a4 = new AuctionItem("yoga membership", 1200, 1250, p1);
		AuctionItem a5 = new AuctionItem("Tesla Cyber Truck", 75000, 99000, p3);
		AuctionItem a6 = new AuctionItem("signed jersey", 350, 400, p4);
		AuctionItem a7 = new AuctionItem("all-inclusive getaway", 2200, 2800, p2);
		
		AuctionItem[] arr0 = {};
		AuctionItem[] arr1 = {a2};
		AuctionItem[] arr2 = {a3, a1};
		AuctionItem[] arr3 = {a3, a1, a2, a4, a5};
		
		int result = 0;
		int expected = 0;
		
		result = A2Exercises.countGoodDeals(arr0, 10);
		expected = 0;
		displayResults(result==expected, "good deals in arr0");
		
		result = A2Exercises.countGoodDeals(arr1, 10);
		expected = 0;
		displayResults(result==expected, "good deals (10) in arr1");
		
		result = A2Exercises.countGoodDeals(arr1, 11);
		expected = 1;
		displayResults(result==expected, "good deals (11) in arr1");
		
		result = A2Exercises.countGoodDeals(arr2, 800);
		expected = 1;
		displayResults(result==expected, "good deals in arr0");
		
		result = A2Exercises.countGoodDeals(arr2, 250);
		expected = 0;
		displayResults(result==expected, "good deals in arr0");
		
		result = A2Exercises.countGoodDeals(arr3, 500);
		expected = 2;
		displayResults(result==expected, "good deals in arr0");
		
	}
	
	
	public static void displayResults (boolean passed, String testName) {
		/* There is some magic going on here getting the line number
		* Borrowed from:
		* http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
		*/

		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testName);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
									+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}    
}

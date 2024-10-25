/*
 * Lab6Tester.java
 */
public class Lab6Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

	public static void main (String[] args) {
		
		try {
			testBasicStack();
			testReverseString();
			testDoBracketsMatch();
			testQueue();
		} catch (Exception e) {
			
			System.out.println("Your code threw an Exception.");
			System.out.println("Perhaps a stack trace will help:");
			e.printStackTrace(System.out);
		}
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}

	public static void testBasicStack() {
		System.out.println("testBasicStack: start");

		Stack s;
		int subtestSize;
		boolean subtestResult;

		// Tests for isEmpty and size
		s = new StackArrayBased();
		displayResults(s.isEmpty(), "isEmpty on empty stack");
		displayResults(s.size() == 0, "size on empty stack");

		// Tests for push, isEmpty and size
		s = new StackArrayBased();
		s.push('a');
		displayResults(!s.isEmpty(), "isEmpty - stack with one element");
		displayResults(s.size() == 1, "size - stack with one element");

		// Tests for push, pop isEmpty and size
		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		displayResults(!s.isEmpty(), "isEmpty - stack with multiple elements");
		displayResults(s.size() == subtestSize, "size - stack with multiple elements");

		subtestResult = true;
		for (int i = subtestSize - 1; i >= 0; i--) {
			char ii = s.pop();
			subtestResult = subtestResult && (ii == (char)(i+'0'));
		}
		displayResults(subtestResult, "pop - stack with multiple elements");
		displayResults(s.isEmpty(), "isEmpty - after pop");
		displayResults(s.size() == 0, "size - after pop");

		// Tests for peek
		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		displayResults(!s.isEmpty(), "push + isEmpty");
		displayResults(s.size() == subtestSize, "push + size");
		subtestResult = true;
		for (int i = subtestSize - 1; i >= 0; i--) {
			char ii = s.peek();
			subtestResult = subtestResult && (ii == (char)((subtestSize - 1) + '0'));
		}
		displayResults(subtestResult, "push + peek");
		displayResults(!s.isEmpty(), "push + peek + isEmpty");
		displayResults(s.size() == subtestSize, "push + peek + size");

		// Tests for popAll + push
		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		s.popAll();
		displayResults( s.isEmpty(), "popAll + isEmpty - stack with multiple elements");

		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		s.popAll();
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		displayResults(!s.isEmpty(), "popAll + push + isEmpty - stack with multiple elements");
		displayResults(s.size() == subtestSize, "popAll + push + size - stack with multiple elements");

		// Tests for popAll + push + peek + pop
		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		s.popAll();
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		displayResults(s.peek() == (char)((subtestSize - 1) + '0'), "popAll + push + peek - stack with multiple elements");
		s.pop();
		displayResults(s.peek() == (char)((subtestSize - 2) + '0'), "popAll + push + pop + peek - stack with multiple elements");

		System.out.println("testBasicStack: end");
		System.out.println();
	}

	public static void testReverseString() {
		System.out.println("testReverseString: start");
		String resultString;
		String expected;

		resultString = reverseString("");
		expected = "";
		displayResults(resultString.equals(expected), "reverse empty String");

		resultString = reverseString("abc");
		expected = "cba";
		displayResults(resultString.equals(expected), "reverse \"abc\"");

		resultString = reverseString("abbada");
		expected = "adabba";
		displayResults(resultString.equals(expected), "reverse \"abbada\"");
		
		resultString = reverseString("stevie");
		expected = "eivets";
		displayResults(resultString.equals(expected), "reverse \"stevie\"");
		
		System.out.println("testReverseString: end");
		System.out.println();
	}

	public static void testDoBracketsMatch() {
		System.out.println("testDoBracketsMatch: start");
		
		boolean matched;
		matched = doBracketsMatch("");
		displayResults(matched, "doBracketsMatch empty String");

		matched = doBracketsMatch("(abc)");
		displayResults(matched, "doBracketsMatch \"(abc)\"");

		matched = doBracketsMatch("(a(bc))");
		displayResults(matched, "doBracketsMatch \"(a(bc))\"");

		matched = doBracketsMatch("(lm(def)))");
		displayResults(!matched, "doBracketsMatch \"(lm(def)))\"");

		matched = doBracketsMatch("k(lmn)ab)");
		displayResults(!matched, "doBracketsMatch \"k(lmn)ab)\"");

		matched = doBracketsMatch("((pa)t)rick)");
		displayResults(!matched, "doBracketsMatch \"(pa)t)rick)\"");

		matched = doBracketsMatch("mat)(l)ab)");
		displayResults(!matched, "doBracketsMatch \"mat)(l)ab)\"");
		
		System.out.println("testDoBracketsMatch: end");
		System.out.println();
	}



	/*
	 * Purpose: reverses str following this algorithm
	 *  - pushes each character in str onto a new StackArrayBased,
	 *  - creates a new empty result String
	 *  - pops each character off the Stack adding it to the result String
	 *  - returns the result String
	 * Parameters: String str - the String to reverse
	 * Returns: String - the reversed result String
	 */
	public static String reverseString(String str) {
		// TODO: complete this function
		// Your solution MUST use a Stack.
		String result = "";
		
		StackArrayBased stack = new StackArrayBased();
		for(int i = 0; i < str.length(); i++){
			stack.push(str.charAt(i));
		}
		
		while(!stack.isEmpty()){
			result += stack.pop();
		}

		return result;
	}

	/*
	 * Purpose: determines whether every '(' bracket
	 *  in str is matched with a following ')'
	 * Parameters: String str - the String check
	 * Returns: boolean - true if brackets are matched, false otherwise
	 */
	public static boolean doBracketsMatch(String str) {
		// TODO: complete this function
		// Your solution MUST use a Stack.
		// As you traverse the string,
		//  if you encounter a '(', push it on the stack
		//  if you encounter a ')', pop an element off the stack
		//  When can you return true?  When should you return false.
		// Tip: take time to work out an example on paper
		StackArrayBased stack = new StackArrayBased();
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i)=='(')
				stack.push(str.charAt(i));
			else if(str.charAt(i)==')'&&!stack.isEmpty()&&stack.peek()=='(')
				stack.pop();
			else if(stack.isEmpty()&&str.charAt(i)==')')
				return false;
		}
		
		return stack.isEmpty();
	}
	
	public static void testQueue() {
		System.out.println("testQueue: start");

		Queue<Integer> q;
		int subtestSize;
		boolean subtestResult;

		q = new QueueRefBased<Integer>();
		displayResults(q.isEmpty(), "isEmpty on empty queue");
		displayResults(q.size() == 0, "size on empty queue");

		q = new QueueRefBased<Integer>();
		q.enqueue(10);
		displayResults(!q.isEmpty(), "isEmpty - queue with one element");
		displayResults(q.size() == 1, "size - queue with one element");


		q = new QueueRefBased<Integer>();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			q.enqueue(i);
		}
		displayResults(!q.isEmpty(), "isEmpty - queue with multiple elements");
		displayResults(q.size() == subtestSize, "size - queue with multiple elements");

		subtestResult = true;
		for (int i = 0; i < subtestSize; i++) {
			int ii = q.dequeue();
			subtestResult = subtestResult && (ii == i);
		}
		displayResults(subtestResult, "dequeue - queue with multiple elements");
		displayResults(q.isEmpty(), "isEmpty - after dequeue");
		displayResults(q.size() == 0, "size - after dequeue");


		// Uncomment the tests below after you have updated the Queue so that it is 
		// generic and when it passes all the tests above.
		
		
        q = new QueueRefBased<Integer>();
        subtestSize = 10;
        for (int i = 0; i < subtestSize; i++) {
            q.enqueue(i);
        }
        displayResults(!q.isEmpty(), "isEmpty - queue with multiple elements");
        displayResults(q.size() == subtestSize, "size - queue with multiple elements");

        subtestResult = true;
        for (int i = 0; i < subtestSize; i++) {
            int ii = q.dequeue();
            subtestResult = subtestResult && (ii == i);
        }
        displayResults(subtestResult, "dequeue - queue with multiple elements");
        displayResults(q.isEmpty(), "isEmpty - after dequeue");
        displayResults(q.size() == 0, "size - after dequeue");


        q = new QueueRefBased<Integer>();
        q.enqueue(10);
        q.peek();
        displayResults( !q.isEmpty(), "enqueue/dequeue + isEmpty - queue with one elements");
        displayResults(q.size() == 1, "enqueue/dequeue + size - queue with one elements");


        q = new QueueRefBased<Integer>();
        subtestSize = 10;
        for (int i = 0; i < subtestSize; i++) {
            q.enqueue(i);
        }
        displayResults(!q.isEmpty(), "enqueue + isEmpty");
        displayResults(q.size() == subtestSize, "enqueue + size");
        subtestResult = true;
        for (int i = 0; i<subtestSize; i++) {
            int ii = q.peek();
            subtestResult = subtestResult && (ii == 0);
        }
        displayResults(subtestResult, "enqueue + peek");
        displayResults(!q.isEmpty(), "enqueue + peek + isEmpty");
        displayResults(q.size() == subtestSize, "enqueue + peek + size");

        q = new QueueRefBased<Integer>();
        subtestSize = 10;
        for (int i = 0; i < subtestSize; i++) {
            q.enqueue(i);
        }
        q.makeEmpty();
        displayResults(q.isEmpty(), "makeEmpty + isEmpty - queue with multiple elements");

        q = new QueueRefBased<Integer>();
        subtestSize = 10;
        for (int i = 0; i < subtestSize; i++) {
            q.enqueue(i);
        }
        q.makeEmpty();
        for (int i = 0; i < subtestSize; i++) {
            q.enqueue(i);
        }
        displayResults(!q.isEmpty(), "makeEmpty + enqueue + isEmpty - queue with multiple elements");
        displayResults(q.size() == subtestSize, "makeEmpty + enqueue + size - queue with multiple elements");


        q = new QueueRefBased<Integer>();
        subtestSize = 10;
        for (int i = 0; i < subtestSize; i++) {
            q.enqueue(i);
        }
        q.makeEmpty();
        for (int i = 0; i < subtestSize; i++) {
            q.enqueue(i);
        }
        displayResults(q.peek() == 0, "makeEmpty + enqueue + peek - queue with multiple elements");
        q.dequeue();
        displayResults(q.peek() == 1, "makeEmpty + enqueue + dequeue + peek - queue with multiple elements");

		//Testing generic queue with Character type
		QueueRefBased<Character> charQ;

		charQ = new QueueRefBased<Character>();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			charQ.enqueue((char)(i+'0'));
		}

		subtestResult = true;
		for (int i = 0; i < subtestSize; i++) {
			char ii = charQ.dequeue();
			subtestResult = subtestResult && (ii == (char)(i+'0'));
		}
		displayResults(subtestResult, "dequeue - queue with multiple elements");
		
		//Testing generic queue with Double Type
		QueueRefBased<Double> doubleQ;
		
		doubleQ = new QueueRefBased<Double>();
		subtestSize = 6;
		for(int i = 0; i < subtestSize; i++){
			doubleQ.enqueue(1.0*i);
		}
		displayResults(!doubleQ.isEmpty(), "makeEmpty + enqueue + isEmpty - queue with multiple elements");
        displayResults(doubleQ.size() == subtestSize, "makeEmpty + enqueue + size - queue with multiple elements");
		
		subtestResult = true;
		for (int i = 0; i < subtestSize; i++) {
			double ii = doubleQ.dequeue();
			subtestResult = subtestResult && (ii == i);
		}
		displayResults(subtestResult, "dequeue - queue with multiple elements");
		
		//Testing generic queue with String Type
		QueueRefBased<String> stringQ;
		
		stringQ = new QueueRefBased<String>();
		subtestSize = 5;
		for(int i = 0; i < subtestSize; i++){
			stringQ.enqueue(""+i);
		}
		displayResults(!stringQ.isEmpty(), "makeEmpty + enqueue + isEmpty - queue with multiple elements");
        displayResults(stringQ.size() == subtestSize, "makeEmpty + enqueue + size - queue with multiple elements");
		
		subtestResult = true;
		for (int i = 0; i < subtestSize; i++) {
			String ii = stringQ.dequeue();
			subtestResult = subtestResult && (ii.equals(""+i));
		}
		displayResults(subtestResult, "dequeue - queue with multiple elements");
		
		for(int i = 0; i < subtestSize; i++){
			stringQ.enqueue(""+i);
		}
		stringQ.makeEmpty();
		displayResults(stringQ.isEmpty(), "makeEmpty + enqueue + isEmpty - queue with multiple elements");
        displayResults(stringQ.size() == 0, "makeEmpty + enqueue + size - queue with multiple elements");
		
		System.out.println("testing Queue: end");
		System.out.println();
        
    }


	public static void displayResults (boolean passed, String testName) {
		/* There is some magic going on here getting the line number
		 * Borrowed from:
		 * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
		 */
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testCount);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
    
    
}

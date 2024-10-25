/*
 * A1Tester
 * A class to test the methods in Assignment 1
 */
public class A1Grader {

	private static int testPassCount = 0;
	private static int testCount = 0;

    public static void main(String[] args) {

		testNumFactors();
		testIsPrime();
		testGreatestCommonDenominator();
		testContains();
		testCountMatches();

		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }

	public static void testCalcPower() {
		int result = 0;
		int expected = 0;
		try {
                        result = A1Exercises.calcPower(2, 0);
        		displayResults("calcPower(2,0)", result==1);
                } catch (Exception e) {
			displayResults("calcPower(2,0)", false);                        
                }

		try {
			result = A1Exercises.calcPower(2, 3);
			expected = 2*2*2;
			displayResults("calcPower(2,3)", result==expected);
		} catch (Exception e) {
			displayResults("calcPower(2,3)", false);
		}

		try {
			result = A1Exercises.calcPower(5, 4);
			expected = 5*5*5*5;
			displayResults("calcPower(5,4)", result==expected);

		} catch (Exception e) {
			displayResults("calcPower(5,4)", false);
		}

		try {
			result = A1Exercises.calcPower(13, 2);
			expected = 13*13;
			displayResults("calcPower(13,2)", result==expected);

		} catch (Exception e) {
			displayResults("calcPower(13,2)", false);
		}

	}

	public static void testNumFactors() {
		int result = 0;
		int expected = 0;

		try {
			result = A1Exercises.numFactors(1);
			displayResults("numFactors(1)", result==1);

		} catch (Exception e) {
			displayResults("numFactors(1)", false);
		}

		try {
			result = A1Exercises.numFactors(6);
			expected = 4; // There are 4 factors of 6: 1, 2, 3, and 6
			displayResults("numFactors(6)", result==expected);

		} catch (Exception e) {
			displayResults("numFactors(6)", false);
		}

		try {
			result = A1Exercises.numFactors(24);
			expected = 8; // There are 8 factors of 6: 1,2,3,4,6,8,12,24
			displayResults("numFactors(24)", result==expected);

		} catch (Exception e) {
			displayResults("numFactors(24)", false);
		}

		try {
			result = A1Exercises.numFactors(51);
			expected = 4; // There are 4 factors of 6: 1,3,17,51
			displayResults("numFactors(51)", result==expected);

		} catch (Exception e) {
			displayResults("numFactors(51)", false);
		}

	}

	public static void testIsPrime() {
		boolean result = false;

		try {
			result = A1Exercises.isPrime(2);
			displayResults("isPrime(2)", result==true);

		} catch (Exception e) {
			displayResults("isPrime(2)", false);
		}


		try {
			result = A1Exercises.isPrime(6);
			displayResults("isPrime(6)", result==false);

		} catch (Exception e) {
			result = true;
			displayResults("isPrime(6)", false);
		}


		try {
			result = A1Exercises.isPrime(11);
			displayResults("isPrime(11)", result==true);

		} catch (Exception e) {
			result = false;
			displayResults("isPrime(11)", false);
		}


		try {
			result = A1Exercises.isPrime(15);
			displayResults("isPrime(15)", result==false);

		} catch (Exception e) {
			displayResults("isPrime(15)", false);
		}

		try {
			result = A1Exercises.isPrime(1046527);
			displayResults("isPrime(1046527)", result==true);

		} catch (Exception e) {
			displayResults("isPrime(1046527)", false);
		}

		try{
			result = A1Exercises.isPrime(1046529);
			displayResults("isPrime(1046529)", result==false);
		} catch (Exception e) {
			displayResults("isPrime(1046529)", false);
		}


	}

	public static void testGreatestCommonDenominator() {
		int result = 0;

		try {
			result = A1Exercises.greatestCommonDenominator(1,2);
			displayResults("gcd(1,2)", result==1);
		} catch (Exception e) {
			displayResults("gcd(1,2)", false);
		}

		try {
			result = A1Exercises.greatestCommonDenominator(30,105);
			displayResults("gcd(30,105)", result==15);

		} catch (Exception e) {
			displayResults("gcd(30,105)", false);

		}

		try {
			result = A1Exercises.greatestCommonDenominator(36,84);
			displayResults("gcd(36, 84)", result==12);

		} catch (Exception e) {
			displayResults("gcd(36, 84)", false);
		}

		try {
			result = A1Exercises.greatestCommonDenominator(25,200);
			displayResults("gcd(25, 200)", result==25);

		} catch (Exception e) {
			displayResults("gcd(25, 200)", false);
		}
	}

	public static void printArrayExample() {
		int array0[] = {};
		int array1[] = {8};
		int array2[] = {2, 3, 2, 0};
		int array3[] = {-1, 2, 4, 1, 3};

		A1Exercises.printArray(array0);
		A1Exercises.printArray(array1);
		A1Exercises.printArray(array2);
		A1Exercises.printArray(array3);
	}

	public static void testSumArray() {
		int result = 0;
		int expected = 0;
		int array0[] = {};
		int array1[] = {8};
		int array2[] = {2, 3, 2, 0};
		int array3[] = {-1, 2, 4, 1, 3};


		result = A1Exercises.sumArray(array0);
		displayResults("sumArray(array0)", result==0);

		result = A1Exercises.sumArray(array1);
		expected = 8;
		displayResults("sumArray(array1)", result==expected);
		//System.out.println("Expected: "+expected+", result: "+result);

		result = A1Exercises.sumArray(array2);
		expected = 2+3+2;
		displayResults("sumArray(array2)", result==expected);
		//System.out.println("Expected: "+expected+", result: "+result);

		result = A1Exercises.sumArray(array3);
		expected = -1+2+4+1+3;
		displayResults("sumArray(array3)", result==expected);
		//System.out.println("Expected: "+expected+", result: "+result);
	}

	public static void testContains() {
		boolean result;
		int arr1[] = {2, 3, 2, 0};
		int arr2[] = {-1, 2, 4, 1, 3};

		try {
			result = A1Exercises.contains(arr1, 2);
			displayResults("arr1 contains 2", result==true);

		} catch (Exception e) {
			displayResults("arr1 contains 2", false);
		}

		try {
			result = A1Exercises.contains(arr1, 0);
			displayResults("arr1 contains 0", result==true);

		} catch (Exception e) {
			displayResults("arr1 contains 0", false);
		}

		try {
			result = A1Exercises.contains(arr1, 4);
			displayResults("arr1 contains 4", result==false);

		} catch (Exception e) {
			displayResults("arr1 contains 4", false);
		}

		try {
			result = A1Exercises.contains(arr2, 4);
			displayResults("arr2 contains 4", result==true);

		} catch (Exception e) {
			displayResults("arr2 contains 4", false);
		}

		try {
			result = A1Exercises.contains(arr2, 3);
			displayResults("arr2 contains 3", result==true);

		} catch (Exception e) {
			displayResults("arr2 contains 3", false);
		}

		try {
			result = A1Exercises.contains(arr2, 5);
			displayResults("arr2 contains 5", result==false);

		} catch (Exception e) {
			displayResults("arr2 contains 5", false);
		}

	}

	public static void testCountMatches() {
		int result = 0;
		int expected = 0;
		int arr1[] = {2, 3, 2, 0};
		int arr2[] = {7, 1, 5, 3, 8, 7, 7, 3, 1, 4, 7};
		// add more arrays

		try {
			result = A1Exercises.countMatches(arr1, 1);
			displayResults("countMatches(arr1, 1)", result==0);

		} catch (Exception e) {
			displayResults("countMatches(arr1, 1)", false);
		}

		try {
			result = A1Exercises.countMatches(arr1, 3);
			displayResults("countMatches(arr1, 3)", result==1);

		} catch (Exception e) {
			displayResults("countMatches(arr1, 3)", false);
		}

		try {
			result = A1Exercises.countMatches(arr1, 2);
			displayResults("countMatches(arr1, 2)", result==2);

		} catch (Exception e) {
			displayResults("countMatches(arr1, 2)", false);
		}

		try {
			result = A1Exercises.countMatches(arr2, 1);
			displayResults("countMatches(arr2, 1)", result==2);

		} catch (Exception e) {
			displayResults("countMatches(arr2, 1)", false);
		}

		try {
			result = A1Exercises.countMatches(arr2, 7);
			displayResults("countMatches(arr2, 7)", result==4);

		} catch (Exception e) {
			displayResults("countMatches(arr2, 7)", false);
		}

		try {
			result = A1Exercises.countMatches(arr2, 2);
			displayResults("countMatches(arr2, 2)", result==0);

		} catch (Exception e) {
			displayResults("countMatches(arr2, 2)", false);
		}
	}

	public static void displayResults (String testName, boolean passed) {
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

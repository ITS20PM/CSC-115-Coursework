/*
 * Lab2Tester.java
 *
 * A tester for the methods in Lab2.java
 *
 */
import java.util.Arrays;

public class Lab2Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

	// for approximate comparison of floating point numbers
	private static final double THRESHOLD = 0.01;

	public static void main(String[] args) {
		
		testGetHigherGradeStudent();
		testIsGradeAbove();
		testGetClasslist();
		testCountAbove();
		testGetClassAverage();
		testRegisterStudent();

		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testGetHigherGradeStudent() {
		// TODO: once you have implemented getHigherGradeStudent in Lab2.java
		//  uncomment the following tests - make sure you understand what they are testing

		
		Student s0  = new Student("abc", 50);
		Student s1a = new Student("def", 56);
		Student s1b = new Student("xyz", 56);
		Student s2  = new Student("xyz", 99);

		Student result;

		result = Lab2.getHigherGradeStudent(s0,s1a);
		System.out.println("should be  " + s1a + " is " + result);
		displayResults(result.equals(s1a), "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1a,s0);
		System.out.println("should be  " + s1a + " is " + result);
		displayResults(result.equals(s1a), "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1b,s1a);
		System.out.println("should be  " + s1b + " is " + result);
		displayResults(result.equals(s1b) && result == s1b, "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1b,s2);
		System.out.println("should be  " + s2 + " is " + result);
		displayResults(result.equals(s2), "testGetHigherGradeStudent");
		
	}

	public static void testIsGradeAbove() {
		// TODO: write tests for Lab2.isGradeAbove

		Student s0 = new Student("al", 60);
		Student s1 = new Student("rob", 66);
		Student s2 = new Student("bob", 80);
		Student s3 = new Student("pat", 50);
		
		boolean isGradeAbove = false;
		
		isGradeAbove = Lab2.isGradeAbove(s0, 70);
		displayResults(isGradeAbove==false, "testIsGradeAbove");
		
		isGradeAbove = Lab2.isGradeAbove(s1, 60);
		displayResults(isGradeAbove==true, "testIsGradeAbove");
		
		isGradeAbove = Lab2.isGradeAbove(s2, 72);
		displayResults(isGradeAbove==true, "testIsGradeAbove");
		
		isGradeAbove = Lab2.isGradeAbove(s3, 82);
		displayResults(isGradeAbove==false, "testIsGradeAbove");
		
	}

	public static void testGetClasslist() {
		// TODO: write tests for Lab2.getClasslist

		// NOTE: the Arrays library has been imported for you.
		//       you can use the Arrays.equals method to compare
		//       2 arrays of String objects as String has a equals method
		// The API for Arrays.equals:
		//       equals(Object[] a, Object[] a2)
		//       Returns true if the two specified arrays are equal to one another.

		// TODO: once you have implemented getClasslist in Lab2.java
		// uncomment the following test. We have gotten you started with 
		// some initial test data and one test, but you should consider 
		// other cases (empty array, longer array)

		
		Student s0  = new Student("abc", 50);
		Student[] students1 = {s0};
		String[] expected1 = {"abc"};

		String[] result;

		result = Lab2.getClasslist(students1);
		displayResults(Arrays.equals(result, expected1), "testGetClasslist - 1 elements");
		
		Student s1  = new Student("rbc", 60);
		Student s2  = new Student("cnn", 70);
		Student s3  = new Student("abb", 57);
		
		Student[] students2 = {s1, s2, s3};
		String[] expected2 = {"rbc", "cnn", "abb"};
		
		result = Lab2.getClasslist(students2);
		displayResults(Arrays.equals(result, expected2), "testGetClasslist - 3 elements");
	}


	public static void testCountAbove() {
		// TODO: write tests for Lab2.countAbove
	
		Student s0 = new Student("al", 60);
		Student s1 = new Student("rob", 66);
		Student s2 = new Student("bob", 80);
		Student s3 = new Student("pat", 50);
		Student s4 = new Student("paul", 70);
		Student s5 = new Student("lee", 84);
		Student[] studentsList = {s0, s1, s2, s3, s4, s5};
		
		int result = 0;
		
		result = Lab2.countAbove(studentsList, 60);
		displayResults(result==4, "testCountAbove");
		
		
		Student r0 = new Student("ant", 56);
		Student r1 = new Student("dave", 63);
		Student[] studentsList2 = {r0, r1};
		
		result = Lab2.countAbove(studentsList2, 72);
		displayResults(result==0, "testCountAbove");
		
		
		Student q0 = new Student("bib", 56);
		Student q1 = new Student("ron", 56);
		Student q2 = new Student("bon", 74);
		Student q3 = new Student("pi", 90);
		Student[] studentsList3 = {q0, q1, q2, q3};
		
		result = Lab2.countAbove(studentsList3, 65);
		displayResults(result==2, "testCountAbove");
		
		Student p0 = new Student("bib", 76);
		Student[] studentsList4 = {p0};
		
		result = Lab2.countAbove(studentsList4, 50);
		displayResults(result==1, "testCountAbove");
	}


	public static void testGetClassAverage() {
		Student s0 = new Student("abc", 50);
		Student s1 = new Student(); // considered invalid for average average calculation
		Student s2 = new Student("xyz", 99);
		Student s3 = new Student("def", 88);

		Student[] students0 = {};
		Student[] students1 = {s0};
		Student[] students2 = {s0, s1, s2};
		Student[] students3 = {s0, s2, s3};

		double result = 0.0;
		double expected = 0.0;
		
		// Some of you noticed in Lab1 that floating point arithmetic sometimes
		// produces results with many decimals places. We use the threshold
		// (defined as a global variable at the top) to specify the margin 
		// of error we are okay with, and just make sure the expected and 
		// returned results are within the threshold of acceptable error.

		result = Lab2.getClassAverage(students0);
		expected = 0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - empty");

		result = Lab2.getClassAverage(students1);
		expected = 50.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - 1 student");

		result = Lab2.getClassAverage(students2);
		expected = (50 + 99) / 2.0; // because s1 does not have a "real" grade
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - 3 students, count 2");

		result = Lab2.getClassAverage(students3);
		expected = (50 + 99 + 88) / 3.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - 3 students, count 3");
	}

	public static void testRegisterStudent() {
		// TODO: write tests for Lab2.registerStudent
		// HINT: the Student class also has a equals method so you
		// can use Arrays.equals again to compare 2 Student arrays
		
		Student s0 = new Student("al", 60);
		Student s1 = new Student("rob", 66);
		Student s2 = new Student("bob", 80);
		Student s3 = new Student("pat", 50);
		Student[] studList = {s0, s1, s2, s3};
		Student newStud = new Student("bill", 65);
		
		Student[] expected = {s0, s1, s2, s3, newStud};
		Student[] result = Lab2.registerStudent(studList, newStud);
		printArray(result);
		displayResults(Arrays.equals(expected, result), "testRegisterStudent");
		
		Student r0 = new Student("bo", 70);
		Student[] studList2 = {r0};
		Student r1 = new Student("sat", 56);
		
		Student[] expected1 = {r0, r1};
		Student[] result1 = Lab2.registerStudent(studList2, r1);
		printArray(result1);
		displayResults(Arrays.equals(expected1, result1), "testRegisterStudent");
	
		Student[] studList3 = {};
		Student q1 = new Student("sun", 78);
		
		Student[] expected2 = {q1};
		Student[] result2 = Lab2.registerStudent(studList3, q1);
		printArray(result2);
		displayResults(Arrays.equals(expected2, result2), "testRegisterStudent");

	}
	
	public static void printArray(Student[] s){
		System.out.print("{");
		for(int i = 0; i < s.length-1; i++){
			System.out.print(s[i]+", ");
		}
		if(s.length>=1)
			System.out.print(s[s.length-1]);
		System.out.println("}");
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

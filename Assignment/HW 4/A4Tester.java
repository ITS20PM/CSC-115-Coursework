import java.util.Arrays;

public class A4Tester {
	
	private static int testPassCount = 0;
	private static int testCount = 0;
	private static double THRESHOLD = 0.1; // allowable margin of error for floating point results
	
	private static A4List list0 = null;
	private static A4List list1 = null;
	private static A4List list2 = null;
	private static A4List list3 = null;
	private static A4List list4 = null;
	private static A4List list5 = null;
	
    public static void main(String[] args) {
		
		// PART I
		// implement and test each of the following methods
		// found in A4Exercises.java, one at a time
		
		testSubtractFromAll();
		testArrayContains();
		testIsSorted();
		

		// PART II
		// implement and test each of the following methods
		// found in A4LinkedList.java, one at a time.
		// Documentation can be found in A4List.java

		initLists(); // this is required for all the testing methods below
		
		testInProgram();
		testGetStudent();
		testAverageGPA();
		testProgramAverage();
		testLowestGPA();
		
		System.out.println("\nPASSED " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testSubtractFromAll() {
		System.out.println("\nStarting subtractFromAll tests");
		
		int[] arr0 = {};
		int[] arr1 = {7, 1, 3};
		int[] arr2 = {9, 2, 7, 3, 0, 6};
		
		int[] expected0 = {};
		int[] expected1 = {6, 0, 2};
		int[] expected2 = {3, -3, -1};
		int[] expected3 = {4, -3, 2, -2, -5, 1};
		
		A4Exercises.subtractFromAll(arr0, 1);
		displayResults(Arrays.equals(arr0, expected0), "subtract 1 from all values in empty array");
		
		A4Exercises.subtractFromAll(arr1, 1);
		displayResults(Arrays.equals(arr1, expected1), "subtract 1 from all values in arr1");
		
		A4Exercises.subtractFromAll(arr1, 3);
		displayResults(Arrays.equals(arr1, expected2), "subtract 3 from all values in updated arr1");
		
		A4Exercises.subtractFromAll(arr2, 5);
		displayResults(Arrays.equals(arr2, expected3), "subtract 5 from all values in arr2");
	}
	
	public static void testArrayContains() {
		System.out.println("\nStarting arrayContains tests");
		int[] arr0 = {};
		int[] arr1 = {7, 1, 3};
		int[] arr2 = {9, 2, 7, 3, 0, 6};
		
		boolean result = false;
		
		result = A4Exercises.arrayContains(arr0, 4);
		displayResults(!result, "empty array contains 4");
		
		result = A4Exercises.arrayContains(arr1, 1);
		displayResults(result, "arr1 contains 1");
		result = A4Exercises.arrayContains(arr1, 2);
		displayResults(!result, "arr1 contains 2");

		result = A4Exercises.arrayContains(arr2, 9);
		displayResults(result, "arr2 contains 9");		
		result = A4Exercises.arrayContains(arr2, 6);
		displayResults(result, "arr2 contains 6");
		result = A4Exercises.arrayContains(arr2, 5);
		displayResults(!result, "arr2 contains 5");
		
	}
		
	public static void testIsSorted() {
		System.out.println("\nStarting isSorted tests");
		int[] arr0 = {};
		int[] arr1 = {3};
		int[] arr2 = {3, 4, 5};
		int[] arr3 = {5, 4, 3};
		int[] arr4 = {3, 4, 4};
		int[] arr5 = {4, 4, 4};
		int[] arr6 = {2, 2, 4, 4, 6};
		int[] arr7 = {2, 3, 4, 5, 6, 5};

		
		boolean result = false;
		
		result = A4Exercises.isSorted(arr0);
		displayResults(result, "isSorted, empty array");
		
		result = A4Exercises.isSorted(arr1);
		displayResults(result, "isSorted, one element array");
		
		result = A4Exercises.isSorted(arr2);
		displayResults(result, "isSorted, {3,4,5}");
		
		result = A4Exercises.isSorted(arr3);
		displayResults(!result, "isSorted, {5,4,3}");
		
		result = A4Exercises.isSorted(arr4);
		displayResults(result, "isSorted, {3,4,4}");

		result = A4Exercises.isSorted(arr4);
		displayResults(result, "isSorted, {4,4,4}");

		result = A4Exercises.isSorted(arr6);
		displayResults(result, "isSorted, {2,2,4,4,6}");

		result = A4Exercises.isSorted(arr7);
		displayResults(!result, "isSorted, {2,3,4,5,6,5}");

	}
	
	public static void initLists() {
		
		// This function creates lists of students for you 
		// to use for testing the A4LinkedList methods
		
		// It does not need to be modified, but you are welcome
		// to create new lists for further testing
		
		Student s1 = new Student("v00123", 6.7, "Geography");
		Student s2 = new Student("v00555", 7.8, "Physics");
		Student s3 = new Student("v00987", 4.5, "Psychology");
		Student s4 = new Student("v00246", 9.0, "Geography");
		Student s5 = new Student("v00357", 8.2, "Mathematics");
		Student s6 = new Student("v00149", 7.2, "Physics");
		Student s7 = new Student("v00001", 8.4, "Geography");
		Student s8 = new Student("v00820", 4.1, "Chemistry");
		Student s9 = new Student("v00010", 3.7, "Engineering");
			
		list0 = new A4LinkedList();
		
		list1 = new A4LinkedList();
		list1.insert(s5);
		
		list2 = new A4LinkedList();
		list2.insert(s5);
		list2.insert(s6);
		list2.insert(s1);
		
		list3 = new A4LinkedList();
		list3.insert(s5);
		list3.insert(s6);
		list3.insert(s1);
		list3.insert(s4);
		list3.insert(s3);
		list3.insert(s2);
		list3.insert(s7);
		
		list4 = new A4LinkedList();
		list4.insert(s8);
		list4.insert(s1);
		list4.insert(s2);
		list4.insert(s3);
		list4.insert(s4);
		list4.insert(s5);
		list4.insert(s6);
		list4.insert(s7);
	
		list5 = new A4LinkedList();
		list5.insert(s1);
		list5.insert(s2);
		list5.insert(s3);
		list5.insert(s4);
		list5.insert(s5);
		list5.insert(s6);
		list5.insert(s7);
		list5.insert(s9);
	
	}

	
	public static void testInProgram() {
		System.out.println("\nStarting inProgram tests");
		/* List contents:
		list0: empty
		
		list1: v00357:8.2:Mathematics
		
		list2: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography
		
		list3: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography, v00246:9.0:Geography
					v00987:4.5:Psychology, v00555:7.8:Physics, v00001:8.4:Geography
		*/
		
		int result = 0;
		int expected = 0;
		
		result = list0.inProgram("Geography");
		expected = 0;
		displayResults(result==expected, "inProgram on empty list searching for Geography");
		
		result = list1.inProgram("Geography");
		expected = 0;
		displayResults(result==expected, "inProgram on list1 searching for Geography");
		
		result = list1.inProgram("Mathematics");
		expected = 1;
		displayResults(result==expected, "inProgram on list1 searching for Mathematics");
		
		result = list3.inProgram("Geography");
		expected = 3;
		displayResults(result==expected, "inProgram on list3 searching for Geography");
		
		result = list3.inProgram("Mathematics");
		expected = 1;
		displayResults(result==expected, "inProgram on list3 searching for Mathematics");
		
		result = list3.inProgram("Biology");
		expected = 0;
		displayResults(result==expected, "inProgram on list3 searching for Biology");
		
		result = list3.inProgram("Physics");
		expected = 2;
		displayResults(result==expected, "inProgram on list3 searching for Physics");
	}
	
	public static void testGetStudent() {
		System.out.println("\nStarting getStudent tests");
		/* List contents:
		list0: empty
		
		list1: v00357:8.2:Mathematics
		
		list2: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography
		
		list3: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography, v00246:9.0:Geography
					v00987:4.5:Psychology, v00555:7.8:Physics, v00001:8.4:Geography
		*/
		
		Student toFind1 = new Student("v00357", 8.2, "Mathematics");
		Student toFind2 = new Student("v00321", 7.2, "Chemistry");
		Student toFind3 = new Student("v00001", 8.4, "Geography");
		
		Student result = null;
		
		result = list0.getStudent("v00357");
		displayResults(result==null, "searching for student v00357 in empty list");
		
		result = list1.getStudent("v00357");
		displayResults(result.equals(toFind1), "searching for student v00357 in list1");
		result = list1.getStudent("v00321");
		displayResults(result==null, "searching for student v00321 in list1");
		
		result = list3.getStudent("v00357");
		displayResults(result.equals(toFind1), "searching for student v00357 in list3");
		result = list3.getStudent("v00321");
		displayResults(result==null, "searching for student v00321 in list3");
		result = list3.getStudent("v00001");
		displayResults(result.equals(toFind3), "searching for student v00001 in list3");
		
	}
	
	public static void testAverageGPA() {
		System.out.println("\nStarting averageGPA tests");
		/* List contents:
		list0: empty
		
		list1: v00357:8.2:Mathematics
		
		list2: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography
		
		list3: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography, v00246:9.0:Geography
					v00987:4.5:Psychology, v00555:7.8:Physics, v00001:8.4:Geography
		*/
		
		double result = 0.0;
		double expected = 0.0;
		
		result = list0.averageGPA();
		displayResults(result==expected, "average GPA in an empty list");
		
		result = list1.averageGPA();
		expected = 8.2;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA in list1");
		
		result = list2.averageGPA();
		expected = (6.7+7.2+8.2)/3;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA in list2");
		
		result = list3.averageGPA();
		expected = (8.2+7.2+6.7+9.0+4.5+7.8+8.4)/7;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA in list3");
		
	}
	
	public static void testProgramAverage() {
		System.out.println("\nStarting programAverage tests");
		/* List contents:
		list0: empty
		
		list1: v00357:8.2:Mathematics
		
		list2: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography
		
		list3: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography, v00246:9.0:Geography
					v00987:4.5:Psychology, v00555:7.8:Physics, v00001:8.4:Geography
		*/
		
		double result = 0.0;
		double expected = 0.0;
		
		result = list0.programAverage("Mathematics");
		displayResults(result==expected, "average GPA of students in Geography, empty list");
		
		result = list1.programAverage("Mathematics");
		expected = 8.2;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA of students in Geography, list1");
		
		result = list1.programAverage("Physics");
		expected = 0.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA of students in Physics, list1");

		result = list2.programAverage("Geography");
		expected = 6.7;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA of students in Geography, list2");
		
		result = list3.programAverage("Geography");
		expected = (6.7+9.0+8.4)/3;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA of students in Geography, list3");
		
		result = list3.programAverage("Biology");
		expected = 0.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA of students in Geography, list3");
		
		result = list3.programAverage("Physics");
		expected = (7.8+7.2)/2;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA of students in Geography, list3");
		
		result = list4.programAverage("Chemistry");
		expected = 4.1;
		displayResults(Math.abs(result-expected)<THRESHOLD, "average GPA of students in Geography, list3");
		
		
	}
	
	public static void testLowestGPA() {
		System.out.println("\nStarting lowestGPA tests");
		/* List contents:
		list0: empty
		
		list1: v00357:8.2:Mathematics
		
		list2: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography
		
		list3: v00357:8.2:Mathematics, v00149:7.2:Physics, v00123:6.7:Geography, v00246:9.0:Geography
					v00987:4.5:Psychology, v00555:7.8:Physics, v00001:8.4:Geography
		*/
		
		Student result = null;
		Student expected = null;
		
		result = list0.lowestGPA();
		displayResults(result==expected, "highest GPA student in empty list");
		
		result = list1.lowestGPA();
		expected = new Student("v00357", 8.2, "Mathematics");
		displayResults(result.equals(expected), "highest GPA student in list1");
		
		result = list2.lowestGPA();
		expected = new Student("v00123", 6.7, "Geography");
		displayResults(result.equals(expected), "highest GPA student in list2");
		
		result = list3.lowestGPA();
		expected = new Student("v00987", 4.5, "Psychology");
		displayResults(result.equals(expected), "highest GPA student in list3");
		
		result = list4.lowestGPA();
		expected = new Student("v00820", 4.1, "Chemistry");
		displayResults(result.equals(expected), "highest GPA student in list4");
		
		result = list5.lowestGPA();
		expected = new Student("v00010", 3.7, "Engineering");
		displayResults(result.equals(expected), "highest GPA student in list5");
		
		Student s6 = new Student("v00149", 7.2, "Physics");
		Student s7 = new Student("v00001", 8.4, "Geography");
		
		list1.insert(s6);
		result = list1.lowestGPA();
		expected = new Student("v00149", 7.2, "Physics");
		displayResults(result.equals(expected), "highest GPA student in list1");
		
		list2.insert(s7);
		result = list2.lowestGPA();
		expected = new Student("v00123", 6.7, "Geography");
		displayResults(result.equals(expected), "highest GPA student in list2");
	}
	
	public static void displayResults (boolean passed, String testName) {
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
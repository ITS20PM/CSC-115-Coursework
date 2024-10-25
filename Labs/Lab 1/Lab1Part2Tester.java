/*
 * Lab1Part2Tester.java
 *
 * A tester for the methods in your Student class
 *
 */
public class Lab1Part2Tester {

	public static void main(String[] args) {
		testConstructorsAndGetters();
		testSettersAndGetters();
		testToString();
		
		Student s1 = new Student("V00923094", 35);
		Student s2 = new Student("V00923194", 45);
		System.out.println("\nIs s1 equal to s2: "+s1.equals(s2));
	}

	public static void testConstructorsAndGetters() {

		// 1)
		// Tests constructor with no arguments, getSID and getGrade
		// TODO: once you have created a Student class with a
		// default constructor, getSID and getGrade methods
		// uncomment the following to test your implementation
	
	
		Student s = new Student();
		System.out.println("sID of student with default constructor: " + s.getSID());
		System.out.println("grade of student with default constructor: " + s.getGrade());
	
	
		// 2)
		// TODO: Once you have added the second contructor to your 
		// Student class, write tests below to test the constructor with 
		// arguments using getSID and getGrade similar to the tests above.

	
		Student s2 = new Student("V00923094", 35);
		System.out.println("sID of student with default constructor: " + s2.getSID());
		System.out.println("grade of student with default constructor: " + s2.getGrade());
	
		
	}

	public static void testSettersAndGetters(){
		// 3) 
		// TODO: implement and then call the setSID and setGrade methods
		// Hint: use getSID and getGrade methods to get the updated values
		
		System.out.println("\nOriginal information for student:");
		Student s2 = new Student("V00923094", 35);
		System.out.println("sID of student: " + s2.getSID());
		System.out.println("grade of student: " + s2.getGrade());
		
		s2.setSID("V00934970");
		s2.setGrade(50);
		
		System.out.println("\nUpdated information for student:");
		System.out.println("sID of student: " + s2.getSID());
		System.out.println("grade of student: " + s2.getGrade());
		
	}

	public static void testToString() {
		// 4)
		// TODO: once you have written toString in the Student class,
		// create a student object and test the toString method
		
		Student s = new Student("V00923094", 35);
		System.out.println(s);
	}
}

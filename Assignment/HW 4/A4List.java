public interface A4List {
    
	/*****************************************************************
	* The first 3 methods are completed for you in A4LinkedList.java *
	*****************************************************************/
	
	/*
	 * Purpose: get the number of elements in the list
	 * Parameters: none
	 * Returns: int - the number of elements in the list
	 */	
	public int size();
	
	/*
	 * Purpose: determines whether the list is empty
	 * Parameters: none
	 * Returns: boolean - true if empty, false otherwise
	 */	
	public boolean isEmpty();
	
	/*
	 * Purpose: inserts a student at the back of the list
	 * Parameters: Student s - the student to insert
	 * Returns: void - nothing
	 */
	public void insert(Student s);
	
	
	/****************************************************
	* You will need to complete the following 5 methods *
	****************************************************/
	
	/*
	 * Purpose: counts the number of students found in the list 
	 *          that are enrolled in the given program
	 * Parameters: String - the program to search for
	 * Returns: int - the number of students in given program
	 * Precondition: program is not null
	 */
	public int inProgram(String program);
	
	/*
	 * Purpose: gets a student with the given sID, if the 
	 *          list contains a student with the given sID
	 * Parameters: String - the sID to search for
	 * Returns: Student - the student if found, null otherwise
	 * Precondition: sID is not null
	 */
	public Student getStudent(String sID);
	
	/*
	 * Purpose: get the average GPA of all students in the list
	 * Parameters: none
	 * Returns: double - the average GPA of all students
	 */
	public double averageGPA();
	
	/*
	 * Purpose: gets the average GPA of all students in the given program
	 * Parameters: String - the program to search for
	 * Returns: double - the average gpa of all students in given program
	 * Precondition: program is not null
	 */
	public double programAverage(String program);
	
	/*
	 * Purpose: get the student with the lowest GPA in the list
	 * Parameters: none
	 * Returns: Student - the student with the lowest GPA
	 *          or null if the list is empty
	 * Precondition: no two students will have the same GPA
	 */
	public Student lowestGPA();

}




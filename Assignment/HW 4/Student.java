/*
 * Student.java
 * A Student class
 */
public class Student {

	private String sID;
	private double gpa;
	private String program;

	public Student(String sID, double gpa, String program) {
		this.sID = sID;
		this.gpa = gpa;
		this.program = program;
	}
	
	/*
	 * Purpose: set's this Student's sID to sID parameter value
	 * Parameters: String - sID
	 * Returns: nothing
	 */
	public void setSID(String sID) {
		this.sID = sID;
	}

	/*
	 * Purpose: returns this Student's sID
	 * Parameters: none
	 * Returns: String - the sID
	 */
	public String getSID() {
		return this.sID;
	}
	
	/*
	 * Purpose: set's this Student's gpa
	 * Parameters: double - gpa
	 * Returns: nothing
	 */
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}

	/*
	 * Purpose: returns this Student's grade
	 * Parameters: none
	 * Returns: double - the gpa
	 */
	public double getGPA() {
		return this.gpa;
	}
	
	/*
	 * Purpose: set's this Student's program
	 * Parameters: String - program
	 * Returns: nothing
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/*
	 * Purpose: returns this Student's program
	 * Parameters: none
	 * Returns: String - the program
	 */
	public String getProgram() {
		return this.program;
	}

	/*
	 * Purpose: returns a String representation of this Student
	 *          in the form "sID:grade"
	 * Parameters: none
	 * Returns: String - the representation
	 *
	 */
	public String toString() {
		return sID + ":" + gpa + ":" + program;
	}

	/*
	 * Purpose: returns true if this Student's sID
	 *          equals the other Student's sID
	 * Parameters: none
	 * Returns: boolean - true if equal, false otherwise
	 */
	public boolean equals(Student other) {
		return (this.sID.equals(other.sID));
	}
    
}

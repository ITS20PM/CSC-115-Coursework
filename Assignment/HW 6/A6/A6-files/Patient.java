/*
 * Represents a hospital patient
 *
 * We have implemented some methods and constructors.
 * we have left the documentation for you to follow
 * to implement the compareTo and equals methods
 */

public class Patient implements Comparable<Patient>{

	private int priorityLevel;
	private String name;
	private String waitingNumber;
	private Time checkinTime;

	public Patient(int priorityLevel, String name, String waitingNumber, Time checkinTime) {
		this.priorityLevel = priorityLevel;
		this.name = name;
		this.waitingNumber = waitingNumber;
		this.checkinTime = checkinTime;
	}

	public int getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel (int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public String getName() {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getWaitingNumber() {
		return waitingNumber;
	}

	public void setWaitingNumber (String waitingNumber) {
		this.waitingNumber = waitingNumber;
	}

	public Time getTime() {
		return checkinTime;
	}

	public void setTime (Time checkinTime) {
		this.checkinTime = checkinTime;
	}

	public String toString() {
		return name + ":" + waitingNumber;
	}

	/* Method Name: compareTo
	 * Purpose: returns the result of comparing this patient with other
	 * Parameters: Patient other
	 * Returns: a value < 0 if this patient is before other patient
	 *          a value == 0 if this patient is the same as other patient
	 *          a value >0 if this patient is after other patient
	 * Precondition: other is not null
	 *
	 * Notes on how to compare patients:
	 * Two patients are compared by their priorityLevel.
	 * If priorityLevels are equal, their checkinTimes are compared
	 *
	 * HINT: the Time class implements compareable too!
	 */
	public int compareTo(Patient other) {
		//TODO: implement this
		if(this.priorityLevel < other.getPriorityLevel())
			return -1; 
		else if(this.priorityLevel > other.getPriorityLevel())
			return 1;
		else{
			if(this.checkinTime.compareTo(other.getTime())<0)
				return -1;
			else if(this.checkinTime.compareTo(other.getTime())>0)
				return 1;
			return 0;
		}
	}

	/* Method Name: equals
	 * Purpose: determines whether the waiting number of this 
	 *          patient is the same as the other patient's
	 * Parameters: Patient other
	 * Returns: true if this Patient is the same as other, false otherwise
	 * Precondition: other is not null
	 */
	public boolean equals(Patient other) {
		//TODO: implement this
		return this.waitingNumber.equals(other.getWaitingNumber());
	}
}


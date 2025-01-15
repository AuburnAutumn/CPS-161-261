package registrationProblem;

public class Course {
	private String department;
	private String courseName;
	private int maxClassSize;
	private int currentEnrollmentNumber = 0;
	private Student[] currentEnrollment;
	private Faculty instructor;

	public Course(String department, String courseName, int maxClassSize) {
		super();
		this.department = department;
		this.courseName = courseName;
		this.maxClassSize = maxClassSize;
		this.currentEnrollment = new Student[maxClassSize];

	}

	public boolean alreadyRegistered(Student student) {
		boolean registered = false;
		for (int i = 0; i < this.currentEnrollment.length; i++) {
			if (student.equals(currentEnrollment[i])) {
				;
				registered = true;
			}
		}
		return registered;

	}

	public void assignInstructor(Faculty instructor) {
		if (instructor.department == this.department) {
			System.out.println(instructor.getName() + " has been assigned to teach this class");
			this.instructor = instructor;
		} else {
			System.out.println(instructor.getName() + " cannot be assigned to teach this class. Instructors must belong to the same department as their classes");
		}
	}

	public void displayRoster() {
		if (currentEnrollmentNumber > 0) {
			System.out.println("Class roster: ");
			for (int i = 0; i < this.currentEnrollmentNumber; i++) {
				System.out.println(this.currentEnrollment[i]);
			}
		} else {
			System.out.println("Roster is currently empty");
		}
	}

	public void addStudent(Student student) {
		if (maxClassSize <= currentEnrollmentNumber) {
			System.out.println(student.getName() + " cannot be added. This class has reached its maximum capacity already.");
		} else if (alreadyRegistered(student)) {
			System.out.println(student.getName() + " is already registered for this class");
		} else {
			System.out.println(student.getName() + " added to " + this.courseName);
			this.currentEnrollment[currentEnrollmentNumber] = student;
			currentEnrollmentNumber += 1;
		}
	}

	@Override
	public String toString() {
		return "Course: " + courseName + " Department: " + department + " Maximum capacity: " + maxClassSize
				+ " Number of enrolled students: " + currentEnrollmentNumber + " Current openings: " + (maxClassSize - currentEnrollmentNumber) + " Instructor: " + instructor;

		// return "Course [department=" + department + ", courseName=" + courseName + ",
		// maxClassSize=" + maxClassSize
		// + ", currentEnrollmentNumber=" + currentEnrollmentNumber + ",
		// currentEnrollment="
		// + Arrays.toString(currentEnrollment) + ", instructor=" + instructor + "]";
	}

}

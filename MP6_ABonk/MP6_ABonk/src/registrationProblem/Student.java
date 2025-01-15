package registrationProblem;

public class Student extends Person {
	private String major;
	private double GPA;

	public Student(String name, int age, String email, String major, double GPA) {
		super(name, age, email);
		this.major = major;
		this.GPA = GPA;

	}

	@Override
	public String toString() {
		return "Name: " + name + " Age: " + age + " Email: " + email + " Major: " + major + " GPA: " + GPA;
	}

	public void registerCourse(Course course) {
		course.addStudent(this);
	}

	public boolean equals(Student student) {
		if (student ==  null) {
			return false;
		} else {
			return (this.name.equals(student.name) && this.major.equals(student.major) && (this.GPA == student.GPA));
		}
	}

}

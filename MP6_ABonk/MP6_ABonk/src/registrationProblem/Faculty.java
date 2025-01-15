package registrationProblem;

public class Faculty extends Person{
	String department;
	String office;

	public Faculty(String name, int age, String email, String department, String office) {
		super(name, age, email);
		this.department = department;
		this.office = office;
	}

	@Override
	public String toString() {
		return "Name: " + name + " (Department: " + department + ", office: " + office + ")";
	}

	
	
}

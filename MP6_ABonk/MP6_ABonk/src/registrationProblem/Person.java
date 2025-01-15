package registrationProblem;

public class Person {
	protected String name;
	protected String email;
	protected int age;
	
	public Person(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	
	
}

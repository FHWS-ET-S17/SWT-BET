package snippets;

public class Member {

	
	private String name;
	private int age;
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	
	public String toString(){
		return "Name: " + this.getName() + " Alter: " + this.getAge();
	}
}

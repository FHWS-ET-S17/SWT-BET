package snippets;

public class Member 
          implements Comparable<Member> {

	
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
	
	public int compareTo(Member m){
		// Vergleich von m mit this
		return this.getName().compareTo(m.getName());
	}
}

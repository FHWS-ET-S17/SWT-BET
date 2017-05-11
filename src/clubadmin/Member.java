package clubadmin;

public class Member implements Comparable<Member>{
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
	@Override
	public int compareTo(Member m) {
		return this.getName().compareTo(m.getName());
	}
	
	public String toString(){
		return "Name: " + getName() + " Alter: " + getAge();
	}
	
	
	
	
	
	

}

package clubadmin;

import java.util.HashMap;
import java.util.Map;

public class Member implements Comparable<Member>, ContentProvider{
	private String name;
	private int age;
	private MemberAdministrator myClub;
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public MemberAdministrator getMyClub() {
		return myClub;
	}

	public void setMyClub(MemberAdministrator myClub) {
		this.myClub = myClub;
	}

	public void setClub(MemberAdministrator club){
		this.myClub= club;
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
	
	@Override
	public Map<String, String> getContentMap() {
		Map<String,String> contentMap=new HashMap<>();
		contentMap.put("Name", this.name);
		contentMap.put("Alter", Integer.toString(age));
		contentMap.put("PostalCode", "97422");
		return contentMap;
	}
	
	public String toString(){
		return "Name: " + getName() + " Alter: " + getAge();
	}
	
	
	
	
	
	
	
	

}

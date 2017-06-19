package ws11_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class DisplayElement {
	private String name;
	private List <String> associatedElementNames = new ArrayList<>();
	private Set <DisplayElement> associatedElements = new HashSet<>();

	public DisplayElement(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public List <String> getAssociatedNames() {
		return associatedElementNames;
	}

	public void setAssociatedNames(List <String> associatedElementNames) {
		this.associatedElementNames = associatedElementNames;
	}
	
	public void link (DisplayElement element){
		this.associatedElements.add(element);
	}
	
	public boolean isLinkedWith(String eName){
		for (DisplayElement e: this.associatedElements){
			if (e.getName().equals(eName)) return true;
		}
		return false;
	}
	

}

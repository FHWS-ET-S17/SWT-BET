package snippets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class SClub {

	/*
	 * Implementierung enthält sowohl den Code für die Verwendung einer Liste
	 * als auch einer map. beides parallel ist natürlich unnötig
	 * 
	 */

	private List<Member> mList; // Interface List
	private Map<String, Member> mMap; // Interface map
	private SortedSet<Member> mSetNaturalOrder, mSetIndividualOrder;

	public SClub() {
		mList = new ArrayList<>(); // Implementierende Klasse: ArrayList
		mMap = new HashMap<>(); // Implementierende Klasse: HashMap
		mSetNaturalOrder = new TreeSet<>();
		mSetIndividualOrder = new TreeSet<>(new AgeComparator());
	}

	public void addMember(Member m) {
		// Element wird an das Ende gehängt
		mList.add(m);
		// Element wird unter dem Schlüssel (m.getName()) abgelegt
		mMap.put(m.getName(), m);
		// Element wird sortiert (natural Order) abgelegt
		mSetNaturalOrder.add(m);
		mSetIndividualOrder.add(m);
	}

	public Member getMemberFromList(String name) {
		// Suchen bedeutet Traversieren der Liste, Aufwand ist
		// abhängig von der Listenlänge
		for (int i = 0; i < mList.size(); i++) {
			Member m = mList.get(i);
			if (name.equals(m.getName()))
				return m;
		}
		return null;
	}

	public Member getMemberFromMap(String name) {
		// Suchen bedeutet einfachen Zugriff auf die map
		return mMap.get(name);
	}

	public Member getMemberFromMapByIterator(String name) {
		// Für einen Iterator muss man bei einer Map
		// die Methode values() aufrufen. (Die liefert eine Collection-
		// Implementierung)
		Iterator<Member> mIterator = mMap.values().iterator();
		while (mIterator.hasNext()) {
			Member m = mIterator.next();
			if (m.getName().equals(name)) {
				return m;
			}
		}
		return null;
	}

	public Member getMemberFromSet(String name) {
		Iterator<Member> mIterator = mSetNaturalOrder.iterator();
		while (mIterator.hasNext()) {
			Member m = mIterator.next();
			if (m.getName().equals(name)) {
				return m;
			}
		}
		return null;
	}

	public Member getMemberFromSetBinarySearch(String name) {
		Member searchElement = new Member(name, 0);
		return mSetNaturalOrder.tailSet(searchElement).first();
	}

	public boolean deleteMemberFromList(String name) {
		// Suchen bedeutet Traversieren der Liste, Aufwand ist
		// abhängig von der Listenlänge
		for (int i = 0; i < mList.size(); i++) {
			Member m = mList.get(i);
			if (name.equals(m.getName())) {
				mList.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean deleteMemberFromMap(String name) {
		if (mMap.containsKey(name)) {
			mMap.remove(name);
			return true;
		}
		return false;
	}

	public boolean deleteMemberFromSet(String name) {
		// Variante 1
		/*
		 * Member mToDelete = getMemberFromSetBinarySearch(name); if
		 * (mToDelete!= null){ mSet.remove(mToDelete); return true; } return
		 * false;
		 */
		// Variante 2
		Iterator<Member> mIterator = mSetNaturalOrder.iterator();
		while (mIterator.hasNext()) {
			Member m = mIterator.next();
			if (m.getName().equals(name)) {
				// Falsch mSet.remove(m);
				// richtig
				mIterator.remove();
				return true;
			}
		}
		return false;
	}

	public boolean isMemberInList(String name) {
		// Suchen bedeutet Traversieren der Liste, Aufwand ist
		// abhängig von der Listenlänge
		for (int i = 0; i < mList.size(); i++) {
			Member m = mList.get(i);
			if (name.equals(m.getName())) {
				return true;
			}
		}
		return false;

	}

	public boolean isMemberInMap(String name) {
		// Einfacher Zugriff auf Map
		return mMap.containsKey(name);
	}

	protected List<String> printMembers(Collection<Member> members){
		List<String> allMembersAsString = new ArrayList<>();
		Iterator <Member> mIterator = members.iterator();
		while (mIterator.hasNext()){
			Member m = mIterator.next();
			String mString = m.toString();
			System.out.println(mString);
			allMembersAsString.add(mString);
		}
		return allMembersAsString;
	}
	
	public List<String> printMap(){
		return this.printMembers(mMap.values());
	}
	
	public List<String> printSet(){
		return this.printMembers(this.mSetNaturalOrder);
	}
	
	public List<String> printList(){
		return this.printMembers(mList);
	}
	
	// Methode zur besseren Testbarkeit geändert
	//Wir haben jetzt aber TestCode im Programm!!
	public List<String> listMemberToString() {
		List<String> allMembersAsString = new ArrayList<>();
		for (int i = 0; i < mList.size(); i++) {
			String mString = mList.get(i).toString();
			allMembersAsString.add(mString);
			System.out.println(mString);
		}
		return allMembersAsString;
	}
	
	

	public void listMapMembers() {
		// TODO Implementierung Iterator
	}

	public int getListMemberCount() {
		return mList.size();
	}

	public int getMapMemberCount() {
		return mMap.size();
	}
	
	public int getSetIOMemberCount(){
		return this.mSetIndividualOrder.size();
	}
	
	public int getSetNOMemberCount(){
		return this.mSetNaturalOrder.size();
	}
	

}

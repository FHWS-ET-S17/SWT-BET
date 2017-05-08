package snippets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SClub {

	/* Implementierung enth�lt sowohl den Code f�r die Verwendung 
	 * einer Liste als auch einer map. beides parallel ist nat�rlich unn�tig
	 * 
	 * */
	 
	private List<Member> mList; // Interface List
	private Map<String, Member> mMap; //Interface map

	public SClub() {
		mList = new ArrayList<>(); // Implementierende Klasse: ArrayList
		mMap = new HashMap<>(); // Implementierende Klasse: HashMap
	}

	public void addMember(Member m) {
		// Element wird an das Ende geh�ngt
		mList.add(m);
		// Element wird unter dem Schl�ssel (m.getName()) abgelegt
		mMap.put(m.getName(), m);
	}

	
	public Member getMemberFromList(String name) {
		// Suchen bedeutet Traversieren der Liste, Aufwand ist
		// abh�ngig von der Listenl�nge
		for (int i = 0; i < mList.size(); i++) {
			Member m = mList.get(i);
			if (name.equals(m.getName()))
				return m;
		}
		return null;
	}

	public Member getMemberFromMap(String name) {
		//Suchen bedeutet einfachen Zugriff auf die map
		return mMap.get(name);
	}

	public boolean deleteMemberFromList(String name) {
		// Suchen bedeutet Traversieren der Liste, Aufwand ist
				// abh�ngig von der Listenl�nge
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

	public boolean isMemberInList(String name) {
		// Suchen bedeutet Traversieren der Liste, Aufwand ist
		// abh�ngig von der Listenl�nge
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


	public void listListMembers() {
		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i).toString());
		}
	}
	
	public void listMapMembers(){
		//TODO Implementierung Iterator 
	}

	public int getListMemberCount(){
		return mList.size();
	}
	
	public int getMapMemberCount(){
		return mMap.size();
	}
	
}

package clubadmin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CAdminUsingList implements MemberAdministrator{
	private List<Member> mList;

	
	
	public CAdminUsingList() {
		super();
		this.mList = new ArrayList<>();
	}


	@Override
	public Member getMember(String name) {
		/*Implementierung mit Schleife
		for (int i=0; i<mList.size();i++){
			if (mList.get(i).getName().equals(name)){
				return mList.get(i); 
			}
		}
		return null;
		*/
		//Alternativ mit Iterator
		
		Iterator<Member> mIt = mList.iterator();
		while (mIt.hasNext()){
			Member m = mIt.next();
			if (m.getName().equals(name)){
				return m; 
			}
		}
		return null;
	}


	@Override
	public boolean isMember(String name) {
		Member m = getMember(name);
		if (m!=null) return true;
		return false;
	}

	@Override
	public boolean addMember(Member member) {
		return mList.add(member);
	}

	@Override
	public Member removeMember(String name) {
		Member m = getMember(name);
		if (m!=null){
			mList.remove(m);
			return m;
		}
		return null;
	}

	@Override
	public List<String> printMembers() {
		List<String> memberStrings = new ArrayList<>();
		Iterator<Member> mIt = mList.iterator();
		while (mIt.hasNext()){
			Member m = mIt.next();
			System.out.println(m.toString());
			memberStrings.add(m.toString());
		}
		return memberStrings;
	}


	@Override
	public int getMemberCount() {
		
		return mList.size();
	}
	
	
	

}

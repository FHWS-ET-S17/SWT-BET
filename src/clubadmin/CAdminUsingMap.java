package clubadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CAdminUsingMap implements MemberAdministrator {

	private Map<String, Member> mMap;

	public CAdminUsingMap() {
		this.mMap = new HashMap<>();
	}

	@Override
	public Member getMember(String name) {
		return mMap.get(name);
	}

	@Override
	public boolean isMember(String name) {
		return mMap.containsKey(name);
	}

	@Override
	public boolean addMember(Member member) {
		// keine Dubletten elaubt!!
		if (mMap.containsKey(member.getName()))
			return false;
		mMap.put(member.getName(), member);
		return true;
	}

	@Override
	public Member removeMember(String name) {
		return mMap.remove(name);
	}

	@Override
	public List<String> printMembers() {
		List<String> memberStrings = new ArrayList<>();
		Iterator<Member> mIt = mMap.values().iterator();
		while (mIt.hasNext()) {
			Member m = mIt.next();
			System.out.println(m.toString());
			memberStrings.add(m.toString());
		}
		return memberStrings;
	}

	@Override
	public int getMemberCount() {
		return mMap.size();
	}

}

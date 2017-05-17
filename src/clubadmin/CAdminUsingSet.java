package clubadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CAdminUsingSet implements MemberAdministrator {

	private SortedSet<Member> mSet;

	public CAdminUsingSet() {
		this.mSet = new TreeSet<>();
	}

	@Override
	public Member getMember(String name) {

		Member searchObject = new Member(name, 0);
		SortedSet<Member> tailSet = mSet.tailSet(searchObject);
		if (tailSet != null) {
			if (tailSet.first().getName().equals(name)) {
				return tailSet.first();
			}
		}
		return null;
	}

	@Override
	public boolean isMember(String name) {
		if (getMember(name) != null)
			return true;
		return false;
	}

	@Override
	public boolean addMember(Member member) {
		// keine Dubletten erlaubt!!
		if (mSet.contains(member))
			return false;
		mSet.add(member);
		return true;
	}

	@Override
	public Member removeMember(String name) {
		Member m = getMember(name);
		if (m != null) {
			mSet.remove(m);
			return m;
		}
		return null;
	}

	@Override
	public List<String> printMembers() {
		List<String> memberStrings = new ArrayList<String>();
		Iterator<Member> mIt = mSet.iterator();
		while (mIt.hasNext()) {
			Member m = mIt.next();
			memberStrings.add(m.toString());
			System.out.println(m.toString());
		}
		return memberStrings;
	}

	@Override
	public int getMemberCount() {
		return mSet.size();
	}

}

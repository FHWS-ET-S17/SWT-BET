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

	private SortedSet<Member> mSetNaturalOrder, mSetIndividualOrder;

	public CAdminUsingSet() {
		this.mSetNaturalOrder = new TreeSet<>();
		this.mSetIndividualOrder = new TreeSet<>(new AgeComparator());
	}

	@Override
	public Member getMember(String name) {

		Member searchObject = new Member(name, 0);
		SortedSet<Member> tailSet = mSetNaturalOrder.tailSet(searchObject);
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
		if (mSetNaturalOrder.contains(member))
			return false;
		mSetNaturalOrder.add(member);
		return true;
	}

	@Override
	public Member removeMember(String name) {
		Member m = getMember(name);
		if (m != null) {
			mSetNaturalOrder.remove(m);
			return m;
		}
		return null;
	}

	@Override
	public List<String> printMembers() {
		List<String> memberStrings = new ArrayList<String>();
		Iterator<Member> mIt = mSetNaturalOrder.iterator();
		while (mIt.hasNext()) {
			Member m = mIt.next();
			memberStrings.add(m.toString());
			System.out.println(m.toString());
		}
		return memberStrings;
	}

	@Override
	public int getMemberCount() {
		return mSetNaturalOrder.size();
	}

}

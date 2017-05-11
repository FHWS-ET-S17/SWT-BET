package clubadmin;

import java.util.List;

public interface MemberAdministrator {

	public Member getMember(String name);
	public boolean isMember(String name);
	public boolean addMember(Member member);
	public Member removeMember(String name);
	public List<String> printMembers();
	public int getMemberCount();
	
	
}

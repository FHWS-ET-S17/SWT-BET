package snippets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SClubTest {
	
	private SClub sClub;
	
	
	@Before
	public void setUp(){
		sClub = new SClub();
		sClub.addMember(new Member("Otto",27));
		sClub.addMember(new Member("Helene",27));
		sClub.addMember(new Member("Karla",27));
		sClub.addMember(new Member("Tim",27));
		
	}

	@Test
	public void testMList() {
		assertEquals(4,sClub.getListMemberCount());
		assertTrue(sClub.isMemberInList("Otto"));
		assertFalse(sClub.isMemberInList("Tom"));
		assertTrue(sClub.deleteMemberFromList("Otto"));
		assertFalse(sClub.isMemberInList("Otto"));
		assertEquals(3,sClub.getListMemberCount());
		Member m = sClub.getMemberFromList("Helene");
		assertEquals("Helene", m.getName());
	}
	
	@Test
	public void testMMap() {
		assertEquals(4,sClub.getMapMemberCount());
		assertTrue(sClub.isMemberInMap("Otto"));
		assertFalse(sClub.isMemberInMap("Tom"));
		assertTrue(sClub.deleteMemberFromMap("Otto"));
		assertFalse(sClub.isMemberInMap("Otto"));
		assertEquals(3,sClub.getMapMemberCount());
		Member m = sClub.getMemberFromMap("Helene");
		assertEquals("Helene", m.getName());
	}

}

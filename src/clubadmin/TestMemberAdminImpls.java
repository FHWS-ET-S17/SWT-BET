package clubadmin;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestMemberAdminImpls {

	MemberAdministrator mAdminUsingList, mAdminUsingMap, mAdminUsingSet;
	MemberAdministrator mAdmin;
	Member m1, m2, m3, m4;
	List<String> stringList;

	@Before
	public void setUp() throws Exception {
		// Testumgebung aufbauen, Parallel für alle 
		// Implementierungen von Member-Administrator
		mAdminUsingList = new CAdminUsingList();
		mAdminUsingMap = new CAdminUsingMap();
		mAdminUsingSet = new CAdminUsingSet();
		m1 = new Member("Otto", 17);
		m2 = new Member("Helge", 19);
		m3 = new Member("Maria", 18);
		m4 = new Member("Karl", 20);
		stringList = new ArrayList<>();
		
		Member[] members = new Member[] { m1, m2, m3, m4 };
		for (int i = 0; i < members.length; i++) {
			mAdminUsingList.addMember(members[i]);
			mAdminUsingMap.addMember(members[i]);
			mAdminUsingSet.addMember(members[i]);
			stringList.add(members[i].toString());
		}
	}

	// Test der Interface-Methoden. Diese sind für alle
	// Implementierungen gleich und werden deshalb in einer Methode
	// zusammengefasst
	private void testInterfaceMethods() {
		assertTrue(mAdmin.printMembers().containsAll(stringList));
		assertEquals(mAdmin.getMemberCount(), 4);
		assertEquals(mAdmin.getMember("Otto").getName(), "Otto");
		assertTrue(mAdmin.isMember("Helge"));
		Member m = mAdmin.removeMember("Helge");
		assertEquals(m.getName(), "Helge");
		assertFalse(mAdmin.isMember("Helge"));
		assertEquals(mAdmin.getMemberCount(), 3);
		
		
	}

	@Test
	public void testUsingList() {
		mAdmin = mAdminUsingList;
		testInterfaceMethods();
	}

	@Test
	public void testUsingMap() {
		mAdmin = mAdminUsingMap;
		testInterfaceMethods();
	}

	@Test
	public void testUsingSet() {
		mAdmin = mAdminUsingSet;
		testInterfaceMethods();

	}

	@Test
	public void testSortingFeatures() {
		mAdmin = this.mAdminUsingSet;
		// Test der Sortierung, Teil 1
		// Vergleichsfunktion der NaturalOder
		assertTrue(m1.compareTo(m2) > 0);
		assertTrue(m2.compareTo(m1) < 0);
		assertTrue(m2.compareTo(m2) == 0);

		//Teil 2: 1. und letztes Element überprüfen
		List<String> memberStringList = mAdmin.printMembers();
		assertEquals(m2.toString(), memberStringList.get(0));
		assertEquals(m1.toString(), memberStringList.get(3));

	}
}

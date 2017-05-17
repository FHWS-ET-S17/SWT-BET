package clubadmin;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestMember {
	
	private Member m;

	@Before
	public void setUp() throws Exception {
		m = new Member("Otto", 27);
	}

	@Test
	public void testContentMap() {
		Map<String,String> cMap = m.getContentMap();
		assertEquals("Otto", cMap.get("Name"));
		assertEquals("27", cMap.get("Alter"));
		assertEquals("97422", cMap.get("PostalCode"));
	}

}

package firststage.tupel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitComplexTest {
	private Complex c1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		c1 = new Complex(3.5, 4.5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		assertEquals(3.5,c1.getReal(),0.0001);
	}
	
	@Test
	public void test2() {
		//fail("Not yet implemented");
	}

}

package firststage.tupel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitComplexTest {
	private Complex c1,c2,c3,cZero;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		c1 = new Complex(3.5, 4.5);
		c2 = new Complex(3.0, 4.0);
		cZero = new Complex(0.0, 0.0);
		c3 = new Complex(1.0, 1.0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetter(){
		assertEquals(3.5,c1.getReal(),1.E-20);
		assertEquals(4.5,c1.getImag(),1.E-20);
	}
	
	@Test
	public void testDivide() {
		Complex result = null;;
		try{
			result = Complex.divide(c1, c2);
		
		} catch (Exception ex){
			
		}
		assertEquals(result.getReal(),1.14,1E-5);
		assertEquals(result.getImag(),-0.02,1E-5);
		
		result = new Complex(0,0);
		try{
			result = Complex.divide(c1, cZero);
			fail("Zu kleiner Divisor nicht erkannt");
		
		} catch (Exception ex){
			// c1 darf sich nicht verändert haben
			assertEquals(c1.getReal(), 3.5,1E-20);
			assertEquals(c1.getImag(), 4.5,1E-20);
		}
	}

}

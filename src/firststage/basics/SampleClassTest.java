package firststage.basics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SampleClassTest {
	private SampleClass sample1, sample2;

	@Before
	public void setUp() throws Exception {
		sample1 = new SampleClass(2.0);
		sample2 = new SampleClass(0.0);
	}
	
	@After
	public void tearDown() throws Exception {
		//SampleClass.resetCreatedObjects();
		sample1=null;
		sample2=null;
		System.gc();
	}
	

	@Test
	public void testExpo() {
		assertEquals(4.0, sample1.power(2), 0.001);
		assertEquals(0.0, sample2.power(2), 0.001);
		assertEquals(1.0, sample1.power(0), 0.001);
		assertEquals(0.25,sample1.power(-2), 0.001);
	}
	
	@Test
	public void testCreatedObjects(){
		
		
		assertEquals(2,SampleClass.getCreatedObjects());
		new SampleClass(3.6);
		assertEquals(3,SampleClass.getCreatedObjects());
		forceGc();
		assertEquals(2,SampleClass.getCreatedObjects());
		SampleClass.clearObjectCounter();
		assertEquals(0,SampleClass.getCreatedObjects());
		
	}
	
	private void forceGc(){
		System.gc();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

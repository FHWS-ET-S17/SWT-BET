package firststage.tupel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class JUnitTupelTest {
	private NTupel t1,t2,t3,t4;
	private Double values3[], values4[];
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t1 = new NTupel(3);
		t2 = new NTupel(new Double[]{2.5, 3.5, 4.5});
		values3 = new Double[]{2.5, 3.5, 4.5};
		values4 = new Double[]{1.0, 2.0, 3.0, 4.0};
		t3 = new NTupel(values3);
		t4 = new NTupel(values4);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNTupel() {
		// getTupDim, Konstruktoren
		assertEquals(3, t1.getTupDim());
		assertTrue(3==t1.getTupDim());
		Assert.assertArrayEquals(t2.getTupValues(), values3);
		
		//setTupValues
		t1.setTupValues(values4);
		assertEquals(4, t1.getTupDim());
		assertTrue(4==t1.getTupDim());
		Assert.assertArrayEquals(t1.getTupValues(), values4);
		
		//getValueAt, setValueAt
		assertEquals(values4[2].doubleValue(), t1.getValueAt(2),1.0E-10);
		t1.setValueAt(7.8, 2);
		assertEquals(7.8, t1.getValueAt(2),1.0E-10);
		
		//setTupDim
		t1.setTupDim(10);
		assertEquals(10,t1.getTupDim());
		assertEquals(10,t1.getTupValues().length);
		
		
		//multiplyBy, divideBy
		t4.multiplyBy(3.0);
		assertArrayEquals(new Double[]{3.0,6.0,9.0,12.0},t4.getTupValues());
		t4.multiplyBy(0.0);
		assertArrayEquals(new Double[]{0.0,0.0,0.0,0.0},t4.getTupValues());
		try{
			t4.divideBy(3.0);
		}catch(Exception ex){
			fail("Exeption bei Division durch 3");
		}
		assertArrayEquals(values4, t4.getTupValues());
		try{
			t4.divideBy(0.0);
			fail("keine Exeption bei Division durch 0");
		}catch (NullPointerException ex){
			
		}catch (Exception ex){
			assertEquals(ex.getMessage(),"Division durch 0");
		}
	
		
		// add, sub
		t2 = new NTupel(values4);
		t3 = new NTupel(values4);
		
		NTupel result = NTupel.add(t2,t3);
		for(int i=0; i<result.getTupDim();i++){
			assertEquals(result.getValueAt(i), 
					values4[i] + values4[i],1.0E-10);
		}
		
		result = NTupel.sub(t2,t3);
		for(int i=0; i<result.getTupDim();i++){
			assertEquals(result.getValueAt(i),0.0,1.0E-10);
		}
		// squareRootSum
		// 9 + 16 = 25
		t1 = new NTupel(new Double[]{3.0, 4.0});
		assertEquals(5, t1.squareSumRoot(),1.0E-10);		
		
		//geometricMeanValue
		t1 = new NTupel(new Double[]{3.0, 3.0,3.0});
		assertEquals(3, t1.geometricMeanValue(),1.0E-10);		
		
		//arthimetricMeanValue
		t1 = new NTupel(new Double[]{3.0, 3.0,3.0});
		assertEquals(3, t1.arithmeticMeanValue(),1.0E-10);		
				
	}
	@Test
	// toString
	public void testToSting(){
		System.out.println(t2.toString());
		assertTrue(true);
	}
		
		
		
	

	public static void main(String[] args) {
		System.out.println("Test ok");
	}

}

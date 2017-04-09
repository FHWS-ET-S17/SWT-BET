package firststage.tupel;




public class TestTupel {

	public static void main(String[] args) {
		TestTupel.testTupel();
		testTupel();
		
	}
		

public static void testTupel(){
	NTupel t1 = new NTupel(3);
	NTupel t2 = 
			new NTupel(new Double[]{2.5, 3.5, 4.5});
	Double[] values = new Double[]{2.5, 3.5, 4.5};
	NTupel t3 = new NTupel(values);
	// Test von tupDim
	if (t1.getTupDim()==3) {
		System.out.println("Test ok");
	}else{
		System.out.println("Test fails");
	}
	
	System.out.println("Dimension von t2: soll 3 sein:"+
			t2.getTupDim());
	// Test von TUP-Values
	for (int i=0; i<t3.getTupDim();i++){
		System.out.println("tupValue erwartet: " + values[i] +
				" erhalten: " + t3.getValueAt(i));
	}
	

	
	
}
	
}

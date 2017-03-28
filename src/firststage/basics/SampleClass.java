package firststage.basics;

public class SampleClass {
	
	private static int objectCounter=0;
	private double dynValue;
	private int objectCount=0;
	
	

	public SampleClass(double dynValue) {
		super();
		this.dynValue = dynValue;
		
		objectCounter++;
		objectCount=objectCounter;
		System.out.println("Created: " + objectCount);
	}
	
	public double getDynValue() {
		return dynValue;
	}

	public void setDynValue(double dynValue) {
		this.dynValue = dynValue;
	}

	public static int getCreatedObjects() {
		return objectCounter;
	}

	public double power(int expo){
		double result = 1, factor = dynValue;
		
		if (expo==0) return 1;
		if (dynValue==0) return 0;
		if (expo<0) {
			expo=-expo;
			factor  = 1/factor;
		}
		for (int i=0; i<expo; i++){
			result = result*factor;
		}
		return result;
		
	}
	
	public static void clearObjectCounter(){
		objectCounter=0;
	}

	public void finalize(){
		objectCounter--;
		System.out.println("destroying: " + objectCount + 
				" ObjectCounter: " + objectCounter);
		
	}

	public static void main(String[] args) {
		// Hier sollte was gemacht werden

	}

}

package firststage.tupel;

public class NTupel {
	
	private int tupDim;
	private Double tupValues[];
	
	public NTupel(int tupDim){
		this.tupDim = tupDim;
		tupValues= new Double[tupDim];
	}
	
	public NTupel(Double[] tupValues ){
		tupDim =tupValues.length;
		this.tupValues = new Double[tupDim];
		//this.tupValues = tupValues; //Vorsicht, das kann shciefgehen
		//this.tupValues = tupValues.clone();
		
		for (int i=0; i<tupDim; i++){
			this.tupValues[i]= tupValues[i];
		}
	}

	public int getTupDim(){
		return tupDim;
	}
	
	public Double[] getTupValues() {
		return tupValues;
	}

	public void setTupValues(Double[] tupValues) {
		this.tupDim=tupValues.length;
		this.tupValues = tupValues.clone();
	}
	
	public double getValueAt(int index){
		// TODO unzulässighen  Index überprüfen
		return tupValues[index].doubleValue();
	}
	public void setValueAt(double value, int index){
		// TODO auf unzulässighen Index überprüfen
		tupValues[index]= value;
	}

	public void setTupDim(int tupDim) {
		this.tupDim = tupDim;
	}

	public void multiplyBy(double factor){
		for (int i=0; i<tupDim; i++){
			tupValues[i] = tupValues[i]*factor;
		}
	}
	
	public void divideBy(double factor){
		if (factor == 0) return;
		for (int i=0; i<tupDim; i++){
			tupValues[i] = tupValues[i]/factor;
		}
	}
	
	public static NTupel add(NTupel fTupel, NTupel sTupel){
		//TODO Feldlängen müssen gleich sein
		NTupel result = new NTupel(fTupel.getTupDim()) ;
		double sum;
		for (int i=0; i<fTupel.getTupDim(); i++){
			sum = fTupel.getValueAt(i)+
					sTupel.getValueAt(i);
			result.setValueAt(sum, i);
		}
		return result;
	}

	public static NTupel sub(NTupel fTupel, NTupel sTupel){
		//TODO Feldlängen müssen gleich sein
		NTupel result = new NTupel(fTupel.getTupDim()) ;
		double dif=0;
		for (int i=0; i<fTupel.getTupDim(); i++){
			dif = fTupel.getValueAt(i)-
					sTupel.getValueAt(i);
			result.setValueAt(dif, i);
		}
		return result;
	}
	
	protected double geometricMeanValue(){
		double squareSum=0;
		for (int i=0; i<getTupDim();i++){
			squareSum = squareSum + Math.pow(getValueAt(i), 2);
		}
		return Math.pow(squareSum, 1./getTupDim());
	}
	
	protected double arithmetikMeanValue(){
		double sum=0;
		for (int i=0; i<getTupDim();i++){
			sum = sum + getValueAt(i);
		}
		//TODO tupDim==0?? Exception im Konstruktor
		return (sum/getTupDim());
	}
	
	
	
	


	public static void main(String[] args) {
		NTupel t1 = new NTupel(3);
		NTupel t2 = 
				new NTupel(new Double[]{2.5, 3.5, 4.5});
		Double[] values = new Double[]{2.5, 3.5, 4.5};
		NTupel t3 = new NTupel(values);
		// Test von tupDim
		System.out.println("Dimension von t1: soll 3 sein:"+
					t1.getTupDim());
		System.out.println("Dimension von t2: soll 3 sein:"+
				t2.getTupDim());
		// Test von TUP-Values
		for (int i=0; i<t3.getTupDim();i++){
			System.out.println("tupValue erwartet: " + values[i] +
					" ehalten: " + t3.getValueAt(i));
		}
		
		
	}
	
	
	

}

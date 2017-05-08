package firststage.tupel;

import java.util.Arrays;

public class NTupel {
	
	private int tupDim;
	private Double tupValues[];
	
	public NTupel(int tupDim){
		this.tupDim = tupDim;
		tupValues= new Double[tupDim];
	}
	@Override
	public String toString(){
		String output = 
				getClass().getName() + ": " ;
		for (int i=0; i<getTupDim(); i++){
			output = output.concat(getValueAt(i) + ";");
		}
		return output;
	}
	
	public NTupel(Double[] tupValues ){
		tupDim =tupValues.length;
		this.tupValues = new Double[tupDim];
		//this.tupValues = tupValues; //Vorsicht, das kann schiefgehen
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
		this.tupValues= new Double[tupDim];	}

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
	

	protected double squareSumRoot(){

		double squareSum=0;
		for (int i=0; i<getTupDim();i++){
			squareSum = squareSum + Math.pow(getValueAt(i), 2);
		}
		return Math.pow(squareSum, 1./getTupDim());
	}
	
	protected double geometricMeanValue(){
		double product=1;
		for (int i=0; i<getTupDim();i++){
			product = product *getValueAt(i);
		}
		return Math.pow(product, 1./getTupDim());
	}
	
	protected double arithmeticMeanValue(){
		double sum=0;
		for (int i=0; i<getTupDim();i++){
			sum = sum + getValueAt(i);
		}
		//TODO tupDim==0?? Exception im Konstruktor
		return (sum/getTupDim());
	}
	
//
	public static void main(String[] args) {
		
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tupDim;
		result = prime * result + Arrays.hashCode(tupValues);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NTupel other = (NTupel) obj;
		if (tupDim != other.tupDim)
			return false;
		if (!Arrays.equals(tupValues, other.tupValues))
			return false;
		return true;
	}
	
	
	

}

package firststage.tupel;

public class Complex extends NTupel {
	
	public Complex() {
		super(2);
	}

	public Complex(double real, double imag) {
		super(2);
		this.setValueAt(real, 0);
		this.setValueAt(imag, 1);
	}
	
	public double getReal(){
		return this.getValueAt(0);
	}
	public double getImag(){
		return this.getValueAt(1);
	}
	public void setReal(double real){
		setValueAt(real,0);
	}
	public void setImag(double imag){
		setValueAt(imag,1);	
	}
	
	public double absoluteValue(){
		return this.squareSumRoot();
	}
	
	public double phase(){
		//getValueAt(1)/getValueAt(0)
		//Math.atan(getImag()/getReal());
		return Math.atan2(getImag(),getReal());
		
	}
	
	public static Complex add (Complex c1, Complex c2){
		NTupel res = NTupel.add(c1,c2);
		
		Complex result = new Complex(res.getValueAt(0),
				res.getValueAt(1));
		return result;
		 
	}
	
	public static Complex sub (Complex c1, Complex c2){
		NTupel res = NTupel.sub(c1,c2);
		
		Complex result = new Complex(res.getValueAt(0),
				res.getValueAt(1));
		return result;
		 
	}
	
	public static Complex multiply(Complex c1, Complex c2){
		double newAbs = c1.absoluteValue()*c2.absoluteValue();
		double newPhase = c1.phase()+ c2.phase();
		Complex result = new Complex();
		result.setReal(newAbs*Math.cos(newPhase));
		result.setImag(newAbs*Math.sin(newPhase));
		return result;
	}
	
	@Override
	public String toString(){
		return "String von NTupel";
		
	}
	
	
	
	
	
	

}

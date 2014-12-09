package negPack;


public class NegadecimalNumber {

	String valueNdn;
	int valueDec;
	
	public NegadecimalNumber(String s) {
		//Expects a string representation of a negadecimal number, 
		//converts to a (decimal) int and stores in an instance variable. 
		//If the string does not consist entirely of digits, or is an empty string, 
		//an IllegalArgumentException is thrown.
		if (s.equals("")){
			throw new IllegalArgumentException("Error");
		}		
		for (int i = 0; i < s.length(); i++){
			if (!Character.isDigit(s.charAt(i))){
				throw new IllegalArgumentException("Error");
			}
		}
		
		// Take away leading zeros by convertingn to int and back to string
		int s2 = Integer.parseInt(s);
		
		valueNdn = Integer.toString(s2);
		valueDec = this.decimalValue();
	}

	public NegadecimalNumber(int n) {
		//Saves the integer (decimal) parameter in an instance variable.
		//Saves the negadecimal (string) in an instance variable.

			valueDec = n;
			valueNdn = this.negadecimalValue();
	}
	
	
	public NegadecimalNumber add(NegadecimalNumber ndn) {
		//Returns a new negadecimal number which is the result of adding ndn to "this" negadecimal number.
		int answer = this.valueDec + ndn.valueDec;
		
		NegadecimalNumber ndn_new = new NegadecimalNumber(answer);
		return ndn_new;	
	}	
		
	public NegadecimalNumber subtract(NegadecimalNumber ndn) {
		//Returns a new negadecimal number which is the result of subtracting ndn from "this" negadecimal number.
		int answer = this.valueDec - ndn.valueDec;
		
		NegadecimalNumber ndn_new = new NegadecimalNumber(answer);
		return ndn_new;
	}
	
	public NegadecimalNumber multiply(NegadecimalNumber ndn) {
		//Returns a new negadecimal number which is the result of multiplying ndn and "this" negadecimal number.
		int answer = this.valueDec * ndn.valueDec;
		
		NegadecimalNumber ndn_new = new NegadecimalNumber(answer);
		return ndn_new;
	}
	
	public NegadecimalNumber divide(NegadecimalNumber ndn) {
		//Returns a new negadecimal number which is the result of dividing "this" negadecimal number by ndn. Throws an ArithmeticException if ndn is zero.		
		if(ndn.valueDec == 0){
			throw new ArithmeticException("Error - Divide by zero");
		}
		
		int answer = this.valueDec / ndn.valueDec;
		NegadecimalNumber ndn_new = new NegadecimalNumber(answer);
		return ndn_new;
	}
	
	public NegadecimalNumber remainder(NegadecimalNumber ndn) {
		//Returns a new negadecimal number which is the remainder after dividing "this" negadecimal number by ndn. Throws an ArithmeticException if ndn is zero.
		if(ndn.valueDec == 0){
			throw new ArithmeticException("Error - Divide by zero");
		}
		int answer = this.valueDec % ndn.valueDec;
		NegadecimalNumber ndn_new = new NegadecimalNumber(answer);
		return ndn_new;
	}
	
	public NegadecimalNumber negate(){
		//Returns a new negadecimal number which, when added to negadecimal, would give zero.
		NegadecimalNumber ndn_new = new NegadecimalNumber(-1 * this.valueDec);
		return ndn_new;
	}
	
	public int decimalValue() {
		//Returns the decimal equivalent of this negadecimal number.
		String ndn = this.valueNdn;
		int decimal = 0;
		int length = ndn.length();
		int temp;
		int tempNdn = Integer.parseInt(ndn);
		
		for (int i = 0; i < length; i++){
			temp = tempNdn % 10;
			decimal += temp*Math.pow(-10, i);
			tempNdn /= 10;
		}
		return decimal;		
	}
	
	public String negadecimalValue() {
		//Returns the negadecimal equivalent of this decimal number.
		String result = "";
		int dec = this.valueDec;
		
		if (dec == 0){
			return "0";
		}
		
		while (dec != 0){
			int remainder = dec % -10;
			dec = dec / -10;
			
			if(remainder < 0){
				remainder += 10;
				dec += 1;
			}
			result = Integer.toString(remainder) + result;
		}
		return result;
	}
	
	public String toString() {
		//Returns the string representation of this negadecimal number.
		return this.valueNdn;
	}
	
	@Override
	public boolean equals (Object other) {

		//Check if other is an instance of NegadecimalNumber
		if (!(other instanceof NegadecimalNumber)) {
			return false;
		}
	
		//Cast other to a NegadecimalNumber
		NegadecimalNumber that = (NegadecimalNumber) other;
	
		//Check if the decimalNumber fields are equal.
		return this.valueDec == that.valueDec;
	}
}

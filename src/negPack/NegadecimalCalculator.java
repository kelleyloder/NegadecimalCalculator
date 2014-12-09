/*        Negadecimal Calculator
 *  by Kelley Loeder & Martha Trevino
 */

package negPack;

import java.util.Scanner;

public class NegadecimalCalculator {

	public static void main(String[] args) {
		new NegadecimalCalculator().REPL();
	}

	public void REPL() {
		// Handles input/output with user

		// Starts with a "0"
		String stored = "0";
		System.out.println(stored);

		// Do computations until user types the "quit" command
		do {
			System.out.print("Compute: ");
			Scanner userInput = new Scanner(System.in); // Saves user input
			stored = evaluate(userInput.nextLine(), stored); // Evaluates user input
			System.out.println(stored);	// Prints output of evaluation
			stored = stored.split(" ")[0]; // Take away any words after "Error" messages

			if (stored.equals("Error")){
				// Only continue with computations if user "clear" after an "Error"
				do {
					System.out.print("Type 'clear' to continue: ");
					Scanner userInput2 = new Scanner(System.in);
					stored = evaluate(userInput2.nextLine(), stored);
					stored = stored.split(" ")[0];
				} while(!stored.equals("0"));
				System.out.println(stored);
			}

		} while(!stored.equals("Done."));
	}


	public String evaluate(String s, String current){
		// Evaluate user input

		if (!s.equals("")){
			// Take away spaces and change everything to lower case
			s = s.toLowerCase().replaceAll("\\s+","");

			// If user input is "q" or "quit", return string "Done."
			if (s.equals("q") || s.equals("quit")) { return "Done."; }

			// If user input is "c" or "clear", new stored value is "0"
			if (s.equals("c") || s.equals("clear")) { return "0"; }

			if (current.equals("Error")) { return current; }

			// Create current negadecimal number
			NegadecimalNumber ndnCurrent = new NegadecimalNumber(current);

			// If user input is "~", return the negate of current value
			if (s.equals("~")){ return ndnCurrent.negate().valueNdn; }

			// If user input is "?", return the same ndn, with its decimal equivalent
			if (s.equals("?")){
				return ndnCurrent.valueNdn + " (decimal " + ndnCurrent.valueDec + ")";
			}


			// If user input has the command "decimal", return the ndn value
			String sub = s;

			if (s.length() > 7){
				String dec = s.substring(0, 7);

				if (dec.equals("decimal")){
					sub = s.substring(7);
					try{
						int n = Integer.parseInt(sub);
						NegadecimalNumber ndnNew = new NegadecimalNumber(n);
						return ndnNew.valueNdn;
					}catch(NumberFormatException e){
						return "Error";
					}
				}
			}

			// For user inputs that start with a command: "+", "-", "*", "/", "%" or ndn alone
			// Checks is 1st char is a digit
			if (!Character.isDigit(s.charAt(0))){
				// If 1st char is not a digit, remove it and save a sub string of the rest

				sub = s.substring(1);
			}
			// If ndn alone, try create an ndn #, and return it
			else{
				try{
					NegadecimalNumber ndnNew = new NegadecimalNumber(s);
					return ndnNew.valueNdn;
				} catch(IllegalArgumentException e){
					return e.getMessage();
				}
			}

			// Try create ndn with the substring (sub) without the command at the beginning
			NegadecimalNumber ndnNew;
			try{
				ndnNew = new NegadecimalNumber(sub);
			} catch(IllegalArgumentException e){
				return e.getMessage();
			}

			// Check for specific command: "+", "-", "*", "/", "%" 
			if (s.charAt(0) == '+') { return ndnCurrent.add(ndnNew).valueNdn; }

			if (s.charAt(0) == '-') { return ndnCurrent.subtract(ndnNew).valueNdn; }

			if (s.charAt(0) == '*') { return ndnCurrent.multiply(ndnNew).valueNdn; }

			// Divide and remainder throw exceptions
			if (s.charAt(0) == '/'){
				try{
					return ndnCurrent.divide(ndnNew).valueNdn;
				} catch(ArithmeticException e){
					return e.getMessage();
				}
			}

			if (s.charAt(0) == '%'){
				try{
					return ndnCurrent.remainder(ndnNew).valueNdn;
				} catch(ArithmeticException e){
					return e.getMessage();
				}
			}
		}
		return "Error";
	} 

}

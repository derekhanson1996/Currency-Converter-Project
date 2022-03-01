import java.util.Scanner;
import java.text.DecimalFormat;
/**  
* Derek Hanson - dlhanson5  
* CIS171 20517 WW1
* Feb 24, 2022  
*/
public class CurrencyConverterHanson {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		double totalBal = 0;
		double foreignCurrency = 0;
		double convertedCurrency = 0;
		String selection = "";
		
		System.out.println("Welcome to Hanson International Bank.");
		
		while(selection.equals("exit") != true) {
			System.out.println();
			System.out.println("Please select which currency you would like to be converted to USD.");
			System.out.print("Enter \"eur\" for Euro, \"mxn\" for Mexican Peso, \"jpy\" for Japanese Yen, \"cad\" for Canadian Dollar or \"exit\" when finished. ");
			selection = in.next();
			
			System.out.println();
			
			selection = verifyForeignCurrencySelection(selection);
			
			if(selection.equals("error") == true) {
				System.out.println("Error, please enter the correct currency.");
			}
			
			else if(selection.equals("exit") != true) {
				
				while(foreignCurrency <= 0) {
					System.out.print("Please enter the amount of " + selection +" you would like to be converted to USD. ");
					foreignCurrency = in.nextDouble();
					System.out.println();
					
					if(foreignCurrency <= 0) {
						System.out.println("Error, please enter an amount greater than 0.");
						System.out.println();
					}
				}
				
				convertedCurrency = convertCurrency(foreignCurrency, selection);
				totalBal = totalBal + convertedCurrency;
				
				System.out.println(foreignCurrency + " " + selection + " has been converted to $" + df.format(convertedCurrency) + " for a total balance of $" + df.format(totalBal) + ".");
				foreignCurrency = 0;
			}
		}
		
		System.out.println("$" + df.format(totalBal) + " has been credited to your account.");
		System.out.println();
		System.out.println("Thank you for choosing Hanson International Bank, have a nice day!");
		
		in.close();
	}
	
	/**This method verifies the currency selection from user and returns the currency or an error
	 * @param foreign currency selection or exit
	 * @return foreign currency selected or error
	 */
	
	public static String verifyForeignCurrencySelection(String currencySelection) {
		String foreignSelection = "";
		currencySelection = currencySelection.toLowerCase();
		
		if(currencySelection.equals("eur") == true) {
			foreignSelection = "Euros";
		}
		
		else if(currencySelection.equals("mxn") == true) {
			foreignSelection = "Mexican Pesos";
		}
		
		else if(currencySelection.equals("jpy") == true) {
			foreignSelection = "Japanese Yen";
		}
		
		else if(currencySelection.equals("cad") == true) {
			foreignSelection = "Canadian Dollars";
		}
		
		else if(currencySelection.equals("exit") == true) {
			foreignSelection = "exit";
		}
		
		else {
			foreignSelection = "error";
		}
		
		return foreignSelection;
	}
	
	/**This method calculates the amount of foreign currency converted to USD and returns it
	 * @param amount of foreign currency
	 * @param foreign currency selected
	 * @return currency converted to USD
	 */
	
	public static double convertCurrency(double currency, String currencySelection) {
		double totalUSD = 0;
		double conversionRate = 0;
		final double EUR = 1.1202753;		//conversion rates are from 2/24/2022 according to www.xe.com
		final double MXN = 0.048638722;
		final double JPY = 0.0086524862;
		final double CAD = 0.78139238;
		
		if(currencySelection.equals("Euros") == true) {
			conversionRate = EUR;
		}
		
		else if(currencySelection.equals("Mexican Pesos") == true) {
			conversionRate = MXN;
		}
		
		else if(currencySelection.equals("Japanese Yen") == true) {
			conversionRate = JPY;
		}
		
		else if(currencySelection.equals("Canadian Dollars") == true) {
			conversionRate = CAD;
		}
		
		totalUSD = currency * conversionRate;
		
		return totalUSD;
	}

}

/*Create classes FederalTaxCalculator and ProvincialTaxCalculator that extend
TaxCalculator and implement the tax calculation methods.
*/
public class FederalTaxCalculator extends TaxCalculator{
	
@ Override 
 public double federalTaxes(double income) {
	if (income <= 50000) {
		return income * 0.15;
	} else if (income <= 100000) {
		return 50000 * 0.15 + (income - 50000) * 0.20;
	} else {
		return 50000 * 0.15 + 50000 * 0.20 + (income - 100000) * 0.25;
	}
}

@Override
public double provincialTaxes(double income, String province) {
	return 0;
}

}

/*/working ************************
public static void main(String args[]) {
	
	TaxCalculator tax = new FederalTaxCalculator();
	
	System.out.println("federal tax = " + tax.federalTaxes(500000));
}}

*/
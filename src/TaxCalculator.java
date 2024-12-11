/*Create an abstract class TaxCalculator with abstract methods for calculating federal and
provincial taxes.*/
public abstract class TaxCalculator {
	
	public abstract double federalTaxes(double income);
	public abstract double provincialTaxes(double income, String province);
	
}

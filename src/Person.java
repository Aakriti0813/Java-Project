/*Instructions
Create a Person class with basic attributes such as name, income, and province, net
income.
Create an abstract class TaxCalculator with abstract methods for calculating federal and
provincial taxes.
Create classes FederalTaxCalculator and ProvincialTaxCalculator that extend
TaxCalculator and implement the tax calculation methods.
Main Application
Create a main class FinancialCalculatorApp that reads input from the user (name, income,
province), calculates and displays the net income after deducting federal and provincial
taxes using the TaxCalculator implementations. The display should include name, income,
province, federal tax deductions, provincial tax deductions and the net income.*/


public class Person {
	private String name;
	private double income;
	private String province;
	private double net_income;

	//constructor
	public Person(String name, double income, String province) {
		this.name = name;
		this.income = income;
		this.province = province;
		
	}

	//getter and setter
	public String getName() {
		return name;
	}
	
	
	public double getIncome() {
		return income;
	}
	
	public String getProvince() {
		return province;
	}
	
	public double getNet_income() {
		return net_income;
	}
	
	public void setNet_income(double net_income) {
		this.net_income = net_income;
	}
	
	public double getFederalTaxes() {
		return 0; //placeholder; calculate in TaxApp
	}
	
	public double getProvincialTaxes() {
		return 0; //placeholder; calculate in TaxApp
	}
	
	/*public static void main(String args[]) {
		Person p = new Person("tom",129.99,"Quebec");
		System.out.println("tom");
	}*/
}


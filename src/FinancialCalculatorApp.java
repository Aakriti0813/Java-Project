import java.util.*;

public class FinancialCalculatorApp {
    private static final String FILE_NAME = "persons.txt";
    private static List<Person> sessionRecords = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Calculate net income after tax deductions");
            System.out.println("2. View session records");
            System.out.println("3. Exit");
            System.out.print("Choose one of the above options: ");
            option = getValidIntegerInput(input);
            switch (option) {
                case 1:
                    calculateNetIncome(input);
                    break;
                case 2:
                    displaySessionRecords();
                    break;
                case 3:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 3);
        input.close();
    }

    private static int getValidIntegerInput(Scanner input) {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number.");
                input.next(); // to clear the invalid input
            }
        }
    }

    private static void calculateNetIncome(Scanner input) {
        input.nextLine(); // to consume the leftover newline
        try {
            System.out.print("Enter name: ");
            String name = input.nextLine();

            System.out.print("Enter income: ");
            double income = getValidDoubleInput(input);

            input.nextLine(); 
            System.out.print("Enter Province (example QC, BC, SK): ");
            String province = input.nextLine();

            // Calculate taxes
            TaxCalculator federalCalculator = new FederalTaxCalculator();
            TaxCalculator provincialCalculator = new ProvincialTaxCalculator();
            double federalTax = federalCalculator.federalTaxes(income);
            double provincialTax = provincialCalculator.provincialTaxes(income, province);
            double netIncome = income - federalTax - provincialTax;

            // Create Person object and set net income
            Person person = new Person(name, income, province);
            person.setNet_income(netIncome);

            // Save person to file and add to session records
            savePersonToFile(person);
            sessionRecords.add(person);

            System.out.println("New person added and saved.");
            displayPersonDetails(person);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Enter the correct data type.");
            input.next(); 
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }

    private static double getValidDoubleInput(Scanner input) {
        while (true) {
            try {
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a valid number.");
                input.next(); 
            }
        }
    }

    private static void savePersonToFile(Person person) {
        // Implement file saving logic here, handle IOException if needed
    }

    private static Person findPersonByName(String name) {
        // Implement logic to find person by name from sessionRecords or file
        return null;
    }

    private static void displayPersonDetails(Person person) {
        TaxCalculator federalCalculator = new FederalTaxCalculator();
        TaxCalculator provincialCalculator = new ProvincialTaxCalculator();
        double federalTax = federalCalculator.federalTaxes(person.getIncome());
        double provincialTax = provincialCalculator.provincialTaxes(person.getIncome(), person.getProvince());
        System.out.println("Name: " + person.getName());
        System.out.println("Income: " + person.getIncome());
        System.out.println("Province: " + person.getProvince());
        System.out.println("Federal Tax: " + federalTax);
        System.out.println("Provincial Tax: " + provincialTax);
        System.out.println("Net Income: " + person.getNet_income());
    }

    private static void displaySessionRecords() {
        if (sessionRecords.isEmpty()) {
            System.out.println("No session records available.");
        } else {
            System.out.println("Session Records:");
            sessionRecords.forEach(person -> {
                System.out.println("Name: " + person.getName());
                System.out.println("Income: " + person.getIncome());
                System.out.println("Province: " + person.getProvince());
                System.out.println("Federal Tax: " + new FederalTaxCalculator().federalTaxes(person.getIncome()));
                System.out.println("Provincial Tax: " + new ProvincialTaxCalculator().provincialTaxes(person.getIncome(), person.getProvince()));
                System.out.println("Net Income: " + person.getNet_income());
                System.out.println();
            });
        }
    }
}
 /* part 1 /Read input by user
		
		System.out.println("Enter name: ");
		String name = input.nextLine();
		
		System.out.println("Enter income: ");
		double income = input.nextDouble();
		
		input.nextLine(); // Consume newline
		
		System.out.println("Enter Province (example QC, BC, SK): ");
		String province = input.nextLine();
		
		
		// Create instances of tax calculators
		FederalTaxCalculator federalCalculator = new FederalTaxCalculator();
		ProvincialTaxCalculator provincialCalculator = new ProvincialTaxCalculator();
		
		
		// Calculate taxes
		double federalTax = federalCalculator.federalTaxes(income);
		double provincialTax = provincialCalculator.provincialTaxes(income, province);
		double net_income = income - federalTax - provincialTax;
		
		
		// Create Person object and set net income
		Person person = new Person (name, income, province);
		person.setNet_income(net_income);
		
		
		// Display results
		System.out.println("Name : " + person.getName());
		System.out.println("Income : " + person.getIncome());
		System.out.println("Province : " + person.getProvince());
		System.out.println("Federal Tax Deduction : " + federalTax);
		System.out.println("Provincial Tax Deduction : " + provincialTax);
		System.out.println("Net Income : " + net_income);
		
		input.close();
		
	}
}  */

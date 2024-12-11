
public class ProvincialTaxCalculator extends TaxCalculator {

	@ Override 
	 public double federalTaxes(double income) {
		return 0 ;
	}
	
	@ Override
	public double provincialTaxes(double income, String province) {
		double tax = 0.0;
		switch (province.toUpperCase()) {
		case "ON" :
			tax = calculateTaxOntario(income);
			break;
		case "BC" :
			tax = calculateTaxBritishColumbia(income);
			break;
		case "AB" :
			tax = calculateTaxAlberta(income);
			break;
		case "QC" :
			tax = calculateTaxQuebec(income);
			break;
		case "NS" :
			tax = calculateTaxNovaScotia(income);
			break;
		case "NB" :
			tax = calculateTaxNewBrunswick(income);
			break;
		case "MB" :
			tax = calculateTaxManitoba(income);
			break;
		case "SK" :
			tax = calculateTaxSaskatchewan(income);
			break;
		case "PEI" :
			tax = calculateTaxPrinceEdwardIsland(income);
			break;
		case "NT" :
		case "NU" :
		case "YT" :
			tax = calculateTaxTerritories(income);
			break;
			default:
				System.out.println("Unknown province or territory : " + province);
				//throw new IllegalArgumentException("Unknown province or territory: " + province);
		}
		return tax;
	}
	
	// Methods for calculating Tax of each province
	
    private double calculateTaxOntario(double income) {
        double tax = 0.0;
        if (income <= 45000) {
            tax = income * 0.05;
        } else if (income <= 90000) {
            tax = 45000 * 0.05 + (income - 45000) * 0.10;
        } else {
            tax = 45000 * 0.05 + 45000 * 0.10 + (income - 90000) * 0.15;
        }
        return tax;
    }

    private double calculateTaxBritishColumbia(double income) {
        double tax = 0.0;
        if (income <= 42000) {
            tax = income * 0.06;
        } else if (income <= 84000) {
            tax = 42000 * 0.06 + (income - 42000) * 0.11;
        } else {
            tax = 42000 * 0.06 + 42000 * 0.11 + (income - 84000) * 0.16;
        }
        return tax;
    }

    private double calculateTaxAlberta(double income) {
        double tax = 0.0;
        if (income <= 50000) {
            tax = income * 0.10;
        } else {
            tax = 50000 * 0.10 + (income - 50000) * 0.12;
        }
        return tax;
    }

    private double calculateTaxQuebec(double income) {
        double tax = 0.0;
        if (income <= 45000) {
            tax = income * 0.075;
        } else if (income <= 90000) {
            tax = 45000 * 0.075 + (income - 45000) * 0.15;
        } else {
            tax = 45000 * 0.075 + 45000 * 0.15 + (income - 90000) * 0.20;
        }
        return tax;
    }

    private double calculateTaxNovaScotia(double income) {
        double tax = 0.0;
        if (income <= 30000) {
            tax = income * 0.08;
        } else if (income <= 60000) {
            tax = 30000 * 0.08 + (income - 30000) * 0.14;
        } else {
            tax = 30000 * 0.08 + 30000 * 0.14 + (income - 60000) * 0.17;
        }
        return tax;
    }

    private double calculateTaxNewBrunswick(double income) {
        double tax = 0.0;
        if (income <= 35000) {
            tax = income * 0.09;
        } else if (income <= 70000) {
            tax = 35000 * 0.09 + (income - 35000) * 0.14;
        } else {
            tax = 35000 * 0.09 + 35000 * 0.14 + (income - 70000) * 0.16;
        }
        return tax;
    }

    private double calculateTaxManitoba(double income) {
        double tax = 0.0;
        if (income <= 34000) {
            tax = income * 0.10;
        } else if (income <= 68000) {
            tax = 34000 * 0.10 + (income - 34000) * 0.12;
        } else {
            tax = 34000 * 0.10 + 34000 * 0.12 + (income - 68000) * 0.14;
        }
        return tax;
    }

    private double calculateTaxSaskatchewan(double income) {
        double tax = 0.0;
        if (income <= 45000) {
            tax = income * 0.11;
        } else if (income <= 90000) {
            tax = 45000 * 0.11 + (income - 45000) * 0.13;
        } else {
            tax = 45000 * 0.11 + 45000 * 0.13 + (income - 90000) * 0.15;
        }
        return tax;
    }

    private double calculateTaxPrinceEdwardIsland(double income) {
        double tax = 0.0;
        if (income <= 35000) {
            tax = income * 0.09;
        } else if (income <= 70000) {
            tax = 35000 * 0.09 + (income - 35000) * 0.12;
        } else {
            tax = 35000 * 0.09 + 35000 * 0.12 + (income - 70000) * 0.15;
        }
        return tax;
    }

    private double calculateTaxTerritories(double income) {
        double tax = 0.0;
        if (income <= 50000) {
            tax = income * 0.05;
        } else {
            tax = 50000 * 0.05 + (income - 50000) * 0.08;
        }
        return tax;
    }
}

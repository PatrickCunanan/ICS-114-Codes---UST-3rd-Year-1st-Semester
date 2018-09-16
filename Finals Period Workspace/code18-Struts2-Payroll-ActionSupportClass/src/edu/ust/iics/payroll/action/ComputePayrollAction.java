package edu.ust.iics.payroll.action;

import edu.ust.iics.payroll.helper.TaxRate;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ComputePayrollAction extends ActionSupport implements TaxRate {

	//input values
	private int hoursWorked;
	private double payRate;
	private String lastName;
	private String firstName;
	
	//computed values
	private double basicPay;
	private double overTimePay;
	private double grossPay;
	private double taxRate;
	private double netPay;
	
	public String execute() {		
		
		setBasicPay((hoursWorked <= 40)
			? hoursWorked * payRate
			: 40 * payRate);	
		
		setOverTimePay((hoursWorked >= 40)
			? (hoursWorked - 40) * payRate * 1.5
			: 0);
		
		setGrossPay(basicPay + overTimePay);
		
		/*
		 * if grossPay is less than 10000, tax rate is 10%
		 * if grossPay is less than 15000, tax rate is 14%
		 * if grossPay is less than 20000, tax rate is 18%
		 * if grossPay is less than 25000, tax rate is 21%
		 * if grossPay is less than 30000, tax rate is 25%
		 * if grossPay is less than 40000, tax rate is 30%
		 * if grossPay is more than or equal to 40000, 
		 * 	tax rate is 35%
		 */
		
		if (grossPay < 10000) {
			setTaxRate(grossPay * LT10K);
		} else if (grossPay < 15000) {
			setTaxRate(grossPay * LT14K);
		} else if (grossPay < 20000) {
			setTaxRate(grossPay * LT20K);
		} else if (grossPay < 25000) {
			setTaxRate(grossPay * LT25K);
		} else if (grossPay < 30000) {
			setTaxRate(grossPay * LT30K);
		} else if (grossPay < 40000) {
			setTaxRate(grossPay * LT40K);
		} else if (grossPay >= 40000) {
			setTaxRate(grossPay * GTE40K);
		}
		
		setNetPay(grossPay - taxRate);
		
		System.out.println("Hours Worked: " + getHoursWorked());
		System.out.println("Pay Rate: Php" + getPayRate());
		System.out.println("Basic Pay: Php" + getBasicPay());
		System.out.println("Overtime Pay: Php" + getOverTimePay());
		System.out.println("Gross Pay: Php" + getGrossPay());
		System.out.println("Withholding Tax: Php" + getTaxRate());
		System.out.println("Net Pay: Php" + getNetPay());
		
		return SUCCESS;	
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		System.out.println("setHoursWorked executed " +
			"- received " + hoursWorked);
		this.hoursWorked = hoursWorked;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		System.out.println("setPayRate executed " +
			"- received " + payRate);
		this.payRate = payRate;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	public double getOverTimePay() {
		return overTimePay;
	}

	public void setOverTimePay(double overTimePay) {
		this.overTimePay = overTimePay;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}
	
	@Override
	public void validate() {
		if (lastName.trim().length() == 0) {
			addFieldError("lastName", "Missing entry for last name.");
		}
		
		if (firstName.trim().length() == 0) {
			addFieldError("firstName", "Missing entry for first name.");
		}
		
		if (hoursWorked < 0) {
			addFieldError("hoursWorked", "Hours worked must be positive.");
		}
		
		if (payRate <= 0) {
			addFieldError("payRate", "Payrate value must be positive.");
		}
		
    }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}





package edu.ust.iics.payroll.action;

import edu.ust.iics.payroll.helper.*;

public class ComputePayrollAction implements TaxPercentage {

	private int hours;
	private double payRate;
	private double basicPay;
	private double overtimePay;
	private double grossPay;
	private double withHoldingTax;
	private double netPay;

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	public double getOvertimePay() {
		return overtimePay;
	}

	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}

	public double getWithHoldingTax() {
		return withHoldingTax;
	}

	public void setWithHoldingTax(double withHoldingTax) {
		this.withHoldingTax = withHoldingTax;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

	public String execute() {
		hours = 60;
		payRate = 1000;
		if (hours < 0) {
			return "error";
		} else {

			setBasicPay((hours <= 40) ? hours * payRate : (40 * payRate));
			setOvertimePay((hours > 40) ? (hours - 40) * payRate * 1.5 : 0);
			setGrossPay(basicPay + overtimePay);

			withHoldingTax = 0;
			if (grossPay < 10000) {
				setWithHoldingTax(grossPay * GPLT10k);
			} else if (grossPay < 18000) {
				setWithHoldingTax(grossPay * GPLT18k);
			} else if (grossPay < 22000) {
				setWithHoldingTax(grossPay * GPLT22k);
			} else if (grossPay < 28000) {
				setWithHoldingTax(grossPay * GPLT28k);
			} else if (grossPay < 35000) {
				setWithHoldingTax(grossPay * GPLT35k);
			} else if (grossPay >= 35000) {
				setWithHoldingTax(grossPay * GPGTE35k);
			}

			setNetPay(grossPay - withHoldingTax);

			System.out.println("Hours Worked: " + getHours());
			System.out.println("Payrate: PHP" + getPayRate());
			System.out.println("Basic Payment: PHP" + getBasicPay());
			System.out.println("Overtime Pay: PHP" + getOvertimePay());
			System.out.println("Gross Pay: PHP" + getGrossPay());
			System.out.println("Withholding Tax: PHP" + getWithHoldingTax());
			System.out.println("Net Payment: PHP" + getNetPay());

			return "success";
		}
	}
}

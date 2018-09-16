package edu.ust.iics.payroll.action;

import edu.ust.iics.payroll.helper.*;

public class ComputePayrollAction implements TaxPercentage {

	public String execute() {
		int hours = -60;
		double payRate = 1000;

		if (hours < 0) {
			return "error";
		} else {
			// grosspay (basicPay + overtimePay), witholding tax, netPay
			double basicPay = (hours <= 40) ? hours * payRate : (40 * payRate);
			double overtimePay = (hours > 40) ? (hours - 40) * payRate * 1.5
					: 0;
			double grossPay = basicPay + overtimePay;

			double withHoldingTax = 0;
			if (grossPay < 10000) {
				withHoldingTax = grossPay * GPLT10k;
			} else if (grossPay < 18000) {
				withHoldingTax = grossPay * GPLT18k;
			} else if (grossPay < 22000) {
				withHoldingTax = grossPay * GPLT22k;
			} else if (grossPay < 28000) {
				withHoldingTax = grossPay * GPLT28k;
			} else if (grossPay < 35000) {
				withHoldingTax = grossPay * GPLT35k;
			} else if (grossPay >= 35000) {
				withHoldingTax = grossPay * GPGTE35k;
			}

			double netPay = grossPay - withHoldingTax;

			System.out.println("Hours Worked: " + hours);
			System.out.println("Payrate: PHP" + payRate);
			System.out.println("Basic Payment: PHP" + basicPay);
			System.out.println("Overtime Pay: PHP" + overtimePay);
			System.out.println("Gross Pay: PHP" + grossPay);
			System.out.println("Withholding Tax: PHP" + withHoldingTax);
			System.out.println("Net Payment: PHP" + netPay);

			return "success";
		}
	}
}

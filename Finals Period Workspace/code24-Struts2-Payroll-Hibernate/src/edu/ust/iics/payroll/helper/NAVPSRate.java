package edu.ust.iics.payroll.helper;

public interface NAVPSRate {
	
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
	
	double LT10K = .10;
	double LT14K = .14;
	double LT20K = .18;
	double LT25K = .21;
	double LT30K = .25;
	double LT40K = .30;
	double GTE40K = .35;
}






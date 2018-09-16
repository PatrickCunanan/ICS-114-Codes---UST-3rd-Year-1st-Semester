package edu.ust.iics.payroll.helper;

public interface TaxPercentage {
	//public static final double kaya naka allcaps kasi constant charot 
	
	/**
	 *  if grosspay is less than 10000, tax percent is 2%
	 *  if grosspay is less than 18000, tax percent is 10%
	 *  if grosspay is less than 22000, tax percent is 15%
	 *  if grosspay is less than 28000, tax percent is 20%
	 *  if grosspay is less than 35000, tax percent is 25%
	 *  if grosspay is more than or equal to 35000, tax percent is 35%
	 */
	
	double GPLT10K = .02;
	double GPLT18K = .10;
	double GPLT22K = .15;
	double GPLT28K = .20;
	double GPLT35K = .25;
	double GPGTE35K = .35;
	
}

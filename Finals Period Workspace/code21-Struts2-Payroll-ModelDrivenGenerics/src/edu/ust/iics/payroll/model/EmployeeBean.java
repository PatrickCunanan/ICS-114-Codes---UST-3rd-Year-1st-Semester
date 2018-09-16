package edu.ust.iics.payroll.model;

import java.sql.*;


public class EmployeeBean {

	private int hoursWorked;
	private double payRate;
	private String lastName;
	private String firstName;
	private double basicPay;
	private double overTimePay;
	private double grossPay;
	private double taxRate;
	private double netPay;

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		System.out.println("setHoursWorked executed " + "- received " + hoursWorked);
		this.hoursWorked = hoursWorked;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		System.out.println("setPayRate executed " + "- received " + payRate);
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

	public void insertRecord(Connection connection) {
		try {
			String sql = "insert into employeesalary(lastName, firstName, hoursWorked, payRate, basicPay, overtimePay, grossPay, withHoldingTax, netPay) values(?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmnt = connection.prepareStatement(sql);
			pstmnt.setString(1, lastName);
			pstmnt.setString(2, firstName);
			pstmnt.setInt(3, hoursWorked);
			pstmnt.setDouble(4, payRate);
			pstmnt.setDouble(5, basicPay);
			pstmnt.setDouble(6, overTimePay);
			pstmnt.setDouble(7, grossPay);
			pstmnt.setDouble(8, taxRate);
			pstmnt.setDouble(9, netPay);
			connection.setAutoCommit(false);
			
			pstmnt.executeUpdate();
			
			connection.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}

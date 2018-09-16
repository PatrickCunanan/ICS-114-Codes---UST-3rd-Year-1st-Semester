package edu.ust.iics.payroll.model;

import java.sql.*;

public class EmployeeBean {
	private int hours;
	private double payRate;
	private String lastName;
	private String firstName;
	private double basicPay;
	private double grossPay;
	private double overtimePay;
	private double withHoldingTax;
	private double netPay;

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

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		System.out.println("setHours() executed - received " + hours);
		this.hours = hours;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		System.out.println("setPayRate() executed - received " + payRate);
		this.payRate = payRate;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}

	public double getOvertimePay() {
		return overtimePay;
	}

	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
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
	
	public void insertRecord(Connection connection){
		try{
			String sql= "insert into employeesalary(lastName, " + 
					"firstName, hoursWorked, payRate, basicPay," +
					" overtimePay, grossPay, withHoldingTax, netPay)" +
					"values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmnt = connection.prepareStatement(sql);
			pstmnt.setString(1, lastName);
			pstmnt.setString(2, firstName);
			pstmnt.setInt(3, hours);
			pstmnt.setDouble(4, payRate);
			pstmnt.setDouble(5, basicPay);
			pstmnt.setDouble(6, overtimePay);
			pstmnt.setDouble(7, grossPay);
			pstmnt.setDouble(8, withHoldingTax);
			pstmnt.setDouble(9, netPay);
			
			pstmnt.executeUpdate();
		} catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
}

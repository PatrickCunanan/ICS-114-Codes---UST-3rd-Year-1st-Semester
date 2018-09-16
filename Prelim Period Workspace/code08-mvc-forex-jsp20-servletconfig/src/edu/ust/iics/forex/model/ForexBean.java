package edu.ust.iics.forex.model;

import edu.ust.iics.forex.utility.ForexRate;

import java.sql.*;

public class ForexBean implements ForexRate{

	private int phpAmount;
	private String currency;
	private double result;
	
	public int getPhpAmount() {
		return phpAmount;
	}
	public void setPhpAmount(int phpAmount) {
		this.phpAmount = phpAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	public void process() {
		switch(currency) {
			case "US$":
				setResult(getPhpAmount() / US$);
				break;
			case "EURO":
				setResult(getPhpAmount() / EURO);
				break;
			case "YEN":
				setResult(getPhpAmount() / YEN);
				break;
			case "AUS$":	
				setResult(getPhpAmount() / AUS$);
				break;
		}
	}
	
	public void insertRecord(Connection connection) {
		try {
			String sql = "insert into forex(phpAmount, " +
					"currency, result) values(?,?,?)";
			
			PreparedStatement pstmnt = 
				connection.prepareStatement(sql);
			pstmnt.setInt(1, phpAmount);
			pstmnt.setString(2, currency);
			pstmnt.setDouble(3, result);
			
			//commit to the database
			pstmnt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public ResultSet getAllRecords(Connection connection) {
		ResultSet records = null;
		try {
			String sql = "select * from forex";
			
			PreparedStatement pstmnt = 
					connection.prepareStatement(sql);
			
			records = pstmnt.executeQuery();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return records;
	}
}






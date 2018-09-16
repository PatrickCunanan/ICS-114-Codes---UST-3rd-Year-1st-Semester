package home.sales.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayBean {
	private String eName;
	private char sCode;
	private double sAmount;
	private double sGross;
	private double sCommission;
	private double takeHomePay;
	private boolean isValidSalesCode;
	private boolean isValidSalesAmount;

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public char getsCode() {
		return sCode;
	}

	public void setsCode(char sCode) {
		this.sCode = sCode;
	}

	public double getsAmount() {
		return sAmount;
	}

	public void setsAmount(double sAmount) {
		this.sAmount = sAmount;
	}

	public double getsGross() {
		return sGross;
	}

	public void setsGross(double sGross) {
		this.sGross = sGross;
	}

	public double getsCommission() {
		return sCommission;
	}

	public void setsCommission(double sCommission) {
		this.sCommission = sCommission;
	}

	public double gettakeHomePay() {
		return takeHomePay;
	}

	public void settakeHomePay(double takeHomePay) {
		this.takeHomePay = takeHomePay;
	}

	public boolean isValidSalesCode() {
		return isValidSalesCode;
	}

	public void setValidSalesCode(boolean isValidSalesCode) {
		this.isValidSalesCode = isValidSalesCode;
	}

	public boolean isValidSalesAmount() {
		return isValidSalesAmount;
	}

	public void setValidSalesAmount(boolean isValidSalesAmount) {
		this.isValidSalesAmount = isValidSalesAmount;
	}

	public void computeGross() {
		switch (sCode) {
		case 'A': {
			sGross = 175 + (sAmount * 0.50);
			setsGross(sGross);
			break;
		}
		case 'B': {
			sGross = 100 + (sAmount * 0.20);
			setsGross(sGross);
			break;
		}
		case 'C': {
			sGross = 50 + (sAmount * 0.25);
			setsGross(sGross);
			break;
		}
		}
	}

	public void computeCommission() {
		if (sAmount > 2500) {
			sCommission = sAmount * 0.075;
			setsCommission(sCommission);
		}
	}

	public void computeTakeHomePay() {
		takeHomePay = sGross + sCommission;
		settakeHomePay(takeHomePay);

	}

	public void insertRecord(Connection connection) {
		try {
			String sql = "";
			if (sCode == 'A' && takeHomePay > 2500) {
				sql = "insert into salescommissiona(name, amount, grossCommission, salesCommission, takeHomePay) values(?,?,?,?,?)";
				PreparedStatement pstmnt = connection.prepareStatement(sql);
				pstmnt.setString(1, eName);
				pstmnt.setDouble(2, sAmount);
				pstmnt.setDouble(3, sGross);
				pstmnt.setDouble(4, sCommission);
				pstmnt.setDouble(5, takeHomePay);
				pstmnt.executeUpdate();
			} else if (sCode == 'B' && takeHomePay > 2000) {
				sql = "insert into salescommissionb(name, amount, grossCommission, salesCommission, takeHomePay) values(?,?,?,?,?)";
				PreparedStatement pstmnt = connection.prepareStatement(sql);
				pstmnt.setString(1, eName);
				pstmnt.setDouble(2, sAmount);
				pstmnt.setDouble(3, sGross);
				pstmnt.setDouble(4, sCommission);
				pstmnt.setDouble(5, takeHomePay);
				pstmnt.executeUpdate();
			} else if (sCode == 'C' && takeHomePay > 1500) {
				sql = "insert into salescommissionc(name, amount, grossCommission, salesCommission, takeHomePay) values(?,?,?,?,?)";
				PreparedStatement pstmnt = connection.prepareStatement(sql);
				pstmnt.setString(1, eName);
				pstmnt.setDouble(2, sAmount);
				pstmnt.setDouble(3, sGross);
				pstmnt.setDouble(4, sCommission);
				pstmnt.setDouble(5, takeHomePay);
				pstmnt.executeUpdate();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public ResultSet getAllRecords(Connection connection, char sCode) {
		ResultSet records = null;
		try {
			String sql = "select * from ";
			if (sCode == 'A') {
				sql = sql + "salescommissiona";
			} else if (sCode == 'B') {
				sql = sql + "salescommissionb";
			} else if (sCode == 'C') {
				sql = sql + "salescommissionc";
			}

			PreparedStatement pstmnt = connection.prepareStatement(sql);
			records = pstmnt.executeQuery();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return records;
	}

}

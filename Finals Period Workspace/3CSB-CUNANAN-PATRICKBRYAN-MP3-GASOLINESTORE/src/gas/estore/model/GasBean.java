package gas.estore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gas.estore.utility.ConvertTagalog;

public class GasBean {
	private String gType;
	private double gLiters;
	private double pPerLiter;
	private double pAmount;
	private double vTax;
	private double tAmount;
	private String tConvert;
	private String cType;
	private String cNumber;

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	public String getgType() {
		return gType;
	}

	public void setgType(String gType) {
		this.gType = gType;
	}

	public double getgLiters() {
		return gLiters;
	}

	public void setgLiters(double gLiters) {
		this.gLiters = gLiters;
	}

	public double getpPerLiter() {
		return pPerLiter;
	}

	public void setpPerLiter(double pPerLiter) {
		this.pPerLiter = pPerLiter;
	}

	public double getpAmount() {
		return pAmount;
	}

	public void setpAmount(double pAmount) {
		this.pAmount = pAmount;
	}

	public double getvTax() {
		return vTax;
	}

	public void setvTax(double vTax) {
		this.vTax = vTax;
	}

	public double gettAmount() {
		return tAmount;
	}

	public void settAmount(double tAmount) {
		this.tAmount = tAmount;
	}

	public String gettConvert() {
		return tConvert;
	}

	public void settConvert(String tConvert) {
		this.tConvert = tConvert;
	}

	public void computeValues() {
		double pAmountHolder = 0.0;
		double vTaxHolder = 0.0;
		double tAmountHolder = 0.0;
		ConvertTagalog c = new ConvertTagalog();
		pAmountHolder = gLiters * pPerLiter;
		setpAmount(pAmountHolder);
		vTaxHolder = pAmountHolder * 0.12;
		setvTax(vTaxHolder);
		tAmountHolder = pAmountHolder + vTaxHolder;
		settAmount(tAmountHolder);
		settConvert(c.convert(tAmountHolder));
	}

	public void insertRecord(Connection connection) {
		try {
			String sql = "";
			sql = "insert into customerpurchase(gType, gLiters, pPerLiter, pAmount, vTax, tAmount) values(?,?,?,?,?,?)";
			PreparedStatement pstmnt = connection.prepareStatement(sql);
			pstmnt.setString(1, gType);
			pstmnt.setDouble(2, gLiters);
			pstmnt.setDouble(3, pPerLiter);
			pstmnt.setDouble(4, pAmount);
			pstmnt.setDouble(5, vTax);
			pstmnt.setDouble(6, tAmount);
			pstmnt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public ResultSet getAllRecords(Connection connection) {
		ResultSet records = null;
		try {
			String sql = "select * from customerpurchase";
			PreparedStatement pstmnt = connection.prepareStatement(sql);
			records = pstmnt.executeQuery();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return records;
	}

}

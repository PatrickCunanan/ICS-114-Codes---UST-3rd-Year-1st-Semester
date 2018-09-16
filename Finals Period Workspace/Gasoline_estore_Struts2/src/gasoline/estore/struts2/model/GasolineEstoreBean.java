package gasoline.estore.struts2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GasolineEstoreBean {
	
	private String gasolineType;
	private int gasolineLiter;
	private String creditType;
	private double vat;
	private String creditNumber;
	private double purchaseAmount;
	private double totalPurchaseAmount;
	private String message;
	private double pricePerLiter;
	
	public void insertRecords(Connection connection){
		try{
			String sql = "insert into customerpurchase(gType,gLiters,pPerLiter,pAmount,vTax,tAmount) values(?,?,?,?,?,?)";
			PreparedStatement prdstmt = connection.prepareStatement(sql);
			prdstmt.setString(1, gasolineType);
			prdstmt.setDouble(2, gasolineLiter);
			prdstmt.setDouble(3, pricePerLiter);
			prdstmt.setDouble(4, purchaseAmount);
			prdstmt.setDouble(5, vat);
			prdstmt.setDouble(6, totalPurchaseAmount);
			
			
			prdstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public double getPricePerLiter() {
		return pricePerLiter;
	}
	public void setPricePerLiter(double pricePerLiter) {
		this.pricePerLiter = pricePerLiter;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getGasolineType() {
		return gasolineType;
	}
	public void setGasolineType(String gasolineType) {
		this.gasolineType = gasolineType;
	}
	public int getGasolineLiter() {
		return gasolineLiter;
	}
	public void setGasolineLiter(int gasolineLiter) {
		this.gasolineLiter = gasolineLiter;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public String getCreditNumber() {
		return creditNumber;
	}
	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}
	public double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public double getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}
	public void setTotalPurchaseAmount(double totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
}

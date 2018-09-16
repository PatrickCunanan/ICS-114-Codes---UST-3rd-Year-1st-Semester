package funds.investment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="FundInvestor")
public class FundBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	private double amount;
	private String fundType;
	private double navps;
	private double slAmount;
	private double netAmount;
	private double totalShares;
	
	
	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getFundType() {
		return fundType;
	}


	public void setFundType(String fundType) {
		this.fundType = fundType;
	}


	public double getNavps() {
		return navps;
	}


	public void setNavps(double navps) {
		this.navps = navps;
	}


	public double getSlAmount() {
		return slAmount;
	}


	public void setSlAmount(double slAmount) {
		this.slAmount = slAmount;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public double getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}


	public double getTotalShares() {
		return totalShares;
	}


	public void setTotalShares(double totalShares) {
		this.totalShares = totalShares;
	}

}

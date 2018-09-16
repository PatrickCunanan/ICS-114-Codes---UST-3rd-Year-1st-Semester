package bpi.forex.model;
import bpi.forex.utility.ForexRate;
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
	public void process(){
		if(currency.equals("US$")){
			setResult(phpAmount / US$ );
		}
		else if (currency.equals("EURO")){
			setResult( phpAmount / EURO);
		}
		else if (currency.equals("YEN")){
			setResult( phpAmount / YEN);
		}
		else if (currency.equals("AUS$")){
			setResult( phpAmount / AUS$);
		}
	}

}

package home.sales.model;

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

}

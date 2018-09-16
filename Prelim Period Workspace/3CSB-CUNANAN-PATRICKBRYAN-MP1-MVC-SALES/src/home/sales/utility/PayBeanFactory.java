package home.sales.utility;

import home.sales.model.PayBean;

public class PayBeanFactory {
	private static boolean salesValid;
	private static boolean codeValid;

	public static boolean isValidSalesCode(char sCode) {
		if ((sCode == 'A' || sCode == 'B' || sCode == 'C')) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidSalesAmount(double sAmount) {
		if (sAmount >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static PayBean getInstance(String eName, char sCode, double sAmount) {
		PayBean b = new PayBean();

		codeValid = isValidSalesCode(sCode);
		salesValid = isValidSalesAmount(sAmount);

		if ((codeValid == true) && (salesValid == true)) {
			b.setValidSalesAmount(salesValid);
			b.setValidSalesCode(codeValid);
			b.setsCode(sCode);
			b.seteName(eName);
			b.setsAmount(sAmount);
			b.computeGross();
			b.computeCommission();
			b.computeTakeHomePay();

		} else if ((codeValid == true) && (salesValid == false)) {
			b.setValidSalesAmount(salesValid);
			b.setValidSalesCode(codeValid);
		} else if ((codeValid == false) && (salesValid == true)) {
			b.setValidSalesAmount(salesValid);
			b.setValidSalesCode(codeValid);
		} else if ((codeValid == false) && (salesValid == false)) {
			b.setValidSalesAmount(salesValid);
			b.setValidSalesCode(codeValid);
		}

		return b;

	}
}

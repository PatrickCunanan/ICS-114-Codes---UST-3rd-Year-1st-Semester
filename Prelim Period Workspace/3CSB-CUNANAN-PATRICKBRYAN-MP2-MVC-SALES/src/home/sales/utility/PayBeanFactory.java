package home.sales.utility;

import home.sales.model.PayBean;
import java.sql.Connection;

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

	public static PayBean getInstance(String eName, char sCode, double sAmount, Connection connection) {
		PayBean b = new PayBean();

		salesValid = isValidSalesAmount(sAmount);

		if (salesValid == true) {
			b.setValidSalesAmount(salesValid);
			b.setValidSalesCode(codeValid);
			b.setsCode(sCode);
			b.seteName(eName);
			b.setsAmount(sAmount);
			b.computeGross();
			b.computeCommission();
			b.computeTakeHomePay();
			b.insertRecord(connection);

		} else if (salesValid == false) {
			b.setValidSalesAmount(salesValid);
		} 

		return b;

	}
}

package gas.estore.utility;

import java.sql.Connection;

import gas.estore.model.*;
import gas.estore.utility.InvalidCreditCardNumberException;

public class GasBeanFactory {
	public static GasBean getInstance(String gType, double gLiters, double pPerLiter, String cType, String cNumber,
			Connection connection)throws InvalidCreditCardNumberException {

		GasBean g = new GasBean();
		g.setgType(gType);
		g.setgLiters(gLiters);
		g.setpPerLiter(pPerLiter);
		g.computeValues();
		
		if(luhnTest(cNumber)){
			g.setcNumber(cNumber);
			g.setcType(cType);
		}
		else{
			throw new InvalidCreditCardNumberException("The credit card you have entered is invalid.");
		}

		g.insertRecord(connection);
		return g;
	}

	public static boolean luhnTest(String number) {
		int s1 = 0, s2 = 0;

		String reverse = new StringBuffer(number).reverse().toString();

		for (int i = 0; i < reverse.length(); i++) {

			int digit = Character.digit(reverse.charAt(i), 10);

			if (i % 2 == 0) {
				s1 += digit;
			} else {
				s2 += 2 * digit;
				if (digit >= 5) {
					s2 -= 9;
				}
			}
		}

		return (s1 + s2) % 10 == 0;
	}
}

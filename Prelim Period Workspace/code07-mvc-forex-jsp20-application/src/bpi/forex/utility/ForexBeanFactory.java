package bpi.forex.utility;

import bpi.forex.model.ForexBean;
import java.sql.Connection;
public class ForexBeanFactory {

	public static ForexBean getInstance(int phpAmount, String currency, Connection connection){
		ForexBean forex = new ForexBean();
		forex.setPhpAmount(phpAmount);
		forex.setCurrency(currency);
		forex.process();
		forex.insertRecord(connection);
		
		return forex;
	}

}

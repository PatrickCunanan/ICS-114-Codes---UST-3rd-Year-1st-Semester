package edu.ust.iics.forex.utility;

import edu.ust.iics.forex.model.ForexBean;

import java.sql.Connection;

public class ForexHelper {

	public static ForexBean getInstance(int phpAmount, 
		String currency, Connection connection) {
		
		ForexBean forex = new ForexBean();
		forex.setPhpAmount(phpAmount);
		forex.setCurrency(currency);
		forex.process();
		forex.insertRecord(connection);
		
		return forex;
	}
}

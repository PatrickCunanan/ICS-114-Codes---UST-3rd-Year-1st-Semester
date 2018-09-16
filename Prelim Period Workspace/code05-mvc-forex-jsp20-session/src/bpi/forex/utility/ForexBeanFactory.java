package bpi.forex.utility;

import bpi.forex.model.ForexBean;

public class ForexBeanFactory {

	public static ForexBean getInstance(int phpAmount, String currency){
		ForexBean forex = new ForexBean();
		forex.setPhpAmount(phpAmount);
		forex.setCurrency(currency);
		forex.process();
		
		return forex;
	}

}

package gasoline.estore.struts2.action;

import java.math.BigDecimal;
import java.sql.Connection;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import gasoline.estore.struts2.utility.DBConnectionUtil;
import gasoline.estore.struts2.model.GasolineEstoreBean;
import gasoline.estore.struts2.helper.FuelTypes;
import gasoline.estore.struts2.helper.ProcessTranslation;
@SuppressWarnings("serial")
public class ComputeGasolineAction extends ActionSupport implements FuelTypes, ModelDriven<GasolineEstoreBean>{
	private GasolineEstoreBean gasolinebean = new GasolineEstoreBean();
	
	public GasolineEstoreBean getGasolinebean() {
		return gasolinebean;
	}
	
	public void setGasolinebean(GasolineEstoreBean gasolinebean) {
		this.gasolinebean = gasolinebean;
	}
	
	@Override
	public GasolineEstoreBean getModel() {
		// TODO Auto-generated method stub
		return gasolinebean;
	}
	
	public String execute(){
		ProcessTranslation translator = new ProcessTranslation();
		
		switch(gasolinebean.getGasolineType().toUpperCase()){
			case "DIESEL":{
				gasolinebean.setPurchaseAmount(DIESEL * gasolinebean.getGasolineLiter());
				gasolinebean.setPricePerLiter(DIESEL);
				break;
			}
			case "UNLEADED":{
				gasolinebean.setPurchaseAmount(UNLEADED * gasolinebean.getGasolineLiter());
				gasolinebean.setPricePerLiter(UNLEADED);
				break;
			}
			case "PREMIUM":{
				gasolinebean.setPurchaseAmount(PREMIUM * gasolinebean.getGasolineLiter());
				gasolinebean.setPricePerLiter(PREMIUM);
				break;
			}
		}
		
		BigDecimal a = new BigDecimal(gasolinebean.getPurchaseAmount()+"");
		BigDecimal b = new BigDecimal(".12");
		BigDecimal c = a.multiply(b);
		gasolinebean.setVat(c.doubleValue());
		
		gasolinebean.setTotalPurchaseAmount(gasolinebean.getPurchaseAmount() + gasolinebean.getVat());
		
		gasolinebean.setMessage(translator.translate(gasolinebean.getTotalPurchaseAmount()));
		
		Connection connection  = DBConnectionUtil.getDBConnection();
		gasolinebean.insertRecords(connection);
		
		return SUCCESS;
	}
	
	public void validate(){
		if(gasolinebean.getGasolineLiter() <= 0){
			addFieldError("gasolineLiter", "Wrong input for gasoline liters.");
		}
		if(luhnTest(gasolinebean.getCreditNumber()) == false){
			addFieldError("creditNumber", "This is not a correct credit card number.");
		}
	}
	
	public static boolean luhnTest(String number){
        int s1 = 0, s2 = 0;
        
        String reverse = new StringBuffer(number).reverse().toString();
        
        for(int i = 0 ;i < reverse.length();i++){
        	
            int digit = Character.digit(reverse.charAt(i), 10);
            
            if(i % 2 == 0){
                s1 += digit;
            }else{
                s2 += 2 * digit;
                if(digit >= 5){
                    s2 -= 9;
                }
            }
        }
        
        
        return (s1 + s2) % 10 == 0;
    }
}

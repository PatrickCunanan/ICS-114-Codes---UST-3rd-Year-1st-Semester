package gas.estore.utility;


public class InvalidCreditCardNumberException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidCreditCardNumberException(String message){
		super(message);
	}
}
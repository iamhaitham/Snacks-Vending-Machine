package machine.snack.exceptions;

public class QuantityNotEnoughException extends Exception {
	public QuantityNotEnoughException(String productName) {
		super(String.format("%s is out of stock.", productName));
	}
}

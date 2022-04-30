package machine.snack.exceptions;

public class UnsupportedCurrencyException extends Exception {
	public UnsupportedCurrencyException() {
		super("Only USD is allowed in this machine.");
	}
}

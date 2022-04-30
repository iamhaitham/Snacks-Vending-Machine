package machine.snack.exceptions;

public class UnacceptedCoinException extends Exception {
	public UnacceptedCoinException(double unacceptedCoin) {
		super(String.format("$%.2f is not an accepted coin. Only $0.01, $0.10, $0.20, $0.50 are accepted.", unacceptedCoin));
	}
}

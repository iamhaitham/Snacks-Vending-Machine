package machine.snack.exceptions;

public class MoneyAmountNotEnoughException extends Exception {
	public MoneyAmountNotEnoughException(double remnantCoins) {
		super(String.format("You need to enter %.2f$ more", remnantCoins));
	}
}

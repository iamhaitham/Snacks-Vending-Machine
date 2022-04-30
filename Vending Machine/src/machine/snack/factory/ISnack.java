package machine.snack.factory;

import machine.snack.exceptions.MoneyAmountNotEnoughException;
import machine.snack.exceptions.QuantityNotEnoughException;

public interface ISnack {
	void buy(double[] enteredNotes, double[] enteredCoins);
	void abort(double[] enteredNotes, double[] enteredCoins);
	void calculateRemnant(double productPrice, double[] enteredNotes, double[] enteredCoins) throws MoneyAmountNotEnoughException;
	boolean isQuantityEnough(int productQuantity, String productName) throws QuantityNotEnoughException;
	int getQuantity();
	double getPrice();
}

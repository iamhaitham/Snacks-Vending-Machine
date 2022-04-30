package machine.snack.factory.FifthRow;

import machine.snack.exceptions.MoneyAmountNotEnoughException;
import machine.snack.exceptions.QuantityNotEnoughException;
import machine.snack.exceptions.UnacceptedCoinException;
import machine.snack.exceptions.UnacceptedNoteException;
import machine.snack.factory.ISnack;
import machine.snack.factory.Snack;
import machine.snack.validators.MoneyValidator;

public class FiveDSnack extends Snack implements ISnack {
	private final String NAME = "Five D";
	private static final double PRICE = 1.00;
	private static int quantity = 3;

	public FiveDSnack() {
		super(quantity, PRICE);
	}
	
	public String getProductName() {
		return this.NAME;
	}
	
	public static int getProductQuantity() {
		return quantity;
	}
	
	public static void decreaseQuantity() {
		quantity -= 1;
	}
	
	public static double getProductPrice() {
		return PRICE;
	}
	
	@Override
	public void buy(double[] enteredNotes, double[] enteredCoins) {
		try {
			if(this.isQuantityEnough()){
				MoneyValidator.ValidateCoins(enteredCoins);
				MoneyValidator.ValidateNotes(enteredNotes);
				this.calculateRemnant(enteredNotes, enteredCoins);
				FiveDSnack.decreaseQuantity();
			}
		} catch(QuantityNotEnoughException ex) {
			System.out.println(ex.getMessage());
			cancelOperation();
		} catch(MoneyAmountNotEnoughException ex) {
			System.out.println(ex.getMessage());
			refundUser();
			cancelOperation();
		} catch(UnacceptedCoinException ex) {
			System.out.println(ex.getMessage());
			cancelOperation();
		} catch(UnacceptedNoteException ex) {
			System.out.println(ex.getMessage());
			cancelOperation();
		}
	}

	public void calculateRemnant(double[] enteredNotes, double[] enteredCoins) throws MoneyAmountNotEnoughException {
		super.calculateRemnant(getProductPrice(), enteredNotes, enteredCoins);
	}

	public boolean isQuantityEnough() throws QuantityNotEnoughException {
		return super.isQuantityEnough(getProductQuantity(), getProductName());
	}

}

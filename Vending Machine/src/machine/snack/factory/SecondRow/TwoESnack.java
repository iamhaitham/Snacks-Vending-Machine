package machine.snack.factory.SecondRow;

import machine.snack.exceptions.MoneyAmountNotEnoughException;
import machine.snack.exceptions.QuantityNotEnoughException;
import machine.snack.exceptions.UnacceptedCoinException;
import machine.snack.exceptions.UnacceptedNoteException;
import machine.snack.factory.ISnack;
import machine.snack.factory.Snack;
import machine.snack.validators.MoneyValidator;

public class TwoESnack extends Snack implements ISnack {
	private final String NAME = "Two E";
	private static final int PRICE = 100;
	private static int quantity = 0;
	
	public TwoESnack() {
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
				TwoESnack.decreaseQuantity();
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

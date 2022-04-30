package machine.snack.factory;

import java.util.Arrays;

import machine.snack.exceptions.MoneyAmountNotEnoughException;
import machine.snack.exceptions.QuantityNotEnoughException;
import machine.snack.exceptions.UnacceptedCoinException;
import machine.snack.exceptions.UnacceptedNoteException;
import machine.snack.validators.MoneyValidator;

public class Snack implements ISnack {
	private int quantity; 
	private double price;
	
	public Snack() {
		
	}
	
	public Snack(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public void buy(double[] enteredNotes, double[] enteredCoins) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void abort(double[] enteredNotes, double[] enteredCoins) {
		try {
			if(enteredNotes.length > 0) {
				MoneyValidator.ValidateCoins(enteredCoins);
			}
			if(enteredCoins.length > 0) {
				MoneyValidator.ValidateNotes(enteredNotes);	
			}
			System.out.println("The user has chosen to abort the operation...");
		} catch(UnacceptedNoteException ex) {
			System.out.println(ex.getMessage());
		} catch(UnacceptedCoinException ex) {
			System.out.println(ex.getMessage());
		}
		if(enteredNotes.length > 0 || enteredCoins.length > 0) {
			refundUser();
		}
		System.out.println("Operation aborted.");
	}

	@Override
	public void calculateRemnant(double productPrice, double[] enteredNotes, double[] enteredCoins) throws MoneyAmountNotEnoughException {
		System.out.println("Processing...");
		double enteredNotesSum = Arrays.stream(enteredNotes).sum();
		double enteredCoinsSum = Arrays.stream(enteredCoins).sum();
		double totalSum = enteredNotesSum + enteredCoinsSum;
		if(totalSum > productPrice) {
			System.out.println(String.format("Returning %.2f$ to the user", totalSum - productPrice));
			System.out.println("Enjoy your snack :)");
		} else if (totalSum == productPrice) {
			System.out.println("Enjoy your snack :)");
		} else {
			throw new MoneyAmountNotEnoughException(productPrice - totalSum);
		}
	}

	@Override
	public boolean isQuantityEnough(int productQuantity, String productName) throws QuantityNotEnoughException {
		if(productQuantity > 0) {
			return true;
		}
		throw new QuantityNotEnoughException(productName);
	}
	
	@Override
	public int getQuantity() {
		return this.quantity;
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}
	
	protected void cancelOperation() {
		System.out.println("Cancelling operation...");
		System.out.println("Operation Cancelled");
	}
	
	protected void refundUser() {
		System.out.println("Returning all coins to the user");
	}	
}

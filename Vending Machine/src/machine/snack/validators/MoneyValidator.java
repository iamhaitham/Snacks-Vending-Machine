package machine.snack.validators;

import machine.snack.exceptions.UnacceptedCoinException;
import machine.snack.exceptions.UnacceptedNoteException;

public class MoneyValidator{
	public static void ValidateCoins(double[] enteredCoins) throws UnacceptedCoinException{
		for(double coin: enteredCoins) {
			if(coin == 0.01 || coin == 0.10 || coin == 0.20 || coin == 0.50) {
				continue;
			} else {
				throw new UnacceptedCoinException(coin);
			}
		}
	}
	
	public static void ValidateNotes(double[] enteredNotes) throws UnacceptedNoteException{
		for(double note: enteredNotes) {
			if(note == 20 || note == 50) {
				continue;
			} else {
				throw new UnacceptedNoteException(note);
			}
		}
	}
}

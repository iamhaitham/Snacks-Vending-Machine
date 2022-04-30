package machine.snack.exceptions;

public class UnacceptedNoteException extends Exception {
	public UnacceptedNoteException(double unacceptedNote) {
		super(String.format("$%.2f is not an accepted note. Only $20 and $50 are accepted.", unacceptedNote));
	}
}

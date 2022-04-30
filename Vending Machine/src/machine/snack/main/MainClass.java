package machine.snack.main;

import java.io.IOException;

import machine.snack.exceptions.UnknownProductException;
import machine.snack.exceptions.UnsupportedCurrencyException;

public class MainClass {

	public static void main(String[] args) {
		try {
			SnackMachine.start();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (UnsupportedCurrencyException ex) {
			System.out.println(ex.getMessage());
		} catch (UnknownProductException ex) {
			System.out.println(ex.getMessage());
		}
	}

}

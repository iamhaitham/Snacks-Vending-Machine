package machine.snack.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import machine.snack.exceptions.UnknownProductException;
import machine.snack.exceptions.UnsupportedCurrencyException;
import machine.snack.factory.ISnack;
import machine.snack.factory.SnackFactory;

public class SnackMachine {

	public static void start() throws IOException, UnsupportedCurrencyException, UnknownProductException {
		SnackFactory snackFactory = new SnackFactory();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String willContinue = "Y";
		String willQuit = "N";
		ArrayList<Double> coins = new ArrayList<Double>();
		ArrayList<Double> notes = new ArrayList<Double>();
		
		while(!willQuit.equalsIgnoreCase("Y")) {
			System.out.println("Enter the product code...");
			String snackCode = reader.readLine();
			ISnack selectedSnack = snackFactory.getSnack(snackCode);
			System.out.println("Press 'Y' to continue...");
			willContinue = reader.readLine();
			if(willContinue.equalsIgnoreCase("Y")) {
				if(selectedSnack.getQuantity() > 0) {
					System.out.println(String.format("There are %d unit(s) remaining. You need to enter %.2f$ to buy", selectedSnack.getQuantity(), selectedSnack.getPrice()));
					System.out.println("Press 'Y' to continue...");
					willContinue = reader.readLine();
					if(willContinue.equalsIgnoreCase("Y")) {
						while(willContinue.equalsIgnoreCase("Y")) {
							System.out.println("Will you enter notes? Press 'Y' for Yes");
							String isNotesRequired = reader.readLine();
							if(isNotesRequired.equalsIgnoreCase("Y")) {
								System.out.println("Enter the notes");
								String moneyNotes = reader.readLine();
								System.out.println("Enter currency (Only '$' is accepted)");
								String notesCurrency = reader.readLine();
								if(notesCurrency.equals("$")) {
									notes.add(Double.parseDouble(moneyNotes));
								} else {
									selectedSnack.abort(notes.stream().mapToDouble(d -> d).toArray(), coins.stream().mapToDouble(d -> d).toArray());
									throw new UnsupportedCurrencyException();
								}
							}
							System.out.println("Will you enter coins? Press 'Y' for Yes");
							String isCoinsRequired = reader.readLine();
							if(isCoinsRequired.equalsIgnoreCase("Y")) {
								System.out.println("Now enter the cents (if any)...");
								String moneyCoins = reader.readLine();
								System.out.println("Enter currency (Only '$' is accepted)");
								String centsCurrency = reader.readLine();
								if(centsCurrency.equals("$")) {
									coins.add(Double.parseDouble(moneyCoins));
								} else {
									selectedSnack.abort(notes.stream().mapToDouble(d -> d).toArray(), coins.stream().mapToDouble(d -> d).toArray());
									throw new UnsupportedCurrencyException();
								}	
							}
							System.out.println(String.format("You have entered %.2f notes and %.2f coins so far", notes.stream().mapToDouble(a -> a).sum(), coins.stream().mapToDouble(a -> a).sum()));
							System.out.println("Continue entering money?");
							willContinue = reader.readLine();
						}
						double[] enteredNotes = notes.stream().mapToDouble(d -> d).toArray();
						double[] enteredCoins = coins.stream().mapToDouble(d -> d).toArray();
						selectedSnack.buy(enteredNotes, enteredCoins);
						coins.clear();
						notes.clear();
						System.out.println("Do you want to quit?");
						willQuit = reader.readLine();
					}
				} else {
					System.out.println("Out of stock.");
					System.out.println("Do you want to quit?");
					willQuit = reader.readLine();
				}
			}
		}
	}

}

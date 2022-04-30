package machine.snack.factory;

import machine.snack.exceptions.UnknownProductException;
import machine.snack.factory.FifthRow.FiveASnack;
import machine.snack.factory.FifthRow.FiveBSnack;
import machine.snack.factory.FifthRow.FiveCSnack;
import machine.snack.factory.FifthRow.FiveDSnack;
import machine.snack.factory.FifthRow.FiveESnack;
import machine.snack.factory.FirstRow.OneASnack;
import machine.snack.factory.FirstRow.OneBSnack;
import machine.snack.factory.FirstRow.OneCSnack;
import machine.snack.factory.FirstRow.OneDSnack;
import machine.snack.factory.FirstRow.OneESnack;
import machine.snack.factory.FourthRow.FourASnack;
import machine.snack.factory.FourthRow.FourBSnack;
import machine.snack.factory.FourthRow.FourCSnack;
import machine.snack.factory.FourthRow.FourDSnack;
import machine.snack.factory.FourthRow.FourESnack;
import machine.snack.factory.SecondRow.TwoASnack;
import machine.snack.factory.SecondRow.TwoBSnack;
import machine.snack.factory.SecondRow.TwoCSnack;
import machine.snack.factory.SecondRow.TwoDSnack;
import machine.snack.factory.SecondRow.TwoESnack;
import machine.snack.factory.ThirdRow.ThreeASnack;
import machine.snack.factory.ThirdRow.ThreeBSnack;
import machine.snack.factory.ThirdRow.ThreeCSnack;
import machine.snack.factory.ThirdRow.ThreeDSnack;
import machine.snack.factory.ThirdRow.ThreeESnack;

public class SnackFactory {
	public ISnack getSnack(String productCode) throws UnknownProductException {
		System.out.println(String.format("The user has chosen %s", productCode));
		
		if(productCode.equalsIgnoreCase("1a")) {
			return new OneASnack();
		} else if(productCode.equalsIgnoreCase("1b")) {
			return new OneBSnack();
		} else if(productCode.equalsIgnoreCase("1c")) {
			return new OneCSnack();
		} else if(productCode.equalsIgnoreCase("1d")) {
			return new OneDSnack();
		} else if(productCode.equalsIgnoreCase("1e")) {
			return new OneESnack();
		} else if(productCode.equalsIgnoreCase("2a")) {
			return new TwoASnack();
		} else if(productCode.equalsIgnoreCase("2b")) {
			return new TwoBSnack();
		} else if(productCode.equalsIgnoreCase("2c")) {
			return new TwoCSnack();
		} else if(productCode.equalsIgnoreCase("2d")) {
			return new TwoDSnack();
		} else if(productCode.equalsIgnoreCase("2e")) {
			return new TwoESnack();
		} else if(productCode.equalsIgnoreCase("3a")) {
			return new ThreeASnack();
		} else if(productCode.equalsIgnoreCase("3b")) {
			return new ThreeBSnack();
		} else if(productCode.equalsIgnoreCase("3c")) {
			return new ThreeCSnack();
		} else if(productCode.equalsIgnoreCase("3d")) {
			return new ThreeDSnack();
		} else if(productCode.equalsIgnoreCase("3e")) {
			return new ThreeESnack();
		} else if(productCode.equalsIgnoreCase("4a")) {
			return new FourASnack();
		} else if(productCode.equalsIgnoreCase("4b")) {
			return new FourBSnack();
		} else if(productCode.equalsIgnoreCase("4c")) {
			return new FourCSnack();
		} else if(productCode.equalsIgnoreCase("4d")) {
			return new FourDSnack();
		} else if(productCode.equalsIgnoreCase("4e")) {
			return new FourESnack();
		} else if(productCode.equalsIgnoreCase("5a")) {
			return new FiveASnack();
		} else if(productCode.equalsIgnoreCase("5b")) {
			return new FiveBSnack();
		} else if(productCode.equalsIgnoreCase("5c")) {
			return new FiveCSnack();
		} else if(productCode.equalsIgnoreCase("5d")) {
			return new FiveDSnack();
		} else if(productCode.equalsIgnoreCase("5e")) {
			return new FiveESnack();
		} 
		throw new UnknownProductException();
	}
}

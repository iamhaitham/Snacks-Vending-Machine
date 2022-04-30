package machine.snack.factory;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import machine.snack.exceptions.UnknownProductException;

@RunWith(MockitoJUnitRunner.class)
class SnackFactoryTests {
	private SnackFactory snackFactory = new SnackFactory();
	private final String SUCCESSFUL_PRODUCT_CODE = "1E";
	private final String FAILING_PRODUCT_CODE = "1G";
	
	@Test()
	void testGetSnack_should_throwUnknownProductException() throws UnknownProductException {
		UnknownProductException thrown = assertThrows(
				UnknownProductException.class,
				() -> snackFactory.getSnack(FAILING_PRODUCT_CODE)
				);
		assertTrue(thrown.getMessage().equals("Unknow product."));
	}
	
	@Test()
	void testGetSnack_should_createAnInstance() throws UnknownProductException {
		ISnack createdInstance = snackFactory.getSnack(SUCCESSFUL_PRODUCT_CODE);
		assertTrue(createdInstance instanceof ISnack);
	}

}

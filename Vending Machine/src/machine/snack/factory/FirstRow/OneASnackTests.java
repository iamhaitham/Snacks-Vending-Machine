package machine.snack.factory.FirstRow;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class OneASnackTests {
	private final OneASnack oneASnack = new OneASnack();
	private final String PRODUCT_NAME = "One A";
	private final int PRODUCT_QUANTITY = 10;
	
	@Test
	void testGetProductName_should_returnOneA() {
		assertTrue(oneASnack.getProductName().equals(PRODUCT_NAME));
	}

	@Test
	void testGetProductQuantity_should_returnRealQuantity() {
		assertTrue(oneASnack.getProductQuantity() == PRODUCT_QUANTITY);
	}

	@Test
	void testDecreaseQuantity_whenCalled_quantityShouldDecreaseByOne() {
		OneASnack.decreaseQuantity();
		final int UPDATED_PRODUCT_QUANTITY = 9;
		assertTrue(OneASnack.getProductQuantity() == UPDATED_PRODUCT_QUANTITY);
	}

}

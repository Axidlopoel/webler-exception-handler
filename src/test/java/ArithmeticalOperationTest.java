import hu.webler.exception.CustomException;
import hu.webler.service.ArithmeticalOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticalOperationTest {

    @Test
    void testPerform() {
        ArithmeticalOperation operation = new ArithmeticalOperation();

        // Test case: division with non-zero denominator
        double numerator = 10;
        double denominator = 2;
        double expectedResult = 5;
        try {
            double result = operation.perform(numerator, denominator);
            Assertions.assertEquals(expectedResult, result);
        } catch (CustomException e) {
            Assertions.fail("CustomException should not have been thrown for a valid division operation.");
        }

        // Test case: division with non-zero denominator
        denominator = 0;
        String expectedErrorMessage = "Encountered ArithmeticException: Division by zero";
        try {
            double result = operation.perform(numerator, denominator);
            Assertions.fail("CustomException should have been thrown for division by zero.");
        } catch (CustomException e) {
            Assertions.assertEquals(expectedErrorMessage, e.getMessage());
        }

        // Test case: division with zero denominator
        double copyDenominator = denominator;
        Assertions.assertThrows(CustomException.class, () -> operation.perform(numerator, copyDenominator));
    }
}
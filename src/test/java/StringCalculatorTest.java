import org.example.StringCalculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void testEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testMultipleNumbersWithNewLines() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testIgnoreNumbersGreaterThan1000() {
        assertEquals(2, calculator.add("2,1001"));
    }

    @Test
    public void testDelimitersOfAnyLength() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testMultipleDelimiters() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testMultipleDelimitersOfAnyLength() {
        assertEquals(6, calculator.add("//[***][%%%]\n1***2%%%3"));
    }

    @Test
    public void testNegativeNumbers() {
        try {
            calculator.add("1,-2,3,-4");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed: -2, -4", e.getMessage());
        }
    }
}
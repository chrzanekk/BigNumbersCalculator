package pl.com.konrad.big.numbers.addition;

import org.junit.*;

import static org.junit.Assert.*;

public class BigNumbersAdditionTest {
    private static BigNumbersAddition bigNumbersAddition;

    @Before
    public void setUp() throws Exception {
        bigNumbersAddition = new BigNumbersAddition();
    }

    @Test
    public void testOfAdditionTwoSmallNumbersWithSameLength() {
        String firstNumber = "24";
        String secondNumber = "34";

        String result = bigNumbersAddition.add(firstNumber, secondNumber);

        assertEquals("58", result);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testOfAdditionTwoSmallNumbersWithSameLengthOneIsNegativeResultIsPositive() {
        String firstNumber = "-24";
        String secondNumber = "34";

        String result = bigNumbersAddition.add(firstNumber, secondNumber);

        assertEquals("10", result);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testOfAdditionTwoSmallNumbersWithSameLengthOneIsNegativeResultIsNegative() {
        String firstNumber = "24";
        String secondNumber = "-34";

        String result = bigNumbersAddition.add(firstNumber, secondNumber);

        assertEquals("-10", result);

    }

    @Test
    public void testOfAdditionTwoSmallNumbersWithSameLengthAndShouldReturnThreeDigitString() {
        String firstNumber = "88";
        String secondNumber = "88";

        String result = bigNumbersAddition.add(firstNumber, secondNumber);

        assertEquals("176", result);

    }

    @Test
    public void testOfAdditionTwoSmallNumbersWithDifferentLengthFirstLargerThanSecondByOneDigit() {
        String firstNumber = "188";
        String secondNumber = "88";

        String result = bigNumbersAddition.add(firstNumber, secondNumber);

        assertEquals("276", result);

    }

    @Test
    public void testOfAdditionTwoSmallNumbersWithDifferentLengthFirstLargerThanSecondMoreThanOneDigit() {
        String firstNumber = "11188";
        String secondNumber = "88";

        String result = bigNumbersAddition.add(firstNumber, secondNumber);

        assertEquals("11276", result);

    }

    @Test
    public void testOfAdditionTwoBigNumbersWithSameLength() {
        String firstNumber = "100000000000000000000000002";
        String secondNumber = "100000000000000000000000003";

        String result = bigNumbersAddition.add(firstNumber, secondNumber);

        assertEquals("200000000000000000000000005", result);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testOfAdditionWithOneEmptyStringAndOneCorrectInput() {
        String firstNumber = "";
        String secondNumber = "34";

        String result = bigNumbersAddition.add(firstNumber, secondNumber);

        assertEquals("-10", result);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testOfAdditionWithOneInputWithLettersAndOneInputWithDigits() {
        String firstNumber = "aaa";
        String secondNumber = "34";

        String result = bigNumbersAddition.add(firstNumber, secondNumber);

        assertEquals("-10", result);

    }


}

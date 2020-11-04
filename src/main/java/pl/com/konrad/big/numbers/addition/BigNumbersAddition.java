package pl.com.konrad.big.numbers.addition;

public class BigNumbersAddition {

    public String add(String firstBigNumber, String secondBigNumber) {
        String regex = "\\d+";
        if(firstBigNumber.isEmpty() || secondBigNumber.isEmpty() || !firstBigNumber.matches(regex) || !secondBigNumber.matches(regex)) {
            throw new IllegalArgumentException("Input should contain only digits.");
        }


//        replacing strings so that first one is larger
        if (secondBigNumber.length() > firstBigNumber.length()) {
            String temporary = secondBigNumber;
            secondBigNumber = firstBigNumber;
            firstBigNumber = temporary;
        }

//        reversing strings
        firstBigNumber = StringFormatter.reverseString(firstBigNumber);
        secondBigNumber = StringFormatter.reverseString(secondBigNumber);

//        initializing String variable to storing result
        String result = "";


//        initializing int variable to storing carry number.
        int carry = 0;


//        calculating addition of two string to length of shorter string
        for (int i = 0; i < secondBigNumber.length(); i++) {
            int tempSum =
                    Integer.parseInt(String.valueOf(firstBigNumber.charAt(i)))
                            + Integer.parseInt(String.valueOf(secondBigNumber.charAt(i)))
                            + carry;
            result += String.valueOf(tempSum % 10);
            carry = tempSum / 10;
        }

//      calculating and adding other digits from longer string + adding carry if exists
        for (int i = secondBigNumber.length(); i < firstBigNumber.length(); i++) {
            int tempSum = Integer.parseInt(String.valueOf(firstBigNumber.charAt(i))) + carry;
            result += String.valueOf(tempSum % 10);
            carry = tempSum / 10;
        }

//        adding remained carry if exist
        if (carry > 0) {
            result += String.valueOf(carry);
        }

//      reversing string to correct order.
        result = StringFormatter.reverseString(result);

        return result;

    }

}

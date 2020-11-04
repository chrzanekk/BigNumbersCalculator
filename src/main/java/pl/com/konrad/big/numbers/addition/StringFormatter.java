package pl.com.konrad.big.numbers.addition;

public class StringFormatter {
    public static String reverseString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

}

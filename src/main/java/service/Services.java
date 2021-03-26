package service;

import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Services {
    private static final String REGEX = "[^а-яА-Я\\w\\p{P}\\p{Sm}\\p{N}\\p{Zs}]";

    public static String concatenateWords(String fString, String sString) throws IllegalArgumentException {
        if (fString == null && sString == null) {
            return null;
        }
        if (fString != null && sString == null) {
            return fString;
        }
        if (fString == null) {
            return sString;
        }
        if (Objects.equals(fString, "") && Objects.equals(sString, "")) {
            return "";
        }
        if (Pattern.compile(REGEX).matcher(fString + sString).find()) {
            throw new IllegalArgumentException("Получены не допустимые символы");
        }
        return fString + " " + sString;
    }

    public static BigInteger computeFactorial(int number) {
        return IntStream.rangeClosed(1, number).mapToObj(BigInteger::valueOf).reduce(BigInteger.valueOf(1), BigInteger::multiply);
    }
}

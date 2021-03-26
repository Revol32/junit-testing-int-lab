package service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static service.Services.computeFactorial;
import static service.Services.concatenateWords;

public class ServicesTest {
    @ParameterizedTest
    @DisplayName("Тест Services.concatenateWords() нормальная работа")
    @MethodSource("Providers#testConcatenateWordsNormalProvider")
    void concatenateWordsNormalTest(String fString, String sString, String expected) {
        assertEquals(expected, concatenateWords(fString, sString));
    }

    @ParameterizedTest
    @DisplayName("Тест Services.concatenateWords() неверные символы")
    @MethodSource("Providers#testConcatenateWordsWrongSymbolProvider")
    void concatenateWordsWrongSymbolTest(String fString, String sString) {
        assertThrows(IllegalArgumentException.class, () -> concatenateWords(fString, sString));
    }

    @ParameterizedTest
    @DisplayName("Тест Services.concatenateWords() null и пустая строка")
    @MethodSource("Providers#testConcatenateWordsNullAndEmptyProvider")
    void concatenateWordsNullAndEmptyTest(String fString, String sString, String expected) {
        assertEquals(expected, concatenateWords(fString, sString));
    }

    @ParameterizedTest
    @Disabled
    @DisplayName("Тест Services.computeFactorial()")
    @MethodSource("Providers#testComputeFactorialProvider")
    void computeFactorialTest(int number, BigInteger result) {
        assertEquals(result, computeFactorial(number));
    }

    @ParameterizedTest
    @DisplayName("Тест Services.computeFactorial() c с таймаутом")
    @MethodSource("Providers#testComputeFactorialProvider")
    @Timeout(value = 1100, unit = TimeUnit.MILLISECONDS)
    void computeFactorialWithTimeoutTest(int number, BigInteger result) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        assertEquals(result, computeFactorial(number));
    }
}

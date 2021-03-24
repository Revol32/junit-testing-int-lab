import org.junit.jupiter.params.provider.Arguments;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Providers {

    public static Stream<Arguments> testConcatenateWordsNormalProvider() {
        return Stream.of(
                arguments("Hello", "world!", "Hello world!"),
                arguments("Привет,", "мир!", "Привет, мир!")
        );
    }

    public static Stream<Arguments> testConcatenateWordsWrongSymbolProvider() {
        return Stream.of(
                arguments("\uD83C\uDF08\uD83E\uDD84", "world!"),
                arguments("Привет,", "ツ")
        );
    }

    public static Stream<Arguments> testConcatenateWordsNullAndEmptyProvider() {
        return Stream.of(
                arguments("", "", ""),
                arguments(null, null, null),
                arguments(null, "world!", "world!"),
                arguments("Hello", null, "Hello")
        );
    }

    public static Stream<Arguments> testComputeFactorialProvider() {
        return Stream.of(
                arguments(0, BigInteger.valueOf(1)),
                arguments(1, BigInteger.valueOf(1)),
                arguments(5, BigInteger.valueOf(120)),
                arguments(20, BigInteger.valueOf(2432902008176640000L)),
                arguments(21, new BigInteger("51090942171709440000"))
        );
    }
}

package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {
    static Stream<Arguments> romanToIntegerDataSource() {
        return Stream.of(
                Arguments.of(3, "III"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV"),
                Arguments.of(100, "C"),
                Arguments.of(1000, "M")

        );
    }

    @ParameterizedTest
    @MethodSource("romanToIntegerDataSource")
    public void integerToRomanTest(Integer input, String expected) throws Exception {
        IntegerToRoman obj = new IntegerToRoman();
        assertEquals(expected, obj.intToRoman(input));
    }

}
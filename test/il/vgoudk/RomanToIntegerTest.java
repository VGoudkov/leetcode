package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {
    static Stream<Arguments> romanToIntegerDataSource() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("C", 100)

        );
    }

    @ParameterizedTest
    @MethodSource("romanToIntegerDataSource")
    public void romanToIntegerTest(String input, int expected) throws Exception {
        RomanToInteger obj = new RomanToInteger();
        assertEquals(expected, obj.romanToInt(input));
    }


}
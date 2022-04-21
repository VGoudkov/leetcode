package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseIntegerTest {

    public static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21),
                Arguments.of(0, 0),
                Arguments.of(2, 2),
                Arguments.of(1534236469, 0),
                Arguments.of(2147483647, 0),
                Arguments.of(-2147483648, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testSource")
    public void testReverseInteger(int source, int expected) {
        ReverseInteger obj = new ReverseInteger();
        assertEquals(expected, obj.reverse(source));
    }

}
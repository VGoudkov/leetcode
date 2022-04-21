package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigZagConversionTest {

    static Stream<Arguments> rowsSource() {
        return Stream.of(
                Arguments.of(  "PAHNAPLSIIGYIR", "PAYPALISHIRING", 3),
                Arguments.of("PINALSIGYAHRPI", "PAYPALISHIRING", 4),
                Arguments.of("A","A", 1),
                Arguments.of("AB","AB", 1)

        );
    }

    @ParameterizedTest
    @MethodSource("rowsSource")
    public void test(String expected, String source, int numRows) throws Exception {
        ZigZagConversion obj = new ZigZagConversion();
        assertEquals(expected, obj.convert(source, numRows));
    }


}
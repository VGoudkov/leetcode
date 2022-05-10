package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountAndSayTest {

    static Stream<Arguments> countAndSayDataSource() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(2, "11"),
                Arguments.of(3, "21"),
                Arguments.of(4, "1211")
        );
    }

    @ParameterizedTest
    @MethodSource("countAndSayDataSource")
    public void countAndSayTest(int input, String expected) throws Exception {
        CountAndSay obj = new CountAndSay();
        assertEquals( expected, obj.countAndSay(input));
    }


}
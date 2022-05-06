package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrStrTest {

    static Stream<Arguments> strStrDataSource() {
        return Stream.of(
                Arguments.of("mississippi", "a", -1),
                Arguments.of("hello", "ll", 2),
                Arguments.of("hello", "llo", 2),
                Arguments.of("hel", "hel", 0),
                Arguments.of("aaaaa", "bba", -1),
                Arguments.of("a", "a", 0),
                Arguments.of("a", "", 0),
                Arguments.of("", "a", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("strStrDataSource")
    public void strStrTest(String haystack, String needle, int expected) throws Exception {
        StrStr obj = new StrStr();
        assertEquals(expected, obj.strStr(haystack, needle));
    }


}
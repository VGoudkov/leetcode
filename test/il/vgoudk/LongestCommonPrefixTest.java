package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {


    static Stream<Arguments> longestCommonPrefixdataSource() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, ""),
                Arguments.of(new String[]{"d", "r", "a"}, ""),
                Arguments.of(new String[]{"d", "d", "d"}, "d"),
                Arguments.of(new String[]{"a"}, "a")
        );
    }

    @ParameterizedTest
    @MethodSource("longestCommonPrefixdataSource")
    public void longestCommonPrefixTest(String[] input, String expected) throws Exception {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        assertEquals(expected, obj.longestCommonPrefix(input));
    }


}
package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringTest {


    static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of(" ", 1),
                Arguments.of("aab", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void testLongestSubstring(String source, int expectedMaxLen) {
        LongestSubstring obj = new LongestSubstring();
        assertEquals(expectedMaxLen, obj.lengthOfLongestSubstring(source));
    }

}
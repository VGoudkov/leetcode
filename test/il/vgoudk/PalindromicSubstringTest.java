package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromicSubstringTest {

    static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("babad", new String[]{"bab", "aba"}),
                Arguments.of("cbbd", new String[]{"bb"}),
                Arguments.of("e", new String[]{"e"}),
                Arguments.of("asabccab12344321rsa", new String[]{"12344321"}),
                Arguments.of("asacccccasa", new String[]{"asacccccasa"}),
                Arguments.of("abccccccded", new String[]{"cccccc"}),
                Arguments.of("accbccccccded", new String[]{"cccccc"}),
                Arguments.of("ac", new String[]{"a"}),
                Arguments.of("bb", new String[]{"b"})
                );

    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void test(String input, String[] expected) throws Exception {
        PalindromicSubstring obj = new PalindromicSubstring();
        final String actual = obj.longestPalindrome(input);

        assertTrue(Arrays.asList(expected).contains(actual), actual + " <-> "+String.join(",",expected));
    }
}
package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IsPalindromeTest {
    static Stream<Arguments> isPalindromDataSource() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false),
                Arguments.of(-10, false),
                Arguments.of(0, true),
                Arguments.of(99, true),
                Arguments.of(-99, false)

        );
    }

    @ParameterizedTest
    @MethodSource("isPalindromDataSource")
    public void isPalindromTest(int input, boolean expected) throws Exception {
        IsPalindrome obj = new IsPalindrome();
        assertEquals( expected, obj.isPalindrome(input));
    }


}
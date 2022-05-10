package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LastWordLengthTest {

    static Stream<Arguments> lastWordLengthDataSource() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6),
                Arguments.of("a", 1),
                Arguments.of(" a", 1),
                Arguments.of("a " , 1)
        );
    }

    @ParameterizedTest
    @MethodSource("lastWordLengthDataSource")
    public void lastWordLengthTest(String input, int expected) throws Exception {
        LastWordLength obj = new LastWordLength();
        assertEquals(expected, obj.lengthOfLastWord(input) );

    }


}
package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesisTest {

    static Stream<Arguments> generateParenthesisDataSource() {
        return Stream.of(
                Arguments.of(1, Arrays.asList("()")),
                Arguments.of(2, Arrays.asList("(())","()()")),
                Arguments.of(3, Arrays.asList("((()))","(()())","(())()","()(())","()()()"))
        );
    }

    @ParameterizedTest
    @MethodSource("generateParenthesisDataSource")
    public void generateParenthesisTest(int input, List<String> expected) throws Exception {
        GenerateParenthesis obj = new GenerateParenthesis();
        final List<String> combinations = obj.generateParenthesis(input);
        assertEquals( expected.size(), combinations.size() );
        assertTrue( expected.containsAll( combinations) );
    }


}
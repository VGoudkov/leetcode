package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AllDivisionWithHighScoreTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testAll( int[] source, int[] answers)  {
        AllDivisionWithHighScore obj = new AllDivisionWithHighScore();
        List<Integer> answersList = new ArrayList<>(answers.length);
        for (int answer : answers) {
            answersList.add(answer);
        }
        assertTrue(answersList.containsAll( obj.maxScoreIndices(source)));
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 1, 0}, new int[]{4, 2}),
                Arguments.of(new int[]{0, 0, 0}, new int[]{3}),
                Arguments.of(new int[]{1, 1}, new int[]{0})
        );
    }


}
package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RemoveElementTest {

    static Stream<Arguments> arraysDataSource() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, 2),
                Arguments.of(new int[]{0,1,2,2,3,0,4,2}, 2, 5),
                Arguments.of(new int[]{}, 2, 0),
                Arguments.of(new int[]{2}, 3, 1),
                Arguments.of(new int[]{2,2,2}, 3, 3)

        );
    }

    @ParameterizedTest
    @MethodSource("arraysDataSource")
    public void arraysTest(int[] input, int val, int expected) throws Exception {
        RemoveElement obj = new RemoveElement();
        final int validValuesCount = obj.removeElement(input, val);
        assertEquals( expected, validValuesCount);
        assertTrue(notCointains(input, val, validValuesCount));
    }

    boolean notCointains(int[] data, int val, int limit) {
        for (int i = 0; i < limit; i++) {
            if (data[i] == val) return false;
        }
        return true;
    }


}
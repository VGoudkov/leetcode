package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SwapNodesInPairsTest {
    static Stream<Arguments> swapPairsDataSource() {
        return Stream.of(
                Arguments.of(asList(1, 2, 3, 4), asList(2, 1, 4, 3)),
                Arguments.of(asList(1, 2, 3, 4, 5), asList(2, 1, 4, 3, 5)),
                Arguments.of(asList(1, 2, 3, 4, 5, 6), asList(2, 1, 4, 3, 6, 5)),
                Arguments.of(asList(), null),
                Arguments.of(asList(1), asList(1))
        );
    }

    @ParameterizedTest
    @MethodSource("swapPairsDataSource")
    public void swapPairsTest(List<Integer> input, List<Integer> expected) throws Exception {
        SwapNodesInPairs obj = new SwapNodesInPairs();
        assertEquals(expected, ListNode.toList(obj.swapPairs(ListNode.of(input))));
    }
}
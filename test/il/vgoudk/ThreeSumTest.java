package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {
    static Stream<Arguments> threeSumDataSource() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(
                                Arrays.asList(-1, -1, 2),
                                Arrays.asList(-1, 0, 1)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("threeSumDataSource")
    public void threeSumTest(int[] input, List<List<Integer>> expected) throws Exception {
        ThreeSum obj = new ThreeSum();
        final List<List<Integer>> actual = obj.threeSum(input);

    }


}
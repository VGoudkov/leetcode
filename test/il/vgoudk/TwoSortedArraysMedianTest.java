package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSortedArraysMedianTest {

    static Stream<Arguments> findMedianSortedArraysDataSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2.0),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5),
                Arguments.of(new int[]{1, 2, 3, 6}, new int[]{2, 3, 5}, 3),
                Arguments.of(new int[]{1}, new int[]{2}, 1.5),
                Arguments.of(new int[]{1}, new int[]{1}, 1.0),
                Arguments.of(new int[]{1}, new int[]{}, 1.0),
                Arguments.of(new int[]{}, new int[]{2}, 2.0)
        );
    }

    @ParameterizedTest
    @MethodSource("findMedianSortedArraysDataSource")
    public void findMedianSortedArraysTest(int[] arr1, int[] arr2, double expected) throws Exception {
        TwoSortedArraysMedian obj = new TwoSortedArraysMedian();
        assertEquals(expected, obj.findMedianSortedArrays(arr1, arr2), 1e-6);
    }
}
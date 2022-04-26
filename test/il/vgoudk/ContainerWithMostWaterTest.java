package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {
    static Stream<Arguments> mostWaterContainerDataSource() {
        return Stream.of(
                Arguments.of(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                Arguments.of(new int[]{1,1}, 1),
                Arguments.of(new int[]{2,3,4,5,18,17,6}, 17)
        );
    }

    @ParameterizedTest
    @MethodSource("mostWaterContainerDataSource")
    public void mostWaterContainerTest(int[] heights, int expectedArea) throws Exception {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        assertEquals( expectedArea, obj.maxArea( heights));
    }


}
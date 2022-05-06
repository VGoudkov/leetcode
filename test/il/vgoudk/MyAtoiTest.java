package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyAtoiTest {
    static Stream<Arguments> myAtoiDataSource() {
        return Stream.of(
                Arguments.of("-6147483648", Integer.MIN_VALUE),
                Arguments.of("", 0),
                Arguments.of("-91283472332", -2147483648),
                Arguments.of("91283472332", 2147483647),
                Arguments.of("42", 42),
                Arguments.of("   -42", -42),
                Arguments.of("4193 with words", 4193),
                Arguments.of("99999999999999" , Integer.MAX_VALUE),
                Arguments.of("-99999999999999" , Integer.MIN_VALUE),
                Arguments.of("-2147483648" , Integer.MIN_VALUE),
                Arguments.of("-2147483647" , -2147483647),
                Arguments.of("2147483647" , Integer.MAX_VALUE),
                Arguments.of("2147483646" , 2147483646),
                Arguments.of("0" , 0),
                Arguments.of("4" , 4)
        );
    }

    @ParameterizedTest
    @MethodSource("myAtoiDataSource")
    public void myAtoiTest(String input, int expected) throws Exception {
        MyAtoi obj = new MyAtoi();
        assertEquals(expected, obj.myAtoi(input));
    }


}
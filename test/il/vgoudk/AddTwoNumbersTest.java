package il.vgoudk;

import il.vgoudk.AddTwoNumbers.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbersTest {
    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("2,4,3", "5,6,4", "7,0,8"),
                Arguments.of("0", "0", "0"),
                Arguments.of("9,9,9,9,9,9,9", "9,9,9,9", "8,9,9,9,0,0,0,1")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testCalculations(String number1, String number2, String expected) throws Exception {
        ListNode root1 = new ListNode();
        ListNode root2 = new ListNode();
        toNodesList(root1, number1);
        toNodesList(root2, number2);
        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode result = obj.addTwoNumbers(root1, root2);
        String stringResult = toString(result);
        assertEquals(expected, stringResult);
    }

    void toNodesList(ListNode root, String number) {
        String[] digits = number.split(",");
        ListNode current = root;
        for (int i = 0; i < digits.length; i++) {
            String digit = digits[i];
            current.val = Integer.parseInt(digit);
            if (i == digits.length - 1) {
                return;
            }
            current.next = new ListNode();
            current = current.next;
        }
    }

    String toString(ListNode root) {
        List<String> digits = new ArrayList<>();
        ListNode current = root;
        while (current != null) {
            digits.add(String.valueOf(current.val));
            current = current.next;
        }
        return String.join(",", digits);
    }


}
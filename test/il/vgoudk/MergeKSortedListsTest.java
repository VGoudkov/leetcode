package il.vgoudk;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static il.vgoudk.MergeKSortedLists.flatten;
import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {

    static Stream<Arguments> mergeKSortedListsDataSource() {

        ListNode root1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode root2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode root3 = new ListNode(2, new ListNode(6));
        ListNode root123 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6))))))));



        return Stream.of(
                Arguments.of(new ListNode[]{root1,root2,root3}, root123),
                Arguments.of(null, null),
                Arguments.of(new ListNode[]{}, null)
        );
    }

    @ParameterizedTest
    @MethodSource("mergeKSortedListsDataSource")
    public void mergeKSortedListsTest(ListNode[] input, ListNode expected) throws Exception {
        MergeKSortedLists obj = new MergeKSortedLists();
        assertEquals( flatten( expected),flatten( obj.mergeKLists(input)) );
    }

    @Test
    public void testFlatten(){
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3)));
        assertEquals(Arrays.asList(1,2,3),flatten( root));
    }

}
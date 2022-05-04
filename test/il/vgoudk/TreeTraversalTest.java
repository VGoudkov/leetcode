package il.vgoudk;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TreeTraversalTest {

    TreeNode root;
    TreeTraversal obj;
    @BeforeEach
    public void prepareAll(){
        root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        obj = new TreeTraversal();
    }
    
    @Test
    void inOrderTraversal() {
        assertEquals(Arrays.asList(4,2,5,1,3), obj.inOrderTraversal(root));
    }

    @Test
    void preOrderTraversal() {
        assertEquals(Arrays.asList(1,2,4,5,3), obj.preOrderTraversal(root));
    }

    @Test
    void postOrderTraversal() {
        assertEquals(Arrays.asList(4,5,2,3,1), obj.postOrderTraversal(root));
    }

    @Test
    void breadthOrderTraversal() {
        assertEquals(Arrays.asList(1,2,3,4,5), obj.breadthOrderTraversal(root));
    }
}
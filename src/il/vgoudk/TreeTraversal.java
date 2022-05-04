package il.vgoudk;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {


    List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        visitInOrder(root, visited);
        return visited;
    }

    List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        visitPreOrder(root, visited);
        return visited;
    }

    List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        visitPostOrder(root, visited);
        return visited;

    }

    List<Integer> breadthOrderTraversal(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        visited.add(root.val);
        visitBreadhFirtstOrder(root, visited);
        return visited;
    }

    private void visitInOrder(TreeNode node, List<Integer> visited) {
        if (node.left != null) visitInOrder(node.left, visited);
        visited.add(node.val);
        if (node.right != null) visitInOrder(node.right, visited);
    }

    private void visitPreOrder(TreeNode node, List<Integer> visited) {
        visited.add(node.val);
        if (node.left != null) visitPreOrder(node.left, visited);
        if (node.right != null) visitPreOrder(node.right, visited);
    }

    private void visitPostOrder(TreeNode node, List<Integer> visited) {
        if (node.left != null) visitPostOrder(node.left, visited);
        if (node.right != null) visitPostOrder(node.right, visited);
        visited.add(node.val);
    }

    private void visitBreadhFirtstOrder(TreeNode node, List<Integer> visited) {

        if (node.left != null) {
            visited.add(node.left.val);
        }
        if (node.right != null) {
            visited.add(node.right.val);
        }
        if (node.left != null) {
            visitBreadhFirtstOrder(node.left, visited);
        }
        if (node.right != null) {
            visitBreadhFirtstOrder(node.right, visited);
        }
    }

}
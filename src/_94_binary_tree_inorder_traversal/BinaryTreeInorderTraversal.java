package _94_binary_tree_inorder_traversal;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangchen
 * @date 2021/03/15
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}

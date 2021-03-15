package _102_binary_tree_level_order_traversal;

import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    ArrayDeque<TreeNode> tmpQueue = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        tmpQueue.add(root);
        while (!tmpQueue.isEmpty()) {
            subProcess(tmpQueue.clone());
        }
        return result;
    }

    public void subProcess(ArrayDeque<TreeNode> queue) {
        List<Integer> tmpResult = new LinkedList<>();
        tmpQueue.clear();
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove();
            tmpResult.add(tmp.val);
            if (tmp.left != null) {
                tmpQueue.add(tmp.left);
            }
            if (tmp.right != null) {
                tmpQueue.add(tmp.right);
            }
        }
        System.out.println(tmpResult);
        result.add(tmpResult);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        traversal.levelOrder(root);
    }
}

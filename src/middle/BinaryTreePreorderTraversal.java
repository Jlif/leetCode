package middle;


import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * <p>
 * 其实，所谓的前中后序主要是看节点本身的位置在哪里，左节点总是比右节点遍历的
 *
 * @author JiangChen
 * @date 2020/05/08
 */
public class BinaryTreePreorderTraversal {

    private List<Integer> list = new ArrayList<>();

    //方法一：递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}
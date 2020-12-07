package problems;

import utils.TreeNode;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/same-tree/">Same Tree</a>
 */
public class SameTree {

    public static void main(String... args) {

        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);
        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);
        System.out.println(isSameTree(p1, q1));

        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);
        TreeNode q2 = new TreeNode(1);
        q1.right = new TreeNode(2);
        System.out.println(isSameTree(p2, q2));
    }

    /**
     * @param p
     * @param q
     * @return
     */
    private static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.data != q.data) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}


/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node
to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.
 */
public class _124BTMaxiPathSum {
    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node){
        if (node == null) return 0;

        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        int price_newpath = node.val + left_gain + right_gain;

        max_sum = Math.max(max_sum, price_newpath);

        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root){
        max_gain(root);
        return max_sum;
    }
}

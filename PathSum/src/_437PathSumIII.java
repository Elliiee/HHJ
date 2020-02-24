/*
Find the number of paths that sum to a given value from a binary tree.
The path does not need to start or end at the root or a leaf, but it
must go downwards.
 */
public class _437PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return pathSumFrom(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    public int pathSumFrom(TreeNode node, int sum){
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val)
                + pathSumFrom(node.right, sum - node.val);
    }
}

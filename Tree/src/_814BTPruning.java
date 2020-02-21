public class _814BTPruning {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node){
        if (node == null) return false;

        boolean oneLeft = containsOne(node.left);
        boolean oneRight = containsOne(node.right);
        if (!oneLeft)
            node.left = null;
        if (!oneRight)
            node.right = null;
        return node.val == 1 || oneLeft || oneRight;
    }
}

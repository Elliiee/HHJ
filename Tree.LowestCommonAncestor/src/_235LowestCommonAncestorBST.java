public class _235LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q){
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal < parentVal && qVal <parentVal){
            return lowestCommonAncestorRecursion(root.left, p, q);
        }
        else if (pVal > parentVal && qVal > parentVal){
            return lowestCommonAncestorRecursion(root.right, p, q);
        }
        else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestorBSTIteration(TreeNode root, TreeNode p, TreeNode q){
        int pVal = p.val;
        int qVal = q.val;

        TreeNode node = root;

        while (node != null){
            int parentVal = node.val;
            if (pVal > parentVal && qVal > parentVal){
                node = node.right;
            }
            else if (pVal < parentVal && qVal < parentVal){
                node = node.left;
            }
            else {
                return node;
            }
        }
        return null;
    }
}

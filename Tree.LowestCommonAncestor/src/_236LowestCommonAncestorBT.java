import java.util.*;

public class _236LowestCommonAncestorBT {
    private TreeNode ans;

    public _236LowestCommonAncestorBT() {
        this.ans = null; // variable to store LCA node
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q){
        if (currentNode == null) return false; // reach the end

        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        if (mid + left + right >= 2){
            this.ans = currentNode;
        }

        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        this.recurseTree(root, p, q);
        return this.ans;
    }

    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q){
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();

            if (node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        while (p != null){
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}

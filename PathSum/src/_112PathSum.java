import java.util.LinkedList;

public class _112PathSum {
    public boolean hasPathSumRecursion(TreeNode root, int sum) {
        // recursively call the method itself till the leaf node
        // and then check if the sum == targeted sum
        if (root == null) return false;

        sum -= root.val;

        if ((root.left == null) && (root.right == null))
            return (sum == 0);

        return hasPathSumRecursion(root.left, sum) || hasPathSumRecursion(root.right, sum);
    }

    public boolean hashPathSumIteration(TreeNode root, int sum){
        if (root == null) return false;

        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<Integer> sum_stack = new LinkedList<>();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int curr_sum;
        while (!node_stack.isEmpty()){
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();

            if (node.right == null && node.left == null && curr_sum == 0)
                return true;

            if (node.right != null){
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }

            if (node.left != null){
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }
}

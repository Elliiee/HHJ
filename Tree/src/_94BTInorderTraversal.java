import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _94BTInorderTraversal{
    public List<Integer> inorderRecursion(TreeNode root){
        List<Integer> output = new ArrayList<>();
        recursionHelper(root, output);
        return output;
    }

    public void recursionHelper(TreeNode root, List<Integer> output){
        if (root != null){
            if (root.left != null)
                recursionHelper(root.left, output);
            output.add(root.val);
            if (root.right != null)
                recursionHelper(root.right, output);
        }
    }

    public List<Integer> inorderIteration(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) return output;

        TreeNode node = root;
        while (node != null ||!stack.isEmpty()){
            while (node != null){
                stack.add(node);
                node = node.left;
            }
            node = stack.pollLast();
            output.add(node.val);
            node = node.right;
        }

        return output;
    }
}

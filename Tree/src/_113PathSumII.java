import java.util.ArrayList;
import java.util.List;

public class _113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        this.recurseTree(root, sum, pathNodes, pathsList);
        return pathsList;
    }

    private void recurseTree(TreeNode node, int remainingSum, List<Integer> pathNodes, List<List<Integer>> pathsList){
        if (node == null) return;

        pathNodes.add(node.val);

        if (remainingSum == node.val && node.left == null && node.right == null){
            pathsList.add(new ArrayList<>(pathNodes));
        }
        else {
            recurseTree(node.left, remainingSum - node.val, pathNodes, pathsList);
            recurseTree(node.right, remainingSum - node.val, pathNodes, pathsList);
        }

        // pop the node once we are done processing all of its subtrees
        pathNodes.remove(pathNodes.size() - 1);
    }
}

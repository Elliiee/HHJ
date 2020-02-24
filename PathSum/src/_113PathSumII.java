import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum
equals to the given sum.
 */
public class _113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        // use DFS, find 1 and then put it in the result list;
        // use BFS will be super heavy on memory
        List<List<Integer>> pathsList = new ArrayList<>();
        List<Integer> pathNodes = new ArrayList<>();
        this.recursiveTree(root, sum, pathNodes, pathsList);
        return pathsList;
    }

    private void recursiveTree(TreeNode node, int remainingSum,
                               List<Integer> pathNodes,
                               List<List<Integer>> pathsList){
        if (node == null) return;

        pathNodes.add(node.val);

        if (remainingSum == node.val && node.left == null && node.right == null){
            pathsList.add(new ArrayList<>());
        } else {
            this.recursiveTree(node.left, remainingSum - node.val,
                    pathNodes, pathsList);
            this.recursiveTree(node.right, remainingSum - node.val,
                    pathNodes, pathsList);
        }
        pathNodes.remove(pathNodes.size() - 1); // !!!
    }
}

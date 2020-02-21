import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).
 */
public class _107BTLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottomUpBFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> output = new LinkedList<>();

        if (root == null) return output;

        queue.offer(root);
        while (!queue.isEmpty()){
            int numOfLevel = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < numOfLevel; i++){
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                level.add(queue.poll().val);
            }
            output.add(0, level);  // add the new level at the first position is the only difference.
        }

        return output;
    }

    public List<List<Integer>> levelOrderBottomUpDFS(TreeNode root){
        List<List<Integer>> output = new LinkedList<>();
        levelMaker(output, root, 0);
        return output;
    }

    public void levelMaker(List<List<Integer>> output, TreeNode root, int level){
        if (root == null) return ;

        if (level >= output.size())
            output.add(0, new LinkedList<>());

        levelMaker(output, root.left, level + 1);
        levelMaker(output, root.right, level + 1);
        output.get(output.size() - (level + 1)).add(root.val);
    }
}

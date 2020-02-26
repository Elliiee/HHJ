
import java.util.HashSet;
import java.util.Set;

/*
Given a binary tree, we install cameras on the nodes of the tree.
Each camera at a node can monitor its parent, itself, and its immediate children.
Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 */
public class _968BinaryTreeCameras {
    // try to cover the camera from the bottom up
    int ans;
    Set<TreeNode> covered;

    public int minCameraCover(TreeNode root){
        ans = 0;
        covered = new HashSet<>();
        covered.add(null);

        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode node, TreeNode parent){
        if (node != null){
            dfs(node.left, node);
            dfs(node.right, node);

            if (parent == null && (!covered.contains(node) ||
                                    !covered.contains(node.left) ||
                                    !covered.contains(node.right))) {
                ans++;
                covered.add(node);
                covered.add(parent);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
}

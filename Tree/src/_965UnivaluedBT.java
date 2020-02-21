import java.util.ArrayList;
import java.util.List;

/*
A binary tree is univalued if every node in the tree has the same value.
 */
public class _965UnivaluedBT {
    List<Integer> vals;
    public boolean isUnivalTree(TreeNode root) {
        // dfs -- compare all the values
        vals = new ArrayList<>();
        dfs(root);
        for (int v : vals){
            if (v != vals.get(0))
                return false;
        }
        return true;
    }

    public void dfs(TreeNode node){
        if (node != null){
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
}

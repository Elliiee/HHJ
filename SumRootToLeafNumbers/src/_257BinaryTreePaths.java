import java.util.LinkedList;
import java.util.List;

// Given a binary tree, return all root-to-leaf paths.
public class _257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        construct_paths(root, "", paths);
        return paths;
    }

    public void construct_paths(TreeNode root, String path, LinkedList<String> paths){
        if (root != null){
            path += Integer.toString(root.val);

            if (root.left == null && root.right == null)
                paths.add(path);
            else {
                path += "->";
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _987VerticalOrderTraversalBT {
    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locations = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(locations);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        int prev = locations.get(0).x;

        for (Location loc : locations){
            if (loc.x != prev){
                prev = loc.x;
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(loc.val);
        }

        return ans;
    }

    public void dfs(TreeNode node, int x, int y){
        if (node != null){
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x-1, y+1);
            dfs(node.right, x+1, y+1);
        }
    }
}

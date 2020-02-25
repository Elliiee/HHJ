import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _508MostFrequentSubtreeSum {
    // use a hash map to count the subtree sum occurence
    Map<Integer, Integer> count = new HashMap<>();
    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (int sum : count.keySet()){  // !!
            if (count.get(sum) == maxCount)
                res.add(sum);
        }
        return res.stream().mapToInt(i -> i).toArray(); // !!
    }

    // dfs recursively calculate the sum of subtree and increment the count
    private int dfs(TreeNode root){
        if (root == null) return 0;

        int sum = dfs(root.left) + dfs(root.right) + root.val;

        count.put(sum, count.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, count.get(sum));
        return sum;
    }
}

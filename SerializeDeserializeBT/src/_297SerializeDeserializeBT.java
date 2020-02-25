import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _297SerializeDeserializeBT {
    public String rserialize(TreeNode root, String str){
        // recursive serialization
        if (root == null){
            str += "null";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root){
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> list){
        if (list.get(0).equals("null")){
            list.remove(0);
            return  null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }

    public TreeNode deserialize(String data){
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
}

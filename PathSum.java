import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PathSum {

    public int hasPathSum(TreeNode root, int target) {
        if(root==null && target==0){
            return 1;
        }
        Map<TreeNode,Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root,target-root.val);

        while(!queue.isEmpty()){
            TreeNode node =  queue.remove();
            int tempTarget = map.get(node);
            if(node.left==null && node.right==null && map.get(node)==0){
                return 1;
            }
            if(node.left!=null){
                queue.add(node.left);
                map.put(node.left, tempTarget-node.left.val);
            }
            if(node.right!=null){
                queue.add(node.right);
                map.put(node.right, tempTarget-node.right.val);
            }

        }
        return 0;
    }
}

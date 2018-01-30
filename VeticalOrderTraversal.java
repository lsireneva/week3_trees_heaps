import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class VeticalOrderTraversal {


    public static void main(String[] args) {
        // binary tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(9);

        System.out.println(verticalOrderTraversal(root));




    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int min=0;
        int max=0;

        if(A==null)
            return result;

        // map for distance and list of values
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> distance = new LinkedList<Integer>();

        queue.add(A);
        distance.add(0);

        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            int d = distance.poll();

            //checking min and max distance
            min=Math.min(min, d);
            max=Math.max(max, d);

            if(map.containsKey(d)){
                map.get(d).add(p.val);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(p.val);
                map.put(d, list);
            }

            if(p.left!=null){
                queue.add(p.left);
                distance.add(d-1);
            }

            if(p.right!=null){
                queue.add(p.right);
                distance.add(d+1);
            }
        }


        for(int i=min; i<=max; i++){
            if(map.containsKey(i)){
                result.add(map.get(i));
            }
        }

        return result;
    }
}

import java.util.ArrayList;
import java.util.Stack;

public class ZigzagOrderTraversal {

    public static void main(String[] args) {
        // binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));

    }

    public static ArrayList<ArrayList<Integer>>  zigzagLevelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Stack<TreeNode> stack1=new Stack<TreeNode>();
        stack1.push(A);

        boolean direction=false;

        while(!stack1.isEmpty())
        {
            Stack<TreeNode> stack2=new Stack<TreeNode>();
            ArrayList<Integer> list=new ArrayList<Integer>();
            while(!stack1.isEmpty())
            {
                TreeNode node=stack1.pop();
                list.add(node.val);
                if (!direction) {
                    if(node.left!=null) stack2.push(node.left);
                    if(node.right!=null) stack2.push(node.right);
                } else {
                    if(node.right!=null) stack2.push(node.right);
                    if(node.left!=null) stack2.push(node.left);
                }
            }
            direction=!direction;
            result.add(list);
            stack1=stack2;
        }
        return result;
    }

}

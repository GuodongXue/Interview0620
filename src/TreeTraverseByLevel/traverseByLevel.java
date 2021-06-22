package TreeTraverseByLevel;

import sun.misc.Queue;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class traverseByLevel {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> bnyLevel(TreeNode root){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while(!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i <size; i++){
                TreeNode remove = nodes.remove(0);
                list.add(remove.val);

                if(remove.left != null){
                    nodes.add(remove.left);
                }
                if(remove.right != null){
                    nodes.add(remove.right);
                }

            }
            res.add(list);
        }


    return res;

    }
}

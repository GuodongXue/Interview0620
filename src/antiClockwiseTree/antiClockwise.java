package antiClockwiseTree;

public class antiClockwise {
    public static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }


    //find the tree height
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(1+ leftHeight, 1+rightHeight);
    }


    //print the nodes form left to right
    public static void leftToRight(Node root, int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.data +" ");
        }else if(level>1){
            leftToRight(root.left, level-1);
            leftToRight(root.right, level-1);
        }

    }

    //print the nodes from right to left
    public static void rightToLeft(Node root, int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.data +" ");
        }else if(level>1){
            rightToLeft(root.right, level-1);
            rightToLeft(root.left, level-1);
        }
    }


    //antiClockwise
    public static void antiClockwise(Node root){
        int i = 1;
        int j = height(root);

        int flag = 0;
        while (i <= j){
            if( flag == 0){
                rightToLeft(root, i);
                flag = 1;
                i++;
            }else {
                leftToRight(root, j);
                flag = 0;
                j--;
            }


        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        antiClockwise(root);

    }
}

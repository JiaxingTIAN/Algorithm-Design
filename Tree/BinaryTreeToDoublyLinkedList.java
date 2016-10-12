/**
 * Created by jxtain on 10/11/16.
 */
public class Solution {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    public static Node toList(Node root){
        if(root == null){   //base case
            return null;
        }
        //recursively call for left subtree
        if(root.left != null){
            Node left = toList(root.left);
            while(left.right != null){
                left = left.right;
            }
            left.right = root;
            root.left = left;
        }
        //right subtree
        if(root.right != null){
            Node right = toList(root.right);
            while (right.left != null){
                right = right.left;
            }
            right.left = root;
            root.right = right;
        }
        return root;

    }
    public static Node convertBT(Node root){
        Node node = toList(root);
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
    public static void main(String[] args){
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n3.left = n1;
        n1.left = n0;
        n1.right = n2;
        n3.right = n5;
        n5.left = n4;
        n5.right = n6;
        Node root = convertBT(n3);
        while(root != null){
            System.out.print(root.val);
            root = root.right;
        }
    }

}

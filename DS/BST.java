package DS;

import java.util.ArrayDeque;
import java.util.Queue;

public class BST {
    Node root;

    private class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    public void construct(int[] arr) {
        for(int ele : arr) {
            //create node with the element
            Node node = new Node(ele);
            if(root == null) {
                root = node;
            } else {
                Node leader = root;
                Node follower = null;
                while(leader != null) {
                    //compare
                    if(ele < leader.data) {
                        follower = leader;
                        leader = leader.left;
                    } else {
                        follower = leader;
                        leader = leader.right;
                    }
                }
                //final comparision and insert
                if(ele < follower.data) {
                    //add the new node left branch
                    follower.left = node;
                } else {
                    //add as right branch
                    follower.right = node;
                }
            }
        }
    }

    public Node construct(Node root, int ele) {
        //base-case:
        if(root == null) {
            return new Node(ele);
        }

        //recursive-case:
        if(ele < root.data) {
            root.left = construct(root.left, ele);
        } else {
            root.right = construct(root.right, ele);
        }
        return root;
    }

    public void lvlOrderTraversal(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for(int i = 0; i < count; i++) {
                //rpa
                Node removed = queue.remove();
                System.out.print(removed.data + ", ");
                if(removed.left != null) {
                    queue.add(removed.left);
                }
                if(removed.right != null) {
                    queue.add(removed.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 5, 6, 2, 4, 9, 7};
        BST tree = new BST();
        // tree.construct(arr);
        Node root = tree.construct(null, arr[0]);
        for(int i = 1; i < arr.length; i++) {
            tree.construct(root, arr[i]);
        }
        tree.lvlOrderTraversal(root);
    }
}

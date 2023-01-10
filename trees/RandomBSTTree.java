package trees;

import java.util.Scanner;

public class RandomBSTTree
{
    private static final Scanner SC = new Scanner(System.in);
    Node root;
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node create() {
        Node root = null;
        System.out.println("Enter data: ");
        int data = SC.nextInt();
        if(data == -1) {
            return null;
        } else {
            root = new Node(data);
            System.out.println("Enter left-child for " + root.data);
            root.left = create();
            System.out.println("Enter right-child for " + root.data);
            root.right = create();
        }
        return root;
    }

    public void preOrder(Node node) {
        //base-case:
        if(node == null) {
            return;
        }

        //recursive - case:
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args)
    {
        RandomBSTTree tree = new RandomBSTTree();
        Node root = tree.create();
        tree.preOrder(root);
    }
}

import java.util.Scanner;

public class BinaryTree {

    private Node root;
    private static class Node{
        private int value;
        Node left;
        Node right;
        int height;

        public Node(int value){
            this.value = value;
        }

        public int getHeight() {
            return height;
        }
    }

    public BinaryTree(){
        //Initializing the Binary tree;
    }

    public void populate(Scanner sc){
        System.out.println("Enter the root value -> ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(root, sc); // to populate left and right of root
    }

    //helper function
    private void populate(Node node, Scanner sc){
        System.out.println("Enter left value of " + node.value + " (-1 if not) -> ");
        int leftvalue = sc.nextInt();

        if(leftvalue != -1){
            node.left = new Node(leftvalue);
            populate(node.left, sc);
        }

        System.out.println("Enter right value of " + node.value + " (-1 if not) -> ");
        int rightvalue = sc.nextInt();

        if(rightvalue != -1){
            node.right = new Node(rightvalue);
            populate(node.right, sc);
        }

    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent){
        //Base condition
        if(node == null){
            return;
        }

        System.out.println(indent + node.value);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
    }

}

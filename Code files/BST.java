public class BST {
    private Node root;
    private static class Node{
        private int value;
        Node left;
        Node right;
        private int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }

        public int getHeight() {
            return height;
        }
    }

    public BST(){
        //Initializing BST
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int height(Node node){
        if(node == null) return -1;
        return node.getHeight();
    }

    public void insert(int value){
        if(isEmpty()){
            root = new Node(value);
            return;
        }
        insertHelper(root, value);
    }

    private void insertHelper(Node node, int value){
        //insert to the left subtree
        if(node.value > value){
            if(node.left == null){
                node.left = new Node(value);
            }else{
                insertHelper(node.left,value);
            }
        }else if(node.value < value){
            if(node.right == null){
                node.right = new Node(value);
            }else{
                insertHelper(node.right,value);
            }
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    public boolean balanced(){
        return balancedHelper(root);
    }

    private boolean balancedHelper(Node node)
    {
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balancedHelper(node.left) && balancedHelper(node.right);

    }
    public void display(){
        if(root == null){
            System.out.println("The tree is empty!");
            return;
        }

        display(root, "Root node : ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }

        System.out.println(details + node.getValue() + " (Height " + node.getHeight() + ") ");

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

    public void populateSorted(int[] values){
        populateSorted(values, 0, values.length-1);
    }

    private void populateSorted(int[] input, int start, int end){
        if(start > end){
            return;
        }

        int mid = (start + end) / 2;

        this.insert(input[mid]);

        populateSorted(input, start, mid-1);
        populateSorted(input, mid+1, end);
    }
}

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public LinkedList(){
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void insertAtFront(int value){
        Node node = new Node(value);

        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void display(){
        Node temp = head;

        System.out.print("START --> ");

        while(temp != null){
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }

        System.out.print("END");
        System.out.println();
    }

    public void insertAtLast(int value){
        Node node = new Node(value);

        if(tail == null){
            insertAtFront(value);
            return;
        }

        tail.next = node;
        tail = node;
        size++;
    }

    public Node get(int position){

        Node temp = head;

        for(int i = 0; i < position - 1; i++){
            temp = temp.next;
        }

        return temp;
    }

    public void deleteAtLast(){
        Node node = get(size - 1);

        tail = node;
        tail.next = null;
        size--;
    }

    public void deleteAtIndex(int index){
        Node node = get(index);

        node.next = node.next.next;
        size--;
    }

    public void deleteAtFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        size--;
    }

    public boolean find(int value){
        Node temp = head;

        while(temp != null){
            if(temp.value == value){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}



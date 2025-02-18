import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bt = new BST();
        int[] arr = {1,2,3,4,5,6,7,8,9};
//        bt.insert(15);
//        bt.insert(10);
//        bt.insert(20);
//        bt.insert(5);
//        bt.insert(12);
//        bt.insert(8);
        bt.populateSorted(arr);
        bt.display();
        //System.out.println(bt.balanced());
    }
}

package StackPractice;

public class main {
    public static void main(String[] args) {
        stack ds = new dynamicStack(5);

        ds.push(5);
        ds.push(7);
        ds.push(5);
        ds.push(7);
        ds.push(5);
        ds.push(7);
        ds.push(5);
        ds.push(7);

        ds.display();

    }
}

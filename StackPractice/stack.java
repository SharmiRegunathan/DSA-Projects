package StackPractice;

public class stack {
    private static final int defaultSize = 10;
    protected int[] arr;
    int top = -1;

    int size;

    public stack(int size){
        this.size = size;
        this.arr = new int[size];
    }

    public stack(){
        this(defaultSize);
    }

    public void push(int val){
        top++;
        arr[top] = val;
        System.out.println("Element " + val + " is pushed into the stack");
    }

    public void display(){
        for(int i = top; i >= 0; i--){
            System.out.print(arr[i] + " --> ");
        }
        System.out.print("END");
        System.out.println();


    }

    public int top(){
        return arr[top];
    }

    public int getMaxSize() {
        return size;
    }

    public void pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot pop from an Empty stack!");
        }
        System.out.println("Element " + arr[top] + " is popped from the stack");
        top--;
//        return arr[top--];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void clear(){
        top = -1;
        System.out.println("Stack is cleared!");
    }

    public int getSize() {
        return top+1;
    }

    public boolean isFull(){
        return top==arr.length-1;
    }
}

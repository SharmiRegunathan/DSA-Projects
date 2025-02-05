package StackPractice;

public class dynamicStack extends stack{

    public dynamicStack(int size){
        super(size);
    }

    public void push(int val){
        if(isFull()){
            int[] temp = new int[arr.length*2];
            for(int i = 0; i < arr.length; i++){
                temp[i] = arr[i];
            }
            arr = temp;
        }

        super.push(val);
    }

}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Recursion {
    public static void main(String[] args) {
    }

    static int[] mergeSortArray(int[] arr){
        if(arr.length == 1) return arr;

        int m = arr.length/2;

        int[] left = mergeSortArray(Arrays.copyOfRange(arr, 0 , m));
        int[] right = mergeSortArray(Arrays.copyOfRange(arr, m , arr.length));

        return merge(left,right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] ans = new int[left.length+right.length];

        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                ans[k++] = left[i++];
            }else{
                ans[k++] = right[j++];
            }
        }

        while(i < left.length){
            ans[k++] = left[i++];
        }

        while (j < right.length){
            ans[k++] = right[j++];
        }

        return ans;
    }

    static void mergeSortInplace(int[] arr, int s, int e){
        if(s == e) return;

        int m = (s+e)/2;

        mergeSortInplace(arr, s, m);
        mergeSortInplace(arr,m+1,e);

        merge(arr, s, m ,e);
    }

    static void merge(int[] arr, int s, int m, int e) {
        int[] ans = new int[e-s+1];

        int i = s, j = m+1, k = 0;

        while(i <= m && j <= e){
            if(arr[i] < arr[j]){
                ans[k++] = arr[i++];
            }else{
                ans[k++] = arr[j++];
            }
        }

        while(i <= m){
            ans[k++] = arr[i++];
        }

        while (j <= e){
            ans[k++] = arr[j++];
        }

        for(int l = 0;l < ans.length; l++){
            arr[s+l] = ans[l];
        }
    }

    static void triange1(int row, int col){
        if(row == 0){
            return;
        }

        if(row == col){
            System.out.println();
            triange1(row - 1, 0);
        }else{
            System.out.print("* ");
            triange1(row, col + 1);
        }
    }

    //using recursion
    static void bubbleSort(int[] arr, int row, int col){
        if(row == 0){
            return;
        }

        if(row == col){
            bubbleSort(arr, row - 1, 0);
        }else{
            if(arr[col] > arr[col+1]){
                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1] = temp;
            }
            bubbleSort(arr, row, col + 1);
        }
    }

    static void selectionSort(int[] arr, int row, int col){
        if(row == 0){
            return;
        }

        if(row == col){
            selectionSort(arr, row - 1, 0);
        }else{
            if(arr[col] > arr[row]) {
                int temp = arr[col];
                arr[col] = arr[row];
                arr[row] = temp;
            }
            selectionSort(arr, row, col + 1);
        }
    }

    static boolean sortedOrNot(int[] arr, int i){
        if(i == arr.length-1){
            return true;
        }

        return (arr[i] < arr[i+1]) && sortedOrNot(arr,++i);
    }

    static List<Integer> linearSearch(int[] arr, int target, int i, List<Integer> ls){
        if(i == arr.length){
            return ls;
        }

        if(arr[i] == target) ls.add(i);

        return linearSearch(arr,target,++i,ls);
    }

    static List<Integer> linearSearch(int[] arr, int target, int i){
        List<Integer> ls = new ArrayList<>();

        if(i == arr.length){
            return ls;
        }

        //ls will contain the answer for that function only
        if(arr[i] == target) ls.add(i);

        //ansFromBelowCalls will contain the list from all the below calls
        List<Integer> ansFromBelowCalls = linearSearch(arr,target,++i);

        //add it to the current list ls
        ls.addAll(ansFromBelowCalls);

        //return it when going back up
        return ls;
    }
    static void printNto1(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printNto1(n-1);
    }


    static void print1toN(int n){
        if(n == 0){
            return;
        }
        print1toN(n-1);
        System.out.println(n);
    }

    static int sumOfN(int n){
        if(n <= 1){
            return n;
        }

        return n + sumOfN(n-1);
    }

    static int sumOfdigits(int n){
        if(n <= 0){
            return 0;
        }

        return (n%10) + sumOfdigits(n/10);
    }

    // Cannot be considered pure recursion as we use a separate variable sum to compute the sum
    // Recursion only takes place to break down the number into multiple subsets
    static int sum = 0;
    static int revNum1(int n){
        if(n==0) return 0;

        int rem = n%10;
        sum = (sum*10) + rem;

        revNum1(n/10);

        return sum;
    }

    static int revNum2(int n){
        if(n==0) return 0;

        int base = (int) Math.log10(n);

        return (int)((n%10)*Math.pow(10,base)) + revNum2(n/10);
    }

    static boolean palindrome(int n){
        return n == revNum2(n);
    }

    // ans is the value computed in each step
    // in every recursion call, a count value is computed and will be added to the answer as the stack is cleared
    static int countZeros(int n){
        if(n==0) return 0;

        int rem = n%10;
        if(rem == 0) {
            return 1 + countZeros(n/10);
        }
        return countZeros(n/10);
    }

    //Leetcode question 1342
    // the final recursion call will have the end answer we need as count

    static int stepCount(int n){
        return helper(n, 0);
    }

    static int helper(int n, int count){
        if(n==0){
            return count;
        }
        if(n%2==0){
            return helper(n/2, ++count);
        }else{
            return helper(n-1, ++count);
        }
    }

}


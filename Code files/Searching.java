import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searching {
    public static void main(String[] args) {
        //Hello
        int[][] arr = {{10,20,30,40},{15,25,35,45},{28,29,37,47},{33,34,39,50}};
        System.out.println(Arrays.toString(searchIn2D(arr,35)));
    }

    public static int[] searchIn2D(int[][] arr, int target){
        int[] ans = {-1,-1};

        int lb = 0;
        int ub = arr[0].length-1;

        while(lb < arr.length && ub >= 0){
            if(arr[lb][ub] == target){
                ans[0] = lb;
                ans[1] = ub;
                return ans;
            }else if(arr[lb][ub] < target){
                lb++;
            }else{
                ub--;
            }
        }
        return ans;
    }

    public static int findKthPositive(int[] arr, int k) {
        List<Integer> ls = new ArrayList<>();

        for(int i = 1; i < arr[0]; i++){
            ls.add(i);
        }
        for(int i = 0; i < arr.length-1; i++){
            int elem = arr[i];
            int next = arr[i+1];

            for(int j = elem+1; j < next; j++){
                ls.add(j);
            }
        }

        int lastElem = arr[arr.length-1]+1;
        int limit = k;
        if(ls.size() < limit){
            while(limit>0){
                ls.add(lastElem++);
                limit--;
            }
        }

        return ls.get(k-1);
    }

    static boolean linearSearch(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) return true;
        }
        return false;
    }

    static int linearSearch2(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) return i;
        }
        return -1;
    }

    // Binary Search

    static int findUnique(int[] arr){

        //skipping the first and last elems as the comparison for mid is always the before and next elem.
        int start = 1;
        int end = arr.length-2;

        //since the first and last elem is skipped, we make sure to check if they are the answer or not
        if(arr.length == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[arr.length-1] != arr[arr.length-2]) return arr[arr.length-1];

        while(start <= end){
            int mid = start + (end-start) / 2;

            //check if it is the unique element
            if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
                return arr[mid];
            }
            else{
                //left side of the unique element
                if((mid % 2 == 0 && arr[mid+1] == arr[mid]) || (mid % 2 == 1 && arr[mid-1] == arr[mid])){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

}

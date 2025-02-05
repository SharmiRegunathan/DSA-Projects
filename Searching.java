public class Searching {
    public static void main(String[] args) {

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

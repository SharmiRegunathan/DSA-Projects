import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    static int[] intersection(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int m = nums1.length;
        int n = nums2.length;

        int[] ans = new int[Math.min(m,n)];

        int i = 0, j = 0, k = 0;

        while(i < m && j < n){
            if(nums1[i] == nums2[j]){
                if(ans[k] != nums1[i]){
                    ans[++k] = nums1[i];
                    i++;
                    j++;
                }
            }else{
                if(nums1[i] > nums2[j]) j++;
                else i++;
            }
        }

        return Arrays.copyOf(ans, k+1);


    }

    //bubble sort
    // compare the consecutive elements of the array and swap them
    static int[] bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        return arr;
    }

    // Insertion sort
    // Left is sorted sub-array - Right will be unsorted
    // In each iteration, one element from right is taken and put in the correct position in the right
    static int[] insertionSort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

        return arr;
    }

    // Selection sort
    // keep finding the min or max and put it in the right position
    static int[] selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        return arr;
    }
}

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

public class Array_Easy {
    public static void main(String[] args) {
        int[] arr = {3,4,9};
        System.out.println(Arrays.toString(arrayTransform(arr)));
//        int[][] mat = {{1,2},{3,4}};
//        System.out.println(Arrays.toString(matrix(mat,2,4)));
    }

    public static int[] arrayTransform(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            arr = transform(arr);
        }

        return arr;
    }

    public static int[] transform(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                arr[i] += 3;
            }
            else if(arr[i] % 2 == 0){
                arr[i] -= 3;
            }
        }

        return arr;
    }

    public static int[][] reshapeMatrix(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];

        List<Integer> list = new ArrayList<Integer>();

        for(int[] arr: mat){
            for(int elem: arr){
                list.add(elem);
            }
        }

        int k = 0;
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[i].length; j++){
                res[i][j] = list.get(k++);
            }
        }

        return res;
    }

    static int[] rotateBykRight(int[] arr, int k) {
        int[] temp = new int[k];

        int n = arr.length;

        int j = 0;
        for(int i = n-k; i < n; i++){
            temp[j++] = arr[i];
        }

        for(int i = n-k-1; i >= 0; i--){
            arr[i+k] = arr[i];
        }

        for(int i = 0; i < temp.length; i++){
            arr[i] = temp[i];
        }

        return arr;
    }

    //Rotate an array by k to the left
    static int[] rotateBykLeft(int[] arr, int k) {
        int[] temp = new int[k];

        int n = arr.length;

        int j = 0;
        for(int i = 0; i < k; i++){
            temp[j++] = arr[i];
        }

        for(int i = k; i < n; i++){
            arr[i-k] = arr[i];
        }

        for(int i = n-k; i < n; i++){
            arr[i] = temp[i-(n-k)];
        }

        return arr;
    }

    //arr = [1, 2, 3, 4, 5]
//    Output: [2, 3, 4, 5, 1]
//
//    Steps-> 0. Store the first elem in placeholder and start from right to left
//    1. Store the current element in temp
//    2. Swap current with placeholder
//    3. Placeholder becomes temp
    static int[] leftRotateArray1(int[] arr, int n) {

        int placeholder = arr[0];

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = placeholder;
            placeholder = temp;

        }

        return arr;
    }

    // Store first element
    // Swap all the next elements i = 1 to n as arr[i-1] = arr[i]
    // Put first element at last
    static int[] leftRotateArray2(int[] arr, int n) {
        // Write your code here.

        int placeholder = arr[0];

        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        arr[n - 1] = placeholder;

        return arr;

    }

    static int[] rightRotateArray(int[] arr, int n) {
        // Write your code here.

        int placeholder = arr[n - 1];

        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            arr[i] = placeholder;
            placeholder = temp;

        }

        return arr;
    }


    // Rotation of an array - Optimized method
    static int[] rotationOptimal(int[] arr, int k) {

        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr, 0, arr.length-1);

        return arr;
    }

    // Move the zeroes to the end of array
    static int[] moveZeros(int[] arr) {

        int i = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] != 0){
                arr[i] = arr[j];
                i++;
            }
        }

        while(i < arr.length){
            arr[i] = 0;
            i++;
        }

        return arr;
    }

    //Output the missing number from the array
    // Brute force - Loop thru numbers from 1 to n - for each elem, search in the array and see if it exists
    // Input example -> [ 1, 2, 3, 5 ]
    static public int missingNumber(int[] arr, int n){
        for(int i = 1; i <= n; i++){
            int flag = 0;
            for(int j = 0 ; j < arr.length; j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            //flag comes out of the loop as 0, which means there
            // was no element equal to the current ith value
            if(flag == 0){
                return i;
            }
        }

        return -1;
    }


    // Better approach - use Hashing and check if any element equals 0
    static public int missingNumberBetter(int[] arr, int n){
        int[] hash = new int[n+1];

        for(int elem : arr){
            hash[elem] = elem;
        }

        // if an element 0 exists, the corresponding index is the missing number
        for(int i = 1; i < hash.length; i++){
            if(hash[i] == 0){
                return i;
            }
        }

        return -1;
    }


    //reverse an array
    static public void reverse(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static public int maximumPopulation(int[][] logs) {
        int[] years = new int[3000];
        int max = 0;

        for(int[] arr: logs){
            years[arr[0]]++;
            years[arr[1]]--;
        }

        for(int i = 1950 ; i <= 2050 ; i++){
            max = max + years[i];
        }

        return max;
    }

    static int hashingSearch(int target, int max, int arr[]) {
        //If the target is greater than the max value, it will not be found in the hash array
        if (target > max) {
            return -1;
        }

        //Creating Hash array
        //Size of hash array will be the max element in provided in the array
        int[] hash = new int[max + 1];

        //Looping through the array and updating the hash array
        for (int element : arr) {
            hash[element] += 1;
        }
        return hash[target];
    }


    //Remove the duplicate elements from the array and return the number of unique numbers in the array

    //Brute approach
    //Space complexity is not O(1)
    static int removeDuplicates1(int n, int[] arr) {
        HashSet<Integer> elements = new HashSet<Integer>();
        for (int element : arr) {
            elements.add(element);
        }

//        int count = 0;
//        for(Integer element : elements){
//            count++;
//        }

        return elements.size();

    }

    //Works only for sorted integer
    //Optimal approach
    static int removeDuplicates2(int n, int[] arr) {
        int i = 0;

        for (int j = 0; j < n; j++) {
            if (arr[i] != arr[j]) { //a non-duplicate integer is found
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1;
    }


    // Basics

    static void fibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 0;

        System.out.println(a);
        System.out.println(b);

        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }

    static void factors(int n) {
        System.out.print(1 + " ");
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    static void sumOfN() {

        Scanner s = new Scanner(System.in);
        int sum = 0;

        System.out.println("Hello! Welcome to Calculator!");
        System.out.println();
        System.out.println("Keep Entering numbers and press 0 to stop");

        int input = s.nextInt();

        while (input != 0) {
            sum += input;
            System.out.println("The sum is " + sum);
            System.out.println();
            input = s.nextInt();
        }

        System.out.println("Thank you, Come again!");
    }

    static void largeOfN() {

        Scanner s = new Scanner(System.in);
        int large = -999;

        System.out.println("Hello! Welcome to Calculator!");
        System.out.println();
        System.out.println("Keep Entering numbers and press 0 to stop");

        int input = s.nextInt();

        while (input != 0) {
            if (input > large) large = input;
            System.out.println();
            input = s.nextInt();
        }

        System.out.println("Largest number you entered is " + large);
    }

    static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }



    static List<Integer> arrayToInteger(int[] num, int k) {
        long sum = 0;
        for (int elem : num) {
            sum = sum * 10 + elem;
        }

        sum += k;

        List<Integer> list = new ArrayList<>();
        while (sum > 0) {
            int remainder = (int) (sum % 10);
            list.add(0, remainder);
            sum /= 10;
        }

        return list;
    }

    static int[][] rotateMatrix(int[][] matrix, int n) {
        //Brute force
//        int[][] newMatrix = new int[n][n];
//
//        for(int i = 0;i < n;i++){
//            for(int j = 0; j < n; j++){
//                newMatrix[j][n-i-1] = matrix[i][j];
//            }
//        }
//        return newMatrix;

        matrix = transposeMatrix(matrix, n);

        for (int[] arr : matrix) {
            reverse(arr);
        }

        return matrix;
    }

    static int[][] transposeMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static int consecutiveNosBrute(int[] arr) {
        int longest = 1;

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int x = arr[i];
            while (linearSearch(arr, x + 1)) {
                count++;
                x++;
            }
            longest = Math.max(longest, count);
        }

        return longest;
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

    static int[] twoSum(int[] nums, int target) {
        int[] copy = nums.clone();
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);

        while (left < right) {
            int sum = 0;
            sum += nums[left] + nums[right];

            if (sum == target) {
                return new int[]{linearSearch2(copy, nums[left]), linearSearch2(copy, nums[right])};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {-1,-1};
    }


    static void setZeros(int[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;

        int[] row = new int[r];
        int[] col = new int[c];

        for(int i = 0; i < r ; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < r ; i++){
            for(int j = 0; j < c; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

            for(int i = 0 ; i < nums.length; i++){
            if(mpp.containsKey(nums[i])){
                int diff = Math.abs(i - mpp.get(nums[i]));
                if(diff <= k){
                    return true;
                }
            }else{
                mpp.put(nums[i],i);
            }
        }

            return false;
    }

}

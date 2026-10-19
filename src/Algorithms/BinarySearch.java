package Algorithms;

public class BinarySearch {
    static int binarySearch(int [] array, int target){
        int left = 0;
        int right = array.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(array[mid] == target){
                return mid;
            }else
                if(array[mid] < target){
                    left = mid - 1;
                }else{
                    right = mid + 1;
                }
        }

        return -1;
    }
    static void main() {
        int [] array = {3, 7, 11, 15, 19, 23, 27, 31, 25};
        int target = 27;

        int binarySearch = binarySearch(array, target);
        System.out.println(binarySearch);
    }
}

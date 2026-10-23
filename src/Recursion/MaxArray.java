package Recursion;

public class MaxArray {
    static int maxArray(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }

        int maxResto = maxArray(arr, index + 1);

        if (maxResto < arr[index]) {
            maxResto = arr[index];
        }

        return maxResto;
    }

    static void main() {
        int[] arr = {4, 9, 2, 7};
        System.out.println(maxArray(arr, 0));
    }
}
